package net.eganmakela.compmod.Item;

import net.eganmakela.compmod.CompMod;
import net.eganmakela.compmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CompMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COMPMOD_TAB = CREATIVE_MODE_TABS.register("compmod_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.GOLD.get()))
                    .title(Component.translatable("creativetab.compmod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ELIXIR.get());
                        pOutput.accept(ModItems.ELIXIR_CLUMP.get());
                        pOutput.accept(ModItems.GOLD.get());
                        pOutput.accept(ModItems.GEM.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        pOutput.accept(ModBlocks.GEM_BLOCK.get());
                        pOutput.accept(ModBlocks.WALL_BLOCK.get());
                        pOutput.accept(ModBlocks.CONDENSED_ELIXIR_BLOCK.get());
                        pOutput.accept(ModBlocks.ELIXIR_COLLECTOR.get());

                    })
                    .build());


    public static void register (IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
