package com.slurmpy.thermaltinkersmod.compat;

import com.slurmpy.thermaltinkersmod.temperature.ThermalRegulationTempModifier;
import toughasnails.api.temperature.TemperatureHelper;

public class ToughAsNailsCompat {
    public static void register() {
        TemperatureHelper.registerPlayerTemperatureModifier(new ThermalRegulationTempModifier());
    }
}