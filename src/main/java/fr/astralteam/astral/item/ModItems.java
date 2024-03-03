package fr.astralteam.astral.item;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.ModBlocks;
import fr.astralteam.astral.item.custom.CraftingItem;
import fr.astralteam.astral.item.custom.PliersItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ASTRAL.MODID);

    // TITANIUM
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties()));
    // TUNGSTEN
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten", () -> new Item(new Item.Properties()));
    // PLATINIUM
    public static final RegistryObject<Item> PLATINIUM_INGOT = ITEMS.register("platinium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PLATINIUM = ITEMS.register("raw_platinium", () -> new Item(new Item.Properties()));
    // HELIUM
    public static final RegistryObject<Item> RAW_HELIUM = ITEMS.register("raw_helium", () -> new Item(new Item.Properties()));
    // CANISTER
    public static final RegistryObject<Item> CANISTER = ITEMS.register("canister", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HYDROGEN_CANISTER = ITEMS.register("hydrogen_canister", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OXYGEN_CANISTER = ITEMS.register("oxygen_canister", () -> new Item(new Item.Properties()));
    // FOOD
    public static final RegistryObject<Item> SPACE_RATION_MEAT = ITEMS.register("space_ration_meat", () -> new Item(new Item.Properties().food(ModFoods.SPACE_RATION_MEAT)));
    public static final RegistryObject<Item> SPACE_RATION_VEGETABLE = ITEMS.register("space_ration_vegetable", () -> new Item(new Item.Properties().food(ModFoods.SPACE_RATION_VEGETABLE)));
    public static final RegistryObject<Item> SPACE_RATION_FISH = ITEMS.register("space_ration_fish", () -> new Item(new Item.Properties().food(ModFoods.SPACE_RATION_FISH)));
    // TOOLS -> TITANIUM
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () -> new SwordItem(ModToolTiers.TITANIUM, 2, 1, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new PickaxeItem(ModToolTiers.TITANIUM, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new AxeItem(ModToolTiers.TITANIUM, 3, 1, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new ShovelItem(ModToolTiers.TITANIUM, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new HoeItem(ModToolTiers.TITANIUM, 0, 0, new Item.Properties()));
    // ARMOR -> TITANIUM
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet", () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots", () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    // TOOLS -> TUNGSTEN
    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword", () -> new SwordItem(ModToolTiers.TUNGSTEN, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe", () -> new PickaxeItem(ModToolTiers.TUNGSTEN, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe", () -> new AxeItem(ModToolTiers.TUNGSTEN, 5, 1, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel", () -> new ShovelItem(ModToolTiers.TUNGSTEN, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe", () -> new HoeItem(ModToolTiers.TUNGSTEN, 0, 0, new Item.Properties()));
    // ARMOR -> TUNGSTEN
    public static final RegistryObject<Item> TUNGSTEN_HELMET = ITEMS.register("tungsten_helmet", () -> new ArmorItem(ModArmorMaterials.TUNGSTEN, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_CHESTPLATE = ITEMS.register("tungsten_chestplate", () -> new ArmorItem(ModArmorMaterials.TUNGSTEN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_LEGGINGS = ITEMS.register("tungsten_leggings", () -> new ArmorItem(ModArmorMaterials.TUNGSTEN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_BOOTS = ITEMS.register("tungsten_boots", () -> new ArmorItem(ModArmorMaterials.TUNGSTEN, ArmorItem.Type.BOOTS, new Item.Properties()));
    // CRAFT ITEMS
    public static final RegistryObject<Item> CONNECTOR = ITEMS.register("connector", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> CAPACITOR = ITEMS.register("capacitor", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> TRANSISTOR = ITEMS.register("transistor", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> COKE = ITEMS.register("coke", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> TANK = ITEMS.register("tank", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> CAN = ITEMS.register("can", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> COKE_ROD = ITEMS.register("coke_rod", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> COKE_ROD_SCRAP = ITEMS.register("coke_rod_scrap", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> PLATINIUM_ROD = ITEMS.register("platinium_rod", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> ADVANCED_CIRCUIT_BOARD = ITEMS.register("advanced_circuit_board", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> BASIC_CIRCUIT_BOARD = ITEMS.register("basic_circuit_board", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> CIRCUIT_BOARD = ITEMS.register("circuit_board", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> RED_CIRCUIT_BOARD = ITEMS.register("red_circuit_board", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> GLASS_FIBER = ITEMS.register("glass_fiber", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> SAP = ITEMS.register("sap", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> RESIN = ITEMS.register("resin", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> IRON_WIRE = ITEMS.register("iron_wire", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> TEN_K_RESISTOR = ITEMS.register("ten_k_resistor", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> ONE_K_RESISTOR = ITEMS.register("one_k_resistor", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> HUNDRED_RESISTOR = ITEMS.register("hundred_resistor", () -> new CraftingItem(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PIPE = ITEMS.register("copper_pipe", () -> new CraftingItem(new Item.Properties()));

    public static final RegistryObject<Item> PLIERS = ITEMS.register("pliers", () -> new PliersItem(new Item.Properties()));

    public static final RegistryObject<Item> SPROUT_SEEDS = ITEMS.register("sprout_seeds", () -> new ItemNameBlockItem(ModBlocks.SAP_SPROUT.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
