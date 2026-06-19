package net.crow.italiandelight.datagen;

import net.crow.italiandelight.datagen.recipes.IDCuttingRecipes;
import net.crow.italiandelight.datagen.recipes.IDKegRecipes;
import net.crow.italiandelight.datagen.recipes.IDPouringRecipes;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class IDRecipes extends RecipeProvider
{

    public IDRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        IDKegRecipes.register(consumer);
        IDPouringRecipes.register(consumer);
        IDCuttingRecipes.register(consumer);
    }

}