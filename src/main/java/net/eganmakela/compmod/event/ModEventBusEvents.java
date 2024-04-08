package net.eganmakela.compmod.event;

import net.eganmakela.compmod.CompMod;
import net.eganmakela.compmod.entity.ModEntities;
import net.eganmakela.compmod.entity.custom.WizardEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CompMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.WIZARD.get(), WizardEntity.createAttributes().build());

    }
}