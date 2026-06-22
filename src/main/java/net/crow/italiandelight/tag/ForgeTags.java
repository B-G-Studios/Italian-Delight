package net.crow.italiandelight.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ForgeTags {

    public static class Blocks extends ForgeTags {
        private static TagKey<Block> forgeBlockTag(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("forge", path));
        }

    }

    public static class Items extends ForgeTags {
        private static TagKey<Item> forgeItemTag(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", path));
        }

        public static TagKey<Item> COOKED_SALAMI = forgeItemTag("cooked_salami");
        public static TagKey<Item> SEEDS_GRAPES = forgeItemTag("seeds/grapes");
        public static TagKey<Item> CROPS_GRAPES = forgeItemTag("crops/grapes");
    }
}
