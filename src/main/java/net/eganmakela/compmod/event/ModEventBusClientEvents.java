
package net.eganmakela.compmod.event;

import net.eganmakela.compmod.CompMod;
import net.eganmakela.compmod.entity.client.ModModelLayers;
import net.eganmakela.compmod.entity.client.WizardModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CompMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.WIZARD_LAYER, WizardModel::createBodyLayer);
    }
}