package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.LichenGrower;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.level.block.*;
import org.jetbrains.annotations.NotNull;

public class MossOverlayBlock extends MultifaceGrowthBlock implements Fertilizable, Waterloggable {

    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private final LichenGrower spreader = new LichenGrower(this);

    public MossOverlayBlock(Settings properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
    }

    // region Initialization

    @Override
    public @NotNull MapCodec<MossOverlayBlock> getCodec() {
        return createCodec(MossOverlayBlock::new);
    }

    @Override
    protected void appendProperties(StateManager.@NotNull Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    public boolean canReplace(@NotNull BlockState blockState, ItemPlacementContext blockPlaceContext) {
        return !blockPlaceContext.getStack().isOf(this.asItem()) || super.canReplace(blockState, blockPlaceContext);
    }

    @Override
    public @NotNull BlockState getStateForNeighborUpdate(BlockState blockState, @NotNull Direction direction, @NotNull BlockState adjacentState, @NotNull WorldAccess levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos adjacentPos) {
        if (blockState.get(WATERLOGGED)) levelAccessor.scheduleFluidTick(blockPos, Fluids.WATER, Fluids.WATER.getTickRate(levelAccessor));
        return super.getStateForNeighborUpdate(blockState, direction, adjacentState, levelAccessor, blockPos, adjacentPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull FluidState getFluidState(BlockState blockState) {
        if (blockState.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(blockState);
    }

    @Override
    public @NotNull LichenGrower getGrower() {
        return this.spreader;
    }

    @Override
    public boolean isTransparent(BlockState blockState, @NotNull BlockView blockGetter, @NotNull BlockPos blockPos) {
        return blockState.getFluidState().isEmpty();
    }

    // endregion

    // region Bone-Mealing

    @Override
    public boolean isFertilizable(@NotNull WorldView levelReader, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return Direction.stream().anyMatch(direction -> this.getGrower().canGrow(blockState, levelReader, blockPos, direction.getOpposite()));
    }

    @Override
    public boolean canGrow(@NotNull World level, @NotNull Random randomSource, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return true;
    }

    @Override
    public void grow(@NotNull ServerWorld serverLevel, @NotNull Random randomSource, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.getGrower().grow(blockState, serverLevel, blockPos, randomSource);
    }

    // endregion
}