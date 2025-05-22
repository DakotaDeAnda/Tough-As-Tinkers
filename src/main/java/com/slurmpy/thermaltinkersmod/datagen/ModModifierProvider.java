package com.slurmpy.thermaltinkersmod.datagen;

import com.google.gson.JsonObject;
import net.minecraft.data.PackOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.CachedOutput;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class ModModifierProvider implements DataProvider {
    private final PackOutput output;

    public ModModifierProvider(PackOutput output) {
        this.output = output;
        System.out.println("ModModifierProvider CONSTRUCTOR CALLED");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        System.out.println("[ThermalTinkersMod] Running ModModifierProvider...");

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

        System.out.println("[ThermalTinkersMod] Writing modifier JSON...");

        Path path = output.getOutputFolder()
                .resolve("data/thermaltinkersmod/tinkering/modifiers/thermal_regulation.json");

        System.out.println("[ThermalTinkersMod] Writing to: " + path.toAbsolutePath());

        try {
            System.out.println("[ThermalTinkersMod] Writing to: " + path.toAbsolutePath());

            // Create the parent directories if they don’t exist
            java.nio.file.Files.createDirectories(path.getParent());

            return DataProvider.saveStable(cache, json, path);
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.failedFuture(e);
        }
    }

    @Override
    public String getName() {
        return "ThermalTinkersMod - Modifiers";
    }
}
