package net.crow.italiandelight.datagen.recipes;

import net.crow.italiandelight.init.FluidInit;
import net.crow.italiandelight.init.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import umpaz.brewinandchewin.common.registry.BnCFluids;
import umpaz.brewinandchewin.common.registry.BnCItems;
import umpaz.brewinandchewin.data.builder.KegPouringRecipeBuilder;

import java.util.function.Consumer;

public class IDPouringRecipes {

    public static void register(Consumer<FinishedRecipe> consumer) {
        pouringRecipes(consumer);
    }

    private static void pouringRecipes(Consumer<FinishedRecipe> consumer) {
        KegPouringRecipeBuilder.kegPouringRecipe(FluidInit.ROSE_WINE.get(), 250, ItemInit.ROSE_WINE.get()).build(consumer, saveName(ItemInit.ROSE_WINE.get()));
        KegPouringRecipeBuilder.kegPouringRecipe(FluidInit.SWEETBERRY_WINE.get(), 250, ItemInit.SWEETBERRY_WINE.get()).build(consumer, saveName(ItemInit.SWEETBERRY_WINE.get()));
        KegPouringRecipeBuilder.kegPouringRecipe(FluidInit.GLOWBERRY_WINE.get(), 250, ItemInit.GLOWBERRY_WINE.get()).build(consumer, saveName(ItemInit.GLOWBERRY_WINE.get()));
        KegPouringRecipeBuilder.kegPouringRecipe(FluidInit.HASTING_WINE.get(), 250, ItemInit.HASTING_WINE.get()).build(consumer, saveName(ItemInit.HASTING_WINE.get()));
        KegPouringRecipeBuilder.kegPouringRecipe(FluidInit.HELLHOUND_WINE.get(), 250, ItemInit.HELLHOUND_WINE.get()).build(consumer, saveName(ItemInit.HELLHOUND_WINE.get()));
        KegPouringRecipeBuilder.kegPouringRecipe(FluidInit.DRAGONBORN_WINE.get(), 250, ItemInit.DRAGONBORN_WINE.get()).build(consumer, saveName(ItemInit.DRAGONBORN_WINE.get()));
        KegPouringRecipeBuilder.kegPouringRecipe(FluidInit.SPUMANTE.get(), 250, ItemInit.SPUMANTE.get()).build(consumer, saveName(ItemInit.SPUMANTE.get()));
    }

    private static ResourceLocation saveName(Item item) {
        ResourceLocation RL = ForgeRegistries.ITEMS.getKey(item);
        return ResourceLocation.fromNamespaceAndPath(RL.getNamespace(), "pouring/" + RL.getPath());
    }
}
