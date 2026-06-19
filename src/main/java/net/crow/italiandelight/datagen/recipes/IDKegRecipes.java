package net.crow.italiandelight.datagen.recipes;

import net.crow.italiandelight.init.FluidInit;
import net.crow.italiandelight.init.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import umpaz.brewinandchewin.client.recipebook.FermentingRecipeBookTab;
import umpaz.brewinandchewin.data.builder.KegFermentingRecipeBuilder;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

public class IDKegRecipes {
    public static final int FAST_FERMENTING = 4800;      // 4 minutes
    public static final int NORMAL_FERMENTING = 9600;    // 8 minutes
    public static final int SLOW_FERMENTING = 12000;    // 10 minutes

    public static final float SMALL_EXP = 0.5F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;

    public static void register(Consumer<FinishedRecipe> consumer) {
        kegRecipes(consumer);
    }

    private static void kegRecipes(Consumer<FinishedRecipe> consumer) {
        KegFermentingRecipeBuilder.kegFermentingRecipe(ItemInit.RAW_SALAMI.get(), 1, FAST_FERMENTING, SMALL_EXP, 1)
                .addIngredient(ForgeTags.RAW_PORK)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.DRIED_KELP)
                .unlockedByAnyIngredient(Items.PORKCHOP)
                .setRecipeBookTab(FermentingRecipeBookTab.MEALS)
                .build(consumer, saveName(ItemInit.RAW_SALAMI.get()));

        KegFermentingRecipeBuilder.kegFermentingRecipe(ItemInit.ROSE_WINE.get(), 1000, NORMAL_FERMENTING, MEDIUM_EXP)
                .addFluidIngredient(Fluids.WATER, 1000)
                .addIngredient(ItemInit.GRAPES.get())
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.SUGAR)
                .unlockedByAnyIngredient(ItemInit.GRAPES.get())
                .setRecipeBookTab(FermentingRecipeBookTab.DRINKS)
                .build(consumer, saveName(ItemInit.ROSE_WINE.get()));

        KegFermentingRecipeBuilder.kegFermentingRecipe(ItemInit.SWEETBERRY_WINE.get(), 1000, NORMAL_FERMENTING, MEDIUM_EXP)
                .addFluidIngredient(Fluids.WATER, 1000)
                .addIngredient(ItemInit.GRAPES.get())
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(Items.SUGAR)
                .unlockedByAnyIngredient(Items.SWEET_BERRIES, ItemInit.GRAPES.get())
                .setRecipeBookTab(FermentingRecipeBookTab.DRINKS)
                .build(consumer, saveName(ItemInit.SWEETBERRY_WINE.get()));

        KegFermentingRecipeBuilder.kegFermentingRecipe(ItemInit.GLOWBERRY_WINE.get(), 1000, NORMAL_FERMENTING, MEDIUM_EXP)
                .addFluidIngredient(FluidInit.SWEETBERRY_WINE.get(), 1000)
                .addIngredient(ItemInit.GRAPES.get())
                .addIngredient(Items.GLOW_BERRIES)
                .addIngredient(Items.SUGAR)
                .unlockedByAnyIngredient(Items.GLOW_BERRIES, ItemInit.GRAPES.get())
                .setRecipeBookTab(FermentingRecipeBookTab.DRINKS)
                .build(consumer, saveName(ItemInit.GLOWBERRY_WINE.get()));

        KegFermentingRecipeBuilder.kegFermentingRecipe(ItemInit.HASTING_WINE.get(), 1000, NORMAL_FERMENTING, MEDIUM_EXP, 2)
                .addFluidIngredient(Fluids.WATER, 1000)
                .addIngredient(ItemInit.GRAPES.get())
                .addIngredient(Items.STONE)
                .addIngredient(Items.SUGAR)
                .unlockedByAnyIngredient(ItemInit.GRAPES.get())
                .setRecipeBookTab(FermentingRecipeBookTab.DRINKS)
                .build(consumer, saveName(ItemInit.HASTING_WINE.get()));

        KegFermentingRecipeBuilder.kegFermentingRecipe(ItemInit.HELLHOUND_WINE.get(), 1000, SLOW_FERMENTING, LARGE_EXP, 5)
                .addFluidIngredient(Fluids.LAVA, 1000)
                .addIngredient(Items.COAL)
                .addIngredient(Items.BLAZE_POWDER)
                .addIngredient(Items.NETHER_WART)
                .unlockedByAnyIngredient(Items.BLAZE_POWDER, Items.NETHER_WART)
                .setRecipeBookTab(FermentingRecipeBookTab.DRINKS)
                .build(consumer, saveName(ItemInit.HELLHOUND_WINE.get()));

        KegFermentingRecipeBuilder.kegFermentingRecipe(ItemInit.DRAGONBORN_WINE.get(), 1000, SLOW_FERMENTING, MEDIUM_EXP, 4)
                .addFluidIngredient(FluidInit.HELLHOUND_WINE.get(), 1000)
                .addIngredient(Items.DRAGON_BREATH)
                .addIngredient(Items.ENDER_PEARL)
                .unlockedByAnyIngredient(Items.DRAGON_BREATH, Items.ENDER_PEARL)
                .setRecipeBookTab(FermentingRecipeBookTab.DRINKS)
                .build(consumer, saveName(ItemInit.DRAGONBORN_WINE.get()));

        KegFermentingRecipeBuilder.kegFermentingRecipe(ItemInit.SPUMANTE.get(), 1000, NORMAL_FERMENTING, MEDIUM_EXP, 2)
                .addFluidIngredient(FluidInit.SWEETBERRY_WINE.get(), 1000)
                .addIngredient(ItemInit.GRAPES.get())
                .addIngredient(Items.SUGAR)
                .unlockedByAnyIngredient(ItemInit.GRAPES.get())
                .setRecipeBookTab(FermentingRecipeBookTab.DRINKS)
                .build(consumer, saveName(ItemInit.SPUMANTE.get()));
    }

    private static ResourceLocation saveName(Item item) {
        ResourceLocation RL = BuiltInRegistries.ITEM.getKey(item);
        return ResourceLocation.fromNamespaceAndPath(RL.getNamespace(), "fermenting/" + RL.getPath());
    }
}
