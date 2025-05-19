package com.slurmpy.thermaltinkersmod;

import com.slurmpy.thermaltinkersmod.modifier.ThermalRegulationModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ModModifiers {
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(ThermalTinkersMod.MODID);

    public static final StaticModifier<ThermalRegulationModifier> THERMAL_REGULATION =
            MODIFIERS.register("thermal_regulation", ThermalRegulationModifier::new);

    public static void register(IEventBus eventBus) {
        MODIFIERS.register(eventBus);
    }
}