package net.bball_262.breadbasket.items;

import net.bball_262.breadbasket.Breadbasket;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BBCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Breadbasket.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB_BREADBASKET = CREATIVE_TABS.register("breadbasket",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.breadbasket"))
                    .icon(() -> {
                        return new ItemStack(BBitems.RYE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
