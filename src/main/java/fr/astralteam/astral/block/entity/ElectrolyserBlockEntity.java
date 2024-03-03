package fr.astralteam.astral.block.entity;

import fr.astralteam.astral.item.ModItems;
import fr.astralteam.astral.recipe.ElectrolyserRecipe;
import fr.astralteam.astral.recipe.MetalCutterRecipe;
import fr.astralteam.astral.screen.ElectrolyserMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ElectrolyserBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4);

    public static final int WATER_INPUT_SLOT = 0;
    public static final int CANISTER_INPUT_SLOT = 1;
    public static final int OXYGEN_OUTPUT_SLOT = 2;
    public static final int HYDROGEN_OUTPUT_SLOT = 3;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 180;

    public ElectrolyserBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ELECTROLYSER_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> ElectrolyserBlockEntity.this.progress;
                    case 1 -> ElectrolyserBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> ElectrolyserBlockEntity.this.progress = pValue;
                    case 1 -> ElectrolyserBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };

    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.astral.electrolyser");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ElectrolyserMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("electrolyser.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("electrolyser.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<ElectrolyserRecipe> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().getOutput();
        ItemStack result2 = recipe.get().getOutput2();
        ItemStack result3 = recipe.get().getOutput3();
        this.itemHandler.extractItem(WATER_INPUT_SLOT, 1, false);
        this.itemHandler.extractItem(CANISTER_INPUT_SLOT, 3, false);

        this.itemHandler.setStackInSlot(OXYGEN_OUTPUT_SLOT, new ItemStack(result.getItem(), this.itemHandler.getStackInSlot(OXYGEN_OUTPUT_SLOT).getCount() + result.getCount()));
        this.itemHandler.setStackInSlot(HYDROGEN_OUTPUT_SLOT, new ItemStack(result2.getItem(), this.itemHandler.getStackInSlot(HYDROGEN_OUTPUT_SLOT).getCount() + 1 + result2.getCount()));this.itemHandler.setStackInSlot(WATER_INPUT_SLOT, new ItemStack(result3.getItem(), this.itemHandler.getStackInSlot(WATER_INPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<ElectrolyserRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        int canisterCount = itemHandler.getStackInSlot(CANISTER_INPUT_SLOT).getCount();

        ItemStack result = recipe.get().getOutput();
        ItemStack result2 = recipe.get().getOutput2();
        int oxygenOutputCount = result.getCount();
        int hydrogenOutputCount = result2.getCount();

        return canisterCount >= 3 &&
                canInsertOxygenAmountIntoOutputSlot(oxygenOutputCount) &&
                canInsertOxygenItemIntoOutputSlot(result.getItem()) &&
                canInsertHydrogenAmountIntoOutputSlot(hydrogenOutputCount) &&
                canInsertHydrogenItemIntoOutputSlot(result2.getItem());
    }

    private Optional<ElectrolyserRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(ElectrolyserRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertHydrogenItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(HYDROGEN_OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(HYDROGEN_OUTPUT_SLOT).is(item);
    }

    private boolean canInsertHydrogenAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(HYDROGEN_OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(HYDROGEN_OUTPUT_SLOT).getMaxStackSize();
    }
    private boolean canInsertOxygenItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OXYGEN_OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OXYGEN_OUTPUT_SLOT).is(item);
    }
    private boolean canInsertOxygenAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OXYGEN_OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OXYGEN_OUTPUT_SLOT).getMaxStackSize();
    }


}
