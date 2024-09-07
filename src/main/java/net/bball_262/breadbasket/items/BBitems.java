package net.bball_262.breadbasket.items;

import net.bball_262.breadbasket.Breadbasket;
import net.bball_262.breadbasket.items.foods.BBfoods;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BBitems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Breadbasket.MOD_ID);
    public static final RegistryObject<Item> RYE = ITEMS.register("rye", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RYE_BREAD = ITEMS.register("rye_bread", () -> new Item(new Item.Properties().food(BBfoods.RYE_BREAD)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}