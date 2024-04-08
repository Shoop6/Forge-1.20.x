package net.eganmakela.compmod;
import com.mojang.logging.LogUtils;
import net.eganmakela.compmod.Item.ModCreativeModTabs;
import net.eganmakela.compmod.Item.ModItems;
import net.eganmakela.compmod.block.ModBlocks;
import net.eganmakela.compmod.entity.ModBlockEntities;
import net.eganmakela.compmod.entity.ModEntities;
import net.eganmakela.compmod.entity.client.WizardRenderer;
import net.eganmakela.compmod.screen.ElixirCollectorScreen;
import net.eganmakela.compmod.screen.ModMenuTypes;
import net.eganmakela.compmod.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
// The value here should match an entry in the META-INF/mods.toml file
@Mod(CompMod.MOD_ID)
public class CompMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "compmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public CompMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey()==CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.ELIXIR);
            event.accept(ModItems.GOLD);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.ELIXIR_COLLECTOR_MENU.get(), ElixirCollectorScreen::new);
            EntityRenderers.register(ModEntities.WIZARD.get(), WizardRenderer::new);
        }
    }
}