package fr.astralteam.astral;

import com.mojang.logging.LogUtils;
import fr.astralteam.astral.block.ModBlocks;
import fr.astralteam.astral.block.entity.ModBlockEntities;
import fr.astralteam.astral.item.ModCreativeModTabs;
import fr.astralteam.astral.item.ModItems;
import fr.astralteam.astral.recipe.ModRecipes;
import fr.astralteam.astral.screen.ElectrolyserScreen;
import fr.astralteam.astral.screen.MetalCutterScreen;
import fr.astralteam.astral.screen.ModMenuTypes;
import fr.astralteam.astral.screen.RefineryScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(ASTRAL.MODID)
        public class ASTRAL {
            // Define mod id in a common place for everything to reference
            public static final String MODID = "astral";
            // Directly reference a slf4j logger
            private static final Logger LOGGER = LogUtils.getLogger();

            public ASTRAL() {

                IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

                ModCreativeModTabs.register(modEventBus);

                ModBlocks.register(modEventBus);

                ModItems.register(modEventBus);

                ModBlockEntities.register(modEventBus);

                ModMenuTypes.register(modEventBus);

                ModRecipes.register(modEventBus);

                // Register the commonSetup method for modloading
                modEventBus.addListener(this::commonSetup);

                // Register ourselves for server and other game events we are interested in
                MinecraftForge.EVENT_BUS.register(this);

            }

            private void commonSetup(final FMLCommonSetupEvent event) {
                // Some common setup code
                LOGGER.info("[COMMON SETUP] HELLO !");

            }

            // You can use SubscribeEvent and let the Event Bus discover methods to call
            @SubscribeEvent
            public void onServerStarting(ServerStartingEvent event) {
                // Do something when the server starts
                LOGGER.info("HELLO FROM SERVER STARTING !");
            }

            // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
            @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
            public static class ClientModEvents {
                @SubscribeEvent
                public static void onClientSetup(FMLClientSetupEvent event) {
                    MenuScreens.register(ModMenuTypes.ELECTROLYSER_MENU.get(), ElectrolyserScreen::new);
                    MenuScreens.register(ModMenuTypes.METALCUTTER_MENU.get(), MetalCutterScreen::new);
                    MenuScreens.register(ModMenuTypes.REFINERY_MENU.get(), RefineryScreen::new);
                    // Some client setup code
                    LOGGER.info("HELLO FROM CLIENT SETUP");
                    LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
                }
            }
}