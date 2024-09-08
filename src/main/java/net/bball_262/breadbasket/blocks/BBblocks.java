package net.bball_262.breadbasket.blocks;

import net.bball_262.breadbasket.Breadbasket;
import net.bball_262.breadbasket.blocks.custom.ConvectionOven;
import net.bball_262.breadbasket.blocks.custom.ConvectionOvenBlock;
import net.bball_262.breadbasket.blocks.custom.ConvectionOvenFurnace;
import net.bball_262.breadbasket.blocks.custom.ConvectionOvenPipe;
import net.bball_262.breadbasket.items.BBitems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BBblocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Breadbasket.MOD_ID);

    public static final RegistryObject<Block> CONVECTION_OVEN = registerBlock("convection_oven", () -> new ConvectionOven(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> CONVECTION_OVEN_MAIN = registerBlock("convection_oven_main", () -> new ConvectionOvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> CONVECTION_OVEN_FURNACE = registerBlock("convection_oven_furnace", () -> new ConvectionOvenFurnace(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> CONVECTION_OVEN_PIPE = registerBlock("convection_oven_pipe", () -> new ConvectionOvenPipe(BlockBehaviour.Properties.of()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return BBitems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
