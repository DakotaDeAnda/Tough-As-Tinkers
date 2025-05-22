package com.slurmpy.thermaltinkersmod.registry;

import com.slurmpy.thermaltinkersmod.ThermalTinkersMod;
import com.slurmpy.thermaltinkersmod.temperature.ThermalRegulationTempModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModModifiers {

    // Tinkers' helper for registering modifiers
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(ThermalTinkersMod.MODID);

    // Your custom modifier
    public static final StaticModifier<ThermalRegulationTempModifier> THERMAL_REGULATION =
            MODIFIERS.register("thermal_regulation", ThermalRegulationTempModifier::new);

    // Call this in your main mod class to register
    public static void register() {
        MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}