package net.eganmakela.compmod.entity;

import net.eganmakela.compmod.CompMod;
import net.eganmakela.compmod.entity.custom.WizardEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CompMod.MOD_ID);

    public static final RegistryObject<EntityType<WizardEntity>> WIZARD =
            ENTITY_TYPES.register("wizard", () -> EntityType.Builder.of(WizardEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("wizard"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
