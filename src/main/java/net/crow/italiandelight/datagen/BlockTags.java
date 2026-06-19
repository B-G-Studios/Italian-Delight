package net.crow.italiandelight.datagen;

import net.crow.italiandelight.init.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider
{
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FarmersDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.MINEABLE_WITH_KNIFE)
                .add(BlockInit.PIZZA_DANTE.get())
                .add(BlockInit.PIZZA_DIAVOLA.get())
                .add(BlockInit.PIZZA_FUNGHI.get())
                .add(BlockInit.PIZZA_MARGHERITA.get())
                .add(BlockInit.PIZZA_PROSCIUTTO.get())
                .add(BlockInit.CIAMBELLONE.get());

        tag(ModTags.WILD_CROPS)
                .add(BlockInit.WILD_GRAPES.get())
                .add(BlockInit.WILD_HERBS.get());
    }

}

