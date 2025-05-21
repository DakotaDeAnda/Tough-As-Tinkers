package com.slurmpy.thermaltinkersmod.datagen;

import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.definition.module.build.SetStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolSlotsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.PartStatsModule;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import com.slurmpy.thermaltinkersmod.registry.ModToolDefinitions;
import com.slurmpy.thermaltinkersmod.registry.ModToolParts;

public class ModToolDefinitionDataProvider extends AbstractToolDefinitionDataProvider {
    public ModToolDefinitionDataProvider(PackOutput output) {
        super(output, "thermaltinkersmod");
    }

    @Override
    protected void addToolDefinitions() {
        define(ModToolDefinitions.CANTEEN)
                .module(PartStatsModule.parts()
                        .part(ModToolParts.CANTEEN_BODY)
                        .part(ModToolParts.CANTEEN_CAP)
                        .build())
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.DURABILITY, 100f)
                        .build()))
                .module(ToolSlotsModule.builder()
                        .slots(SlotType.UPGRADE, 1)
                        .build());
    }

    @Override
    public String getName() {
        return "Thermal Tinkers Tool Definitions";
    }
}