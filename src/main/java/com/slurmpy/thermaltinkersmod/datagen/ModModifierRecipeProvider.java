package com.slurmpy.thermaltinkersmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.data.recipes.RecipeProvider;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

import java.util.function.Consumer;

import static com.slurmpy.thermaltinkersmod.ThermalTinkersMod.MODID;
import static com.slurmpy.thermaltinkersmod.ThermalTinkersMod.modResource;
import static com.slurmpy.thermaltinkersmod.registry.ModItems.THERMAL_REINFORCEMENT;
import static com.slurmpy.thermaltinkersmod.registry.ModModifiers.THERMAL_REGULATION;

public class ModModifierRecipeProvider extends RecipeProvider {

    public ModModifierRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        System.out.println("[ThermalTinkersMod] Running ModModifierRecipeProvider...");
        addItemRecipes(consumer);
        addModifierRecipes(consumer);
    }

    private void addItemRecipes(Consumer<FinishedRecipe> consumer) {
        ResourceLocation id = new ResourceLocation(MODID, "compat/thermal_reinforcement");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, THERMAL_REINFORCEMENT.get())
                .define('L', ItemTags.LEAVES) // #minecraft:leaves
                .define('W', ItemTags.WOOL)   // #minecraft:wool
                .define('P', slimeknights.tconstruct.tables.TinkerTables.pattern)
                .pattern("LLL")
                .pattern("LPW")
                .pattern("WWW")
                .unlockedBy("has_leaves", has(ItemTags.LEAVES))
                .unlockedBy("has_pattern", has(slimeknights.tconstruct.tables.TinkerTables.pattern))
                .save(consumer, id);
    }

    private void addModifierRecipes(Consumer<FinishedRecipe> consumer) {
        ModifierId modifierId = new ModifierId(MODID, "thermal_regulation");

        ModifierRecipeBuilder.modifier(modifierId)
                .addInput(Ingredient.of(THERMAL_REINFORCEMENT.get()))
                .setTools(TinkerTags.Items.CHESTPLATES)
                .setMaxLevel(1).checkTraitLevel()
                .setSlots(SlotType.DEFENSE, 1)
                .save(consumer, modifierId);
    }
}