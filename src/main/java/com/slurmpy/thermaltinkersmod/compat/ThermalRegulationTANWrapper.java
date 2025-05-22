package com.slurmpy.thermaltinkersmod.compat;

import com.slurmpy.thermaltinkersmod.temperature.ThermalRegulationTempModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import toughasnails.api.temperature.IPlayerTemperatureModifier;
import toughasnails.api.temperature.TemperatureLevel;

public class ThermalRegulationTANWrapper implements IPlayerTemperatureModifier {
    @Override
    public TemperatureLevel modify(Player player, TemperatureLevel current) {
        if (player == null || !player.isAlive()) return current;

        ItemStack chest = player.getInventory().getArmor(2);
        if (chest.isEmpty()) return current;

        return ThermalRegulationTempModifier.hasImmunity(chest) ? TemperatureLevel.NEUTRAL : current;
    }
}