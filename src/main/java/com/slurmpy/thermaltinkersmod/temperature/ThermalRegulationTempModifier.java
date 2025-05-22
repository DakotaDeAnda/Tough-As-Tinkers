package com.slurmpy.thermaltinkersmod.temperature;

import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

public class ThermalRegulationTempModifier extends Modifier {

    public static final ModifierId ID = new ModifierId("thermaltinkersmod", "thermal_regulation");

    public static boolean hasImmunity(ItemStack chest) {
        return ModifierUtil.getModifierLevel(chest, ID) > 0;
    }
}