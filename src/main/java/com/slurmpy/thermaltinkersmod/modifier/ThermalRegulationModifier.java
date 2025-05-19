package com.slurmpy.thermaltinkersmod.modifier;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class ThermalRegulationModifier extends Modifier {
    private static final Logger LOGGER = LogUtils.getLogger();

    public ThermalRegulationModifier() {
        LOGGER.info("[ThermalTinkers] ThermalRegulationModifier constructor called");
    }

    @Override
    public int getPriority() {
        LOGGER.info("[ThermalTinkers] getPriority called on ThermalRegulationModifier");
        return 75;
    }

    // Add logic later if needed
}