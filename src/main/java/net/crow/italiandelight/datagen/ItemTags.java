package net.crow.italiandelight.datagen;

import net.crow.italiandelight.init.ItemInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import umpaz.brewinandchewin.common.tag.BnCTags;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {

    public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, FarmersDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.WILD_CROPS_ITEM)
                .add(ItemInit.WILD_GRAPES.get())
                .add(ItemInit.WILD_HERBS.get());

        tag(ForgeTags.CROPS)
                .add(ItemInit.GRAPES.get())
                .add(ItemInit.OLIVES.get())
                .add(ItemInit.HERB_LEAVES.get());

        tag(BnCTags.FERMENTED_DRINKS)
                .add(ItemInit.SWEETBERRY_WINE.get())
                .add(ItemInit.GLOWBERRY_WINE.get())
                .add(ItemInit.ROSE_WINE.get())
                .add(ItemInit.HASTING_WINE.get())
                .add(ItemInit.HELLHOUND_WINE.get())
                .add(ItemInit.DRAGONBORN_WINE.get())
                .add(ItemInit.SPUMANTE.get());

    }

}
