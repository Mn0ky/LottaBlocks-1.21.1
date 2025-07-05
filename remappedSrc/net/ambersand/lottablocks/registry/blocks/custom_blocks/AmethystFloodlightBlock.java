package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class AmethystFloodlightBlock extends Block implements Waterloggable, AmethystChimeInterface {

    public static final BooleanProperty
        HANGING = Properties.HANGING,
        WATERLOGGED = Properties.WATERLOGGED
    ;

    public AmethystFloodlightBlock(Settings properties) {
        super(properties);
        this.setDefaultState(this.getStateManager().getDefaultState().with(HANGING, false).with(WATERLOGGED, false));
    }

    public void onProjectileHit(@NotNull World level, @NotNull BlockState blockState, @NotNull BlockHitResult hitResult, @NotNull ProjectileEntity projectile) {
        this.playChimeSounds(level, hitResult);
        super.onProjectileHit(level, blockState, hitResult, projectile);
    }

    // region Initialization

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HANGING, WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext blockPlaceContext) {

        FluidState fluidState = blockPlaceContext.getWorld().getFluidState(blockPlaceContext.getBlockPos());
        Direction[] lookingDirections = blockPlaceContext.getPlacementDirections();

        for (Direction direction : lookingDirections) {
            if (direction.getAxis() == Direction.Axis.Y) {
                BlockState blockState = this.getDefaultState().with(HANGING, direction == Direction.UP);
                if (blockState.canPlaceAt(blockPlaceContext.getWorld(), blockPlaceContext.getBlockPos())) return blockState.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
            }
        }
        return null;
    }

    public boolean canPlaceAt(@NotNull BlockState blockState, @NotNull WorldView levelReader, BlockPos blockPos) {
        Direction direction = attachedDirection().getOpposite();
        return Block.sideCoversSmallSquare(levelReader, blockPos.offset(direction), direction.getOpposite());
    }

    public @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(blockState);
    }

    protected static Direction attachedDirection() {
        return Direction.DOWN;
    }

    // endregion

    // region Hitbox

    public @NotNull VoxelShape getOutlineShape(@NotNull BlockState blockState, @NotNull BlockView blockGetter, @NotNull BlockPos blockPos, @NotNull ShapeContext collisionContext) {
        return Block.createCuboidShape(2.0D, 6.0D, 2.0D, 14.0D, 9.0D, 14.0D);
    }

    public @NotNull BlockState getStateForNeighborUpdate(BlockState blockState, @NotNull Direction direction, @NotNull BlockState adjacentState, @NotNull WorldAccess levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos adjacentPos) {
        if (blockState.get(WATERLOGGED)) {
            levelAccessor.scheduleFluidTick(blockPos, Fluids.WATER, Fluids.WATER.getTickRate(levelAccessor));
        }
        return attachedDirection().getOpposite() == direction && !blockState.canPlaceAt(levelAccessor, blockPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(blockState, direction, adjacentState, levelAccessor, blockPos, adjacentPos);
    }

    public boolean isPathfindable(@NotNull BlockState blockState, @NotNull BlockView blockGetter, @NotNull BlockPos blockPos, @NotNull NavigationType pathComputationType) {
        return false;
    }

    // endregion
}