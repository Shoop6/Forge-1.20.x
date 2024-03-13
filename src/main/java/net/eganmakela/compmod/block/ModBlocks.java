package net.eganmakela.compmod.block;

import net.eganmakela.compmod.CompMod;
import net.eganmakela.compmod.Item.ModItems;
import net.eganmakela.compmod.block.custom.ElixirCollectorBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CompMod.MOD_ID);

public static final RegistryObject<Block> GEM_BLOCK = registerBlock("gem_block",
        ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
public static final RegistryObject<Block> WALL_BLOCK = registerBlock("wall_block",
        ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
public static final RegistryObject<Block> CONDENSED_ELIXIR_BLOCK = registerBlock("condensed_elixir_block",
        ()-> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_ORE)));




public static final RegistryObject<Block> ELIXIR_COLLECTOR = registerBlock("elixir_collector",
        ()-> new ElixirCollectorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);//registers the block
        registerBlockItem(name, toReturn);//registers block item
        return toReturn;//return the block
    }
//registers the item
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, ()->new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
