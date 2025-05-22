package com.slurmpy.thermaltinkersmod.datagen;

import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.modifiers.impl.BasicModifier.TooltipDisplay;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierSlotModule;
import slimeknights.tconstruct.library.modifiers.ModifierId;

import static com.slurmpy.thermaltinkersmod.ThermalTinkersMod.MODID;

public class ModModifierProvider extends AbstractModifierProvider {

    public ModModifierProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void addModifiers() {
        ModifierId thermalRegulationId = new ModifierId(MODID, "thermal_regulation");

        buildModifier(thermalRegulationId)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .tooltipDisplay(TooltipDisplay.ALWAYS)
                .addModule(ModifierSlotModule.slot(SlotType.DEFENSE).flat(1));
    }

    @Override
    public String getName() {
        return "ThermalTinkersMod - Modifier Definitions";
    }
}