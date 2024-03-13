package net.eganmakela.compmod.block.entity;

import net.eganmakela.compmod.CompMod;
import net.eganmakela.compmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CompMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ElixirCollectorBlockEntity>> ELIXIR_COLLECTOR_BE =
            BLOCK_ENTITIES.register("elixir_collector_be", () ->
                    BlockEntityType.Builder.of(ElixirCollectorBlockEntity::new,
                            ModBlocks.ELIXIR_COLLECTOR.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);


    }
}
