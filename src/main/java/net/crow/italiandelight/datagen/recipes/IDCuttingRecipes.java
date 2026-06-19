package net.crow.italiandelight.datagen.recipes;

import net.crow.italiandelight.init.BlockInit;
import net.crow.italiandelight.init.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.function.Consumer;

public class IDCuttingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        cuttingRecipes(consumer);
    }

    private static void cuttingRecipes(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemInit.SALAMI.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemInit.SALAMI_SLICE.get(), 4).build(consumer, saveName(ItemInit.SALAMI_SLICE.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemInit.PANDORO.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemInit.PANDORO_SLICE.get(), 8).build(consumer, saveName(ItemInit.PANDORO_SLICE.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemInit.PANETTONE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemInit.PANETTONE_SLICES.get(), 8).build(consumer, saveName(ItemInit.PANETTONE_SLICES.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(BlockInit.CIAMBELLONE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemInit.CIAMBELLONE_SLICE.get(), 8).build(consumer, saveName(ItemInit.CIAMBELLONE_SLICE.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemInit.PIZZA_DANTE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemInit.PIZZA_DANTE_SLICE.get(), 4).build(consumer, saveName(ItemInit.PIZZA_DANTE_SLICE.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemInit.PIZZA_DIAVOLA.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemInit.PIZZA_DIAVOLA_SLICE.get(), 4).build(consumer, saveName(ItemInit.PIZZA_DIAVOLA_SLICE.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemInit.PIZZA_FUNGHI.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemInit.PIZZA_FUNGHI_SLICE.get(), 4).build(consumer, saveName(ItemInit.PIZZA_FUNGHI_SLICE.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemInit.PIZZA_MARGHERITA.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemInit.PIZZA_MARGHERITA_SLICE.get(), 4).build(consumer, saveName(ItemInit.PIZZA_MARGHERITA_SLICE.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ItemInit.PIZZA_PROSCIUTTO.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemInit.PIZZA_PROSCIUTTO_SLICE.get(), 4).build(consumer, saveName(ItemInit.PIZZA_PROSCIUTTO_SLICE.get()));

    }

    private static ResourceLocation saveName(Item item) {
        ResourceLocation RL = BuiltInRegistries.ITEM.getKey(item);
        return ResourceLocation.fromNamespaceAndPath(RL.getNamespace(), "cutting/" + RL.getPath());
    }
}
