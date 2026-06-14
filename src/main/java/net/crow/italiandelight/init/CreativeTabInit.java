package net.crow.italiandelight.init;

import net.crow.italiandelight.ItalianDelightMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class CreativeTabInit {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ItalianDelightMain.MODID);

    public static final RegistryObject<CreativeModeTab> ITALIAN_DELIGHT_TAB = CREATIVE_MODE_TABS.register("italian_delight_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockInit.WOODEN_OVEN.get()))
                    .title(Component.translatable("creative.italian_delight"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ItemInit.GRAPES.get());
                        pOutput.accept(ItemInit.OLIVES.get());
                        pOutput.accept(ItemInit.GRAPE_SEEDS.get());
                        pOutput.accept(ItemInit.HERB_LEAVES.get());

                        pOutput.accept(ItemInit.GLOWBERRY_WINE.get());
                        pOutput.accept(ItemInit.ROSE_WINE.get());
                        pOutput.accept(ItemInit.HELLHOUND_WINE.get());
                        pOutput.accept(ItemInit.DRAGONBORN_WINE.get());
                        pOutput.accept(ItemInit.HASTING_WINE.get());
                        pOutput.accept(ItemInit.SWEETBERRY_WINE.get());
                        pOutput.accept(ItemInit.SPUMANTE.get());

                        pOutput.accept(ItemInit.BERRY_DELIGHT.get());
                        pOutput.accept(ItemInit.PASTA_AL_TOMATO.get());
                        pOutput.accept(ItemInit.PASTA_AL_PESTO.get());
                        pOutput.accept(ItemInit.RISOTTO_AL_SUGO.get());
                        pOutput.accept(ItemInit.RISOTTO_AL_FUNGHI.get());
                        pOutput.accept(ItemInit.TIRAMISU.get());
                        pOutput.accept(ItemInit.MOZZARELLA_PANINI.get());
                        pOutput.accept(ItemInit.MOZZARELLA_SALAD.get());
                        pOutput.accept(ItemInit.PANDORO.get());
                        pOutput.accept(ItemInit.PIZZA_PROSCIUTTO_RAW.get());
                        pOutput.accept(ItemInit.PIZZA_PROSCIUTTO.get());
                        pOutput.accept(ItemInit.PIZZA_PROSCIUTTO_SLICE.get());
                        pOutput.accept(ItemInit.PIZZA_FUNGHI_RAW.get());
                        pOutput.accept(ItemInit.PIZZA_FUNGHI.get());
                        pOutput.accept(ItemInit.PIZZA_FUNGHI_SLICE.get());
                        pOutput.accept(ItemInit.PIZZA_MARGHERITA_RAW.get());
                        pOutput.accept(ItemInit.PIZZA_MARGHERITA.get());
                        pOutput.accept(ItemInit.PIZZA_MARGHERITA_SLICE.get());
                        pOutput.accept(ItemInit.PIZZA_DANTE_RAW.get());
                        pOutput.accept(ItemInit.PIZZA_DANTE.get());
                        pOutput.accept(ItemInit.PIZZA_DANTE_SLICE.get());
                        pOutput.accept(ItemInit.PIZZA_DIAVOLA_RAW.get());
                        pOutput.accept(ItemInit.PIZZA_DIAVOLA.get());
                        pOutput.accept(ItemInit.PIZZA_DIAVOLA_SLICE.get());
                        pOutput.accept(ItemInit.RAW_SALAMI.get());
                        pOutput.accept(ItemInit.SALAMI.get());
                        pOutput.accept(ItemInit.SALAMI_SLICE.get());
                        pOutput.accept(ItemInit.PANETTONE.get());
                        pOutput.accept(ItemInit.PANETTONE_SLICES.get());
                        pOutput.accept(ItemInit.PANDORO_DOUGH.get());
                        pOutput.accept(ItemInit.PANDORO_SLICE.get());
                        pOutput.accept(ItemInit.WILD_GRAPES.get());
                        pOutput.accept(ItemInit.WILD_HERBS.get());

                        pOutput.accept(BlockInit.WILD_GRAPES.get());
                        pOutput.accept(BlockInit.WILD_HERBS.get());
                        pOutput.accept(BlockInit.GRAPE_CROP.get());
                        pOutput.accept(BlockInit.HERB_CROP.get());
                        pOutput.accept(BlockInit.PIZZA_PROSCIUTTO.get());
                        pOutput.accept(BlockInit.PIZZA_FUNGHI.get());
                        pOutput.accept(BlockInit.PIZZA_MARGHERITA.get());
                        pOutput.accept(BlockInit.PIZZA_DANTE.get());
                        pOutput.accept(BlockInit.PIZZA_DIAVOLA.get());

                        pOutput.accept(BlockInit.OLIVE_SAPLING.get());
                        pOutput.accept(BlockInit.OLIVE_LOG.get());
                        pOutput.accept(BlockInit.OLIVE_WOOD.get());
                        pOutput.accept(BlockInit.STRIPPED_OLIVE_LOG.get());
                        pOutput.accept(BlockInit.STRIPPED_OLIVE_WOOD.get());
                        pOutput.accept(BlockInit.OLIVE_LEAVES.get());
                        pOutput.accept(BlockInit.OLIVE_PLANKS.get());
                        pOutput.accept(BlockInit.OLIVE_FENCE.get());
                        pOutput.accept(BlockInit.OLIVE_FENCE_GATE.get());
                        pOutput.accept(BlockInit.OLIVE_DOOR.get());
                        pOutput.accept(BlockInit.OLIVE_TRAPDOOR.get());
                        pOutput.accept(BlockInit.OLIVE_PRESSURE_PLATE.get());
                        pOutput.accept(BlockInit.OLIVE_BUTTON.get());
                        pOutput.accept(BlockInit.OLIVE_SLAB.get());
                        pOutput.accept(BlockInit.OLIVE_STAIRS.get());
                        pOutput.accept(BlockInit.WOODEN_OVEN.get());
                    })
                    .build());

}
