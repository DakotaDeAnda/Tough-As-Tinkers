package com.slurmpy.thermaltinkersmod.registry;

import com.slurmpy.thermaltinkersmod.ThermalTinkersMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ThermalTinkersMod.MODID);

    public static final RegistryObject<Item> THERMAL_REINFORCEMENT =
            ITEMS.register("thermal_reinforcement", () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}