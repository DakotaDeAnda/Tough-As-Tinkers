package com.slurmpy.thermaltinkersmod.datagen;

import com.google.gson.JsonObject;
import net.minecraft.data.PackOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.CachedOutput;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class ModModifierDataProvider implements DataProvider {
    private final PackOutput output;

    public ModModifierDataProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "tconstruct:modifier");
        json.addProperty("loader", "tconstruct:generic");
        json.addProperty("level_display", "tconstruct:no_levels");
        json.addProperty("level", 1);
        json.addProperty("allow_multiple", false);

        JsonObject requirements = new JsonObject();
        JsonObject modifiers = new JsonObject();
        modifiers.addProperty("thermaltinkersmod:thermal_regulation", "absent");
        requirements.add("modifiers", modifiers);
        json.add("requirements", requirements);

        JsonObject slots = new JsonObject();
        slots.addProperty("defense", 1);
        json.add("slots", slots);

        json.addProperty("name", "modifier.thermaltinkersmod.thermal_regulation");
        json.addProperty("description", "modifier.thermaltinkersmod.thermal_regulation.description");

        Path path = output.getOutputFolder()
                .resolve("data/thermaltinkersmod/modifiers/thermal_regulation.json");

        return DataProvider.saveStable(cache, json, path);
    }

    @Override
    public String getName() {
        return "ThermalTinkersMod - Modifiers";
    }
}
