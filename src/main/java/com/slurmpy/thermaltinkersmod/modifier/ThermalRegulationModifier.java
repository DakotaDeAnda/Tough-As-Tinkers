package com.slurmpy.thermaltinkersmod.modifier;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import org.slf4j.Logger;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
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

    @Override
    public boolean shouldDisplay(boolean advanced) {
        return true; // always show in tooltip
    }
}
