package fr.astralteam.astral.block.entity;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ASTRAL.MODID);

    public static final RegistryObject<BlockEntityType<ElectrolyserBlockEntity>> ELECTROLYSER_BE = BLOCK_ENTITIES.register("electrolyser_be", () -> BlockEntityType.Builder.of(ElectrolyserBlockEntity::new, ModBlocks.ELECTROLYSER.get()).build(null));
    public static final RegistryObject<BlockEntityType<MetalCutterBlockEntity>> METALCUTTER_BE = BLOCK_ENTITIES.register("metal_cutter_be", () -> BlockEntityType.Builder.of(MetalCutterBlockEntity::new, ModBlocks.METAL_CUTTER.get()).build(null));
    public static final RegistryObject<BlockEntityType<RefineryBlockEntity>> REFINERY_BE = BLOCK_ENTITIES.register("refinery_be", () -> BlockEntityType.Builder.of(RefineryBlockEntity::new, ModBlocks.REFINERY.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
