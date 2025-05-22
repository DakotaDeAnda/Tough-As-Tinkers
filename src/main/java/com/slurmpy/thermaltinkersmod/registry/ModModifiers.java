package com.slurmpy.thermaltinkersmod.registry;

import com.slurmpy.thermaltinkersmod.ThermalTinkersMod;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.DynamicModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ModModifiers {
    public static final ModifierDeferredRegister MODIFIERS =
            ModifierDeferredRegister.create(ThermalTinkersMod.MODID);

    public static final DynamicModifier THERMAL_REGULATION = MODIFIERS.registerDynamic("thermal_regulation");

    public static void register(IEventBus eventBus) {
        MODIFIERS.register(eventBus);
    }
}