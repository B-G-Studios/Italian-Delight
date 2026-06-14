package net.crow.italiandelight.init;

import net.crow.italiandelight.blocks.pizza.PizzaDiavolaBlock;
import net.crow.italiandelight.blocks.pizza.PizzaFunghiBlock;
import net.crow.italiandelight.blocks.pizza.PizzaDanteBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.crow.italiandelight.ItalianDelightMain;
import net.crow.italiandelight.blocks.*;
import net.crow.italiandelight.blocks.pizza.PizzaProsciuttoBlock;
import net.crow.italiandelight.world.feature.tree.OliveTreeGrower;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.OAK_PLANKS;

@SuppressWarnings("unused")
public class BlockInit {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ItalianDelightMain.MOD_ID);


    //Wild Crops
    public static final RegistryObject<Block> WILD_GRAPES = BLOCKS.register("wild_grapes",
            () -> new WildCropBlock(MobEffects.CONFUSION, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_HERBS = BLOCKS.register("wild_herbs",
            () -> new WildCropBlock(MobEffects.MOVEMENT_SPEED, 10, Block.Properties.copy(Blocks.TALL_GRASS)));


    //Raw Crops
    public static final RegistryObject<Block> GRAPE_CROP = BLOCKS.register("grape_crop",
            () -> new GrapeCrop(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> HERB_CROP = BLOCKS.register("herb_crop",
            () -> new HerbCrop(Block.Properties.copy(Blocks.WHEAT)));

    //Olive Stuff
    public static final RegistryObject<Block> OLIVE_SAPLING = registerBlock("olive_sapling", () -> new SaplingBlock(new OliveTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> OLIVE_LOG = registerBlock("olive_log", () -> new OliveLogBlock(Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> OLIVE_WOOD = registerBlock("olive_wood", () -> new OliveLogBlock(Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = registerBlock("stripped_olive_log", () -> new OliveLogBlock(Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_OLIVE_WOOD = registerBlock("stripped_olive_wood", () -> new OliveLogBlock(Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> OLIVE_LEAVES = registerBlock("olive_leaves", () -> new OliveLeavesBlock(Properties.copy(Blocks.OAK_LEAVES)){
        //Makes it flammable
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        //How Flammable is it?z
        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 30;
        }

        //How likely is it to spread fire?
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 60;
        }

    });
    public static final RegistryObject<Block> OLIVE_PLANKS = registerBlock("olive_planks", () -> new Block(Properties.copy(OAK_PLANKS)) {
        //Makes it flammable
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        //How Flammable is it?
        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        //How likely is it to spread fire?
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }

    });

    public static final BlockSetType OLIVE_BLOCKTYPE = BlockSetType.register(new BlockSetType("olive"));
    public static final WoodType OLIVE_WOODTYPE = WoodType.register(new WoodType("olive", OLIVE_BLOCKTYPE));

    public static final RegistryObject<Block> OLIVE_FENCE = registerBlock("olive_fence", () -> new FenceBlock(Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> OLIVE_FENCE_GATE = registerBlock("olive_fence_gate", () -> new FenceGateBlock(Properties.copy(Blocks.OAK_FENCE_GATE), OLIVE_WOODTYPE));
    public static final RegistryObject<Block> OLIVE_DOOR = registerBlock("olive_door", () -> new DoorBlock(Properties.copy(Blocks.OAK_DOOR), OLIVE_BLOCKTYPE));
    public static final RegistryObject<Block> OLIVE_TRAPDOOR = registerBlock("olive_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR), OLIVE_BLOCKTYPE));
    public static final RegistryObject<Block> OLIVE_PRESSURE_PLATE = registerBlock("olive_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.copy(Blocks.OAK_PRESSURE_PLATE), OLIVE_BLOCKTYPE));
    public static final RegistryObject<Block> OLIVE_BUTTON = registerBlock("olive_button", () -> woodenButton(OLIVE_BLOCKTYPE));
    public static final RegistryObject<Block> OLIVE_SLAB = registerBlock("olive_slab", () -> new SlabBlock(Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> OLIVE_STAIRS = registerBlock("olive_stairs", () -> new StairBlock(OAK_PLANKS.defaultBlockState(), Properties.copy(OAK_PLANKS)));

// Pizza Stuff
    public static final RegistryObject<Block> PIZZA_PROSCIUTTO = BLOCKS.register("pizza_prosciutto", () -> new PizzaProsciuttoBlock(Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_FUNGHI = BLOCKS.register("pizza_funghi", () -> new PizzaFunghiBlock(Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_MARGHERITA = BLOCKS.register("pizza_margherita", () -> new PizzaDanteBlock(Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_DANTE = BLOCKS.register("pizza_dante", () -> new PizzaDanteBlock(Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_DIAVOLA = BLOCKS.register("pizza_diavola", () -> new PizzaDiavolaBlock(Properties.copy(Blocks.CAKE)));
// Oven Stuff
    public static final RegistryObject<Block> WOODEN_OVEN = registerBlock("wooden_oven", () -> new WoodenOven(Properties.copy(Blocks.SMOKER)));

// Helpers
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    private static ButtonBlock woodenButton(BlockSetType p_278239_, FeatureFlag... p_278229_) {
        BlockBehaviour.Properties blockbehaviour$properties = BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
        if (p_278229_.length > 0) {
            blockbehaviour$properties = blockbehaviour$properties.requiredFeatures(p_278229_);
        }

        return new ButtonBlock(blockbehaviour$properties, p_278239_, 30, true);
    }

}