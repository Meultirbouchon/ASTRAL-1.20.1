package fr.astralteam.astral.event;

import fr.astralteam.astral.ASTRAL;
import fr.astralteam.astral.block.entity.ModBlockEntities;
import fr.astralteam.astral.block.entity.renderer.MetalCutterBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ASTRAL.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.METALCUTTER_BE.get(), MetalCutterBlockEntityRenderer::new);
    }
}
