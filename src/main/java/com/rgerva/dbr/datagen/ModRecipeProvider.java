/**
 * Generic Class: ModRecipeProvider <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.datagen;

import com.rgerva.dbr.DragonBlockReborn;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(
                HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public @NotNull String getName() {
            return "My Recipes";
        }
    }
    
    @Override
    protected void buildRecipes() {

    }

    /**
     * Custom method to generate Nuggets from Ingot Recipe.
     *
     * @param pInput is main item for recipe
     * @param pOutput is the output from recipe
     * @param pGroup is group name
     */
    protected void customNuggetRecipe(ItemLike pInput, ItemLike pOutput, String pGroup) {
        this.shapeless(RecipeCategory.MISC, pInput, 9)
                .requires(pOutput)
                .group(pGroup.concat("_nugget"))
                .unlockedBy(getHasName(pOutput), has(pOutput))
                .save(
                        this.output,
                        ResourceKey.create(
                                Registries.RECIPE,
                                ResourceLocation.fromNamespaceAndPath(
                                        DragonBlockReborn.MOD_ID, getSimpleRecipeName(pOutput))));

        this.shaped(RecipeCategory.MISC, pOutput)
                .define('#', pInput)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(pGroup)
                .unlockedBy(getHasName(pOutput), has(pOutput))
                .save(
                        this.output,
                        ResourceKey.create(
                                Registries.RECIPE,
                                ResourceLocation.fromNamespaceAndPath(
                                        DragonBlockReborn.MOD_ID,
                                        getSimpleRecipeName(pOutput)
                                                .concat("_from_")
                                                .concat(getSimpleRecipeName(pInput)))));
    }

    /**
     * Custom method to generate Ingots and Blocks Recipe.
     *
     * @param pInput is main item for recipe
     * @param pOutput is the output from recipe
     * @param pGroup is group name
     */
    protected void customBlockToIngotRecipe(ItemLike pInput, ItemLike pOutput, String pGroup) {
        this.shapeless(RecipeCategory.MISC, pOutput, 9)
                .requires(pInput)
                .group(pGroup)
                .unlockedBy(getHasName(pOutput), has(pOutput))
                .save(
                        this.output,
                        ResourceKey.create(
                                Registries.RECIPE,
                                ResourceLocation.fromNamespaceAndPath(
                                        DragonBlockReborn.MOD_ID,
                                        getSimpleRecipeName(pOutput)
                                                .concat("_from_")
                                                .concat(getSimpleRecipeName(pInput)))));

        this.shaped(RecipeCategory.BUILDING_BLOCKS, pInput)
                .define('#', pOutput)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(pGroup)
                .unlockedBy(getHasName(pOutput), has(pOutput))
                .save(
                        this.output,
                        ResourceKey.create(
                                Registries.RECIPE,
                                ResourceLocation.fromNamespaceAndPath(
                                        DragonBlockReborn.MOD_ID, getSimpleRecipeName(pInput))));
    }

    /**
     * Custom method to cook materials to output.
     *
     * @param recipeOutput is like this.output
     * @param pIngredients is the list of ingredients
     * @param pCategory the category of output
     * @param pResult is the output of recipe
     * @param pGroup is the group of material
     */
    protected void oreCook(
            RecipeOutput recipeOutput,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            String pGroup) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                0.25f,
                200,
                pGroup,
                "_from_smelting");

        oreCooking(
                recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                0.25f,
                100,
                pGroup,
                "_from_blasting");
    }

    protected void oreSmelting(
            RecipeOutput recipeOutput,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTIme,
            String pGroup) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTIme,
                pGroup,
                "_from_smelting");
    }

    protected void oreBlasting(
            RecipeOutput recipeOutput,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_blasting");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput recipeOutput,
            RecipeSerializer<T> pCookingSerializer,
            AbstractCookingRecipe.Factory<T> factory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(
                            Ingredient.of(itemlike),
                            pCategory,
                            pResult,
                            pExperience,
                            pCookingTime,
                            pCookingSerializer,
                            factory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(
                            recipeOutput,
                            DragonBlockReborn.MOD_ID
                                    + ":"
                                    + getItemName(pResult)
                                    + pRecipeName
                                    + "_"
                                    + getItemName(itemlike));
        }
    }

    private static ResourceKey<Recipe<?>> getKey(ResourceLocation recipeId) {
        return ResourceKey.create(Registries.RECIPE, recipeId);
    }
}
