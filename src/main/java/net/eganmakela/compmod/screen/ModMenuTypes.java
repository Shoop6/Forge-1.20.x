package net.eganmakela.compmod.screen;

import net.eganmakela.compmod.CompMod;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, CompMod.MOD_ID);

    public static final RegistryObject<MenuType<ElixirCollectorMenu>> ELIXIR_COLLECTOR_MENU =
            registerMenuType("elixir_collector_menu", ElixirCollectorMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory)
    {
        return MENUS.register(name, ()-> IForgeMenuType.create(factory));
    }


    public static void register (IEventBus eventBus)
    {
        MENUS.register(eventBus);
    }
}
