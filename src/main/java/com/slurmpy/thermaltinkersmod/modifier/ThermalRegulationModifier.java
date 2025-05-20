package com.slurmpy.thermaltinkersmod.modifier;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import org.slf4j.Logger;
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

    @Override
    public boolean shouldDisplay(boolean advanced) {
        return true; // always show in tooltip
    }

    @Override
    public Component getDisplayName(int level) {
        // only append level if level > 1
        if (level > 1) {
            return Component.translatable(getTranslationKey())
                    .append(" " + level)
                    .withStyle(style -> style.withColor(0x32C8FF));
        } else {
            return Component.translatable(getTranslationKey())
                    .withStyle(style -> style.withColor(0x32C8FF));
        }
    }
}
