package com.slurmpy.thermaltinkersmod.datagen;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;
import com.slurmpy.thermaltinkersmod.ThermalTinkersMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ThermalTinkersMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var output = gen.getPackOutput();

        if (event.includeServer()) {
            gen.addProvider(true, new ModModifierDataProvider(output));
        }

        // Optionally print to confirm TAN is not loaded
        System.out.println("Data generation started without TAN dependencies.");
    }
}