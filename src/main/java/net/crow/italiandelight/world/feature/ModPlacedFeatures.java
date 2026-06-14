package net.crow.italiandelight.world.feature;

import net.crow.italiandelight.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.crow.italiandelight.ItalianDelightMain;

import java.util.List;



public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OLIVE_PLACED_KEY = registerKey("olive_placed");
    public static final ResourceKey<PlacedFeature> WILD_GRAPES_PLACED_KEY = registerKey("grapes_placed");
    public static final ResourceKey<PlacedFeature> WILD_HERB_PLACED_KEY = registerKey("herbs_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, OLIVE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OLIVE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25f, 1),
                        BlockInit.OLIVE_SAPLING.get()));

        register(context, WILD_GRAPES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GRAPE_KEY),
                List.of(RarityFilter.onAverageOnceEvery((Integer) /*Configuration.CHANCE_WILD_GRAPES.get()*/ 100), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, WILD_HERB_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HERB_KEY),
                List.of(RarityFilter.onAverageOnceEvery((Integer) /*Configuration.CHANCE_WILD_HERB.get()*/ 100), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ItalianDelightMain.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}