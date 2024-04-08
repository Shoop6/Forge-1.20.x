package net.eganmakela.compmod.Item;

import net.eganmakela.compmod.CompMod;
import net.eganmakela.compmod.Item.custom.MetalDetectorItem;
import net.eganmakela.compmod.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//holds all items for mod
public class ModItems {
    //deffered register is a long list of certain things, in this case items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CompMod.MOD_ID);
public static final RegistryObject<Item> ELIXIR = ITEMS.register("elixir",
        ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELIXIR_CLUMP = ITEMS.register("elixir_clump",
            ()->new Item(new Item.Properties()));
public static final RegistryObject<Item> GOLD = ITEMS.register("gold",
        ()->new Item(new Item.Properties()));
public static final RegistryObject<Item> GEM = ITEMS.register("gem",
        ()->new Item(new Item.Properties()));
public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
        ()->new MetalDetectorItem(new Item.Properties().durability(50)));
    public static final RegistryObject<Item> WIZARD_SPANW_EGG = ITEMS.register("wizard_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WIZARD, 0x7e9680, 0xc5d1c5, new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
