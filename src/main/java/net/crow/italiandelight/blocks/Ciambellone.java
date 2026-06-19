package net.crow.italiandelight.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Supplier;

public class Ciambellone extends Block {
    public static final int MAX_BITES = 7;
    private final Supplier<Item> slice;
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, MAX_BITES);

    public Ciambellone(Properties prop, Supplier<Item> slice) {
        super(prop);
        this.slice = slice;
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, Integer.valueOf(0)));
    }

    private static VoxelShape Slice1 = Block.box(1.0D, 0.0D, 1.0D, 5.0D, 8.0D, 5.0D);
    private static VoxelShape Slice2 = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 8.0D, 5.0D);
    private static VoxelShape Slice3 = Block.box(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 5.0D);
    private static VoxelShape Slice4 = Block.box(11.0D, 0.0D, 5.0D, 15.0D, 8.0D, 11.0D);
    private static VoxelShape Slice5 = Block.box(11.0D, 0.0D, 11.0D, 15.0D, 8.0D, 15.0D);
    private static VoxelShape Slice6 = Block.box(5.0D, 0.0D, 11.0D, 11.0D, 8.0D, 15.0D);
    private static VoxelShape Slice7 = Block.box(1.0D, 0.0D, 11.0D, 5.0D, 8.0D, 15.0D);
    private static VoxelShape Slice8 = Block.box(1.0D, 0.0D, 5.0D, 5.0D, 8.0D, 11.0D);

    private static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{
            Shapes.or(Slice1, Slice2, Slice3, Slice4, Slice5, Slice6, Slice7, Slice8),
            Shapes.or(Slice1, Slice2, Slice3, Slice4, Slice5, Slice6, Slice7),
            Shapes.or(Slice1, Slice2, Slice3, Slice4, Slice5, Slice6),
            Shapes.or(Slice1, Slice2, Slice3, Slice4, Slice5),
            Shapes.or(Slice1, Slice2, Slice3, Slice4),
            Shapes.or(Slice1, Slice2, Slice3),
            Shapes.or(Slice1, Slice2),
            Shapes.or(Slice1),
    };

    public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
        return SHAPE_BY_BITE[pBlockState.getValue(BITES)];
    }


    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (level.isClientSide()) {
            if (itemstack.is(ForgeTags.TOOLS_KNIVES)) {
                return cutSlice(level, pos, state, player);
            }
            if (eatSlice(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (itemstack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        if (itemstack.is(ForgeTags.TOOLS_KNIVES)) {
            return cutSlice(level, pos, state, player);
        }
        return eatSlice(level, pos, state, player);
    }

    public InteractionResult eatSlice(Level level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        }
        player.awardStat(Stats.EAT_CAKE_SLICE);
        Item slice = this.getSlice();
        ItemStack sliceStack = slice.getDefaultInstance();
        player.getFoodData().eat(slice, sliceStack, player);
        level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        int bites = state.getValue(BITES);
        if (bites < MAX_BITES) {
            level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
        } else {
            level.removeBlock(pos, false);
            level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }
        return InteractionResult.SUCCESS;
    }

    public InteractionResult cutSlice(Level level, BlockPos pos, BlockState state, Player player) {
        int bites = state.getValue(BITES);
        if (bites < 6) {
            level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
        } else {
            level.removeBlock(pos, false);
        }
        Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), this.getSlice().getDefaultInstance());
        level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
        return InteractionResult.SUCCESS;
    }

    public boolean hasAnalogOutputSignal(BlockState pBlockState) {
        return false;
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    public Item getSlice() {
        return slice.get();
    }
}
