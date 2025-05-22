package com.slurmpy.thermaltinkersmod.registry;

import com.slurmpy.thermaltinkersmod.ThermalTinkersMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.core.registries.Registries;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThermalTinkersMod.MODID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = TABS.register("mod_tab", () ->
            CreativeModeTab.builder()
                    .title(Component.literal("Tough as Tinkers"))
                    .icon(() -> new ItemStack(Items.CHAINMAIL_CHESTPLATE))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.THERMAL_REINFORCEMENT.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}