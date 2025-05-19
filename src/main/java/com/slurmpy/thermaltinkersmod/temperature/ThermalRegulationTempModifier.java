package com.slurmpy.thermaltinkersmod.temperature;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import toughasnails.api.temperature.IPlayerTemperatureModifier;
import toughasnails.api.temperature.TemperatureLevel;

public class ThermalRegulationTempModifier implements IPlayerTemperatureModifier {

    private static final ModifierId THERMAL_REGULATION = new ModifierId("thermaltinkersmod", "thermal_regulation");

    @Override
    public TemperatureLevel modify(Player player, TemperatureLevel current) {
        if (player == null || !player.isAlive()) return current;

        ItemStack chest = player.getInventory().getArmor(2);
        if (chest.isEmpty()) return current;

        if (ModifierUtil.getModifierLevel(chest, THERMAL_REGULATION) > 0) {
            return TemperatureLevel.NEUTRAL;
        }

        return current;
    }
}