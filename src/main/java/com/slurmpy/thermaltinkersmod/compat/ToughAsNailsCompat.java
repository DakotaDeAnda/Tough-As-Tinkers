package com.slurmpy.thermaltinkersmod.compat;

import toughasnails.api.temperature.TemperatureHelper;

public class ToughAsNailsCompat {
    public static void register() {
        try {
            Class<?> clazz = Class.forName("com.slurmpy.thermaltinkersmod.compat.ThermalRegulationTANWrapper");
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof toughasnails.api.temperature.IPlayerTemperatureModifier modifier) {
                TemperatureHelper.registerPlayerTemperatureModifier(modifier);
            }
        } catch (Exception e) {
            System.err.println("[ThermalTinkersMod] Failed to register TAN compatibility: " + e);
        }
    }
}