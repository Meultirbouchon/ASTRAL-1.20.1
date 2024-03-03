package fr.astralteam.astral.item;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ASTRAL.MODID);

    public static final RegistryObject<CreativeModeTab> ASTRAL_TAB = CREATIVE_MODE_TABS.register("astral_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.ELECTROLYSER.get()))
            .title(Component.translatable("creativetab.astral_tab"))
            .withSearchBar()
            .displayItems((pParameters, pOutput) -> {
                // TITANIUM
                pOutput.accept(ModItems.RAW_TITANIUM.get());
                pOutput.accept(ModItems.TITANIUM_INGOT.get());
                pOutput.accept(ModBlocks.TITANIUM_ORE.get());
                pOutput.accept(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
                pOutput.accept(ModBlocks.RAW_TITANIUM_BLOCK.get());
                pOutput.accept(ModBlocks.TITANIUM_BLOCK.get());
                // TITANIUM -> TOOLS
                pOutput.accept(ModItems.TITANIUM_SWORD.get());
                pOutput.accept(ModItems.TITANIUM_PICKAXE.get());
                pOutput.accept(ModItems.TITANIUM_AXE.get());
                pOutput.accept(ModItems.TITANIUM_SHOVEL.get());
                pOutput.accept(ModItems.TITANIUM_HOE.get());
                // TITANIUM -> ARMOR
                pOutput.accept(ModItems.TITANIUM_HELMET.get());
                pOutput.accept(ModItems.TITANIUM_CHESTPLATE.get());
                pOutput.accept(ModItems.TITANIUM_LEGGINGS.get());
                pOutput.accept(ModItems.TITANIUM_BOOTS.get());
                // TUNGSTEN
                pOutput.accept(ModItems.RAW_TUNGSTEN.get());
                pOutput.accept(ModItems.TUNGSTEN_INGOT.get());
                pOutput.accept(ModBlocks.TUNGSTEN_ORE.get());
                pOutput.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
                pOutput.accept(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
                pOutput.accept(ModBlocks.TUNGSTEN_BLOCK.get());
                // TUNGSTEN -> TOOLS
                pOutput.accept(ModItems.TUNGSTEN_SWORD.get());
                pOutput.accept(ModItems.TUNGSTEN_PICKAXE.get());
                pOutput.accept(ModItems.TUNGSTEN_AXE.get());
                pOutput.accept(ModItems.TUNGSTEN_SHOVEL.get());
                pOutput.accept(ModItems.TUNGSTEN_HOE.get());
                // TUNGSTEN -> ARMOR
                pOutput.accept(ModItems.TUNGSTEN_HELMET.get());
                pOutput.accept(ModItems.TUNGSTEN_CHESTPLATE.get());
                pOutput.accept(ModItems.TUNGSTEN_LEGGINGS.get());
                pOutput.accept(ModItems.TUNGSTEN_BOOTS.get());
                // PLATINIUM
                pOutput.accept(ModItems.RAW_PLATINIUM.get());
                pOutput.accept(ModItems.PLATINIUM_INGOT.get());
                pOutput.accept(ModBlocks.PLATINIUM_ORE.get());
                pOutput.accept(ModBlocks.DEEPSLATE_PLATINIUM_ORE.get());
                pOutput.accept(ModBlocks.RAW_PLATINIUM_BLOCK.get());
                pOutput.accept(ModBlocks.PLATINIUM_BLOCK.get());
                // HELIUM
                pOutput.accept(ModItems.RAW_HELIUM.get());
                // LUNARIAN BLOCKS
                pOutput.accept(ModBlocks.LUNARIAN_REGOLITH.get());
                pOutput.accept(ModBlocks.LUNARIAN_STONE.get());
                pOutput.accept(ModBlocks.LUNARIAN_TUNGSTEN_ORE.get());
                pOutput.accept(ModBlocks.LUNARIAN_HELIUM_ORE.get());
                pOutput.accept(ModBlocks.LUNARIAN_TITANIUM_ORE.get());
                pOutput.accept(ModBlocks.LUNARIAN_COBBLESTONE.get());
                pOutput.accept(ModBlocks.LUNARIAN_PLATINIUM_ORE.get());
                // FOODS
                pOutput.accept(ModItems.SPACE_RATION_MEAT.get());
                pOutput.accept(ModItems.SPACE_RATION_VEGETABLE.get());
                pOutput.accept(ModItems.SPACE_RATION_FISH.get());
                // PLIERS
                pOutput.accept(ModItems.PLIERS.get());
                // CANISTER
                pOutput.accept(ModItems.CANISTER.get());
                pOutput.accept(ModItems.HYDROGEN_CANISTER.get());
                pOutput.accept(ModItems.OXYGEN_CANISTER.get());
                // BLOCK ENTITY
                pOutput.accept(ModBlocks.ELECTROLYSER.get());
                pOutput.accept(ModBlocks.METAL_CUTTER.get());
                pOutput.accept(ModBlocks.REFINERY.get());
                // CRAFT ITEMS
                pOutput.accept(ModItems.CAN.get());
                pOutput.accept(ModItems.COKE.get());
                pOutput.accept(ModItems.COKE_ROD_SCRAP.get());
                pOutput.accept(ModItems.COKE_ROD.get());
                pOutput.accept(ModItems.PLATINIUM_ROD.get());
                pOutput.accept(ModItems.TANK.get());
                pOutput.accept(ModItems.CIRCUIT_BOARD.get());
                pOutput.accept(ModItems.BASIC_CIRCUIT_BOARD.get());
                pOutput.accept(ModItems.ADVANCED_CIRCUIT_BOARD.get());
                pOutput.accept(ModItems.RED_CIRCUIT_BOARD.get());
                pOutput.accept(ModItems.CONNECTOR.get());
                pOutput.accept(ModItems.TRANSISTOR.get());
                pOutput.accept(ModItems.CAPACITOR.get());
                pOutput.accept(ModItems.GLASS_FIBER.get());
                pOutput.accept(ModItems.SAP.get());
                pOutput.accept(ModItems.RESIN.get());
                pOutput.accept(ModItems.IRON_WIRE.get());
                pOutput.accept(ModItems.COPPER_WIRE.get());
                pOutput.accept(ModItems.TEN_K_RESISTOR.get());
                pOutput.accept(ModItems.ONE_K_RESISTOR.get());
                pOutput.accept(ModItems.HUNDRED_RESISTOR.get());
                pOutput.accept(ModItems.COPPER_PIPE.get());
                // PLANTS
                pOutput.accept(ModItems.SPROUT_SEEDS.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
