package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class AmethystFloodlightBlock extends Block implements SimpleWaterloggedBlock, AmethystChimeInterface {

    public static final BooleanProperty
        HANGING = BlockStateProperties.HANGING,
        WATERLOGGED = BlockStateProperties.WATERLOGGED
    ;

    public AmethystFloodlightBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HANGING, false).setValue(WATERLOGGED, false));
    }

    @SuppressWarnings("deprecation")
    public void onProjectileHit(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockHitResult hitResult, @NotNull Projectile projectile) {
        this.playChimeSounds(level, hitResult);
        super.onProjectileHit(level, blockState, hitResult, projectile);
    }

    // region Initialization

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HANGING, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {

        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        Direction[] lookingDirections = blockPlaceContext.getNearestLookingDirections();

        for (Direction direction : lookingDirections) {

            if (direction.getAxis() == Direction.Axis.Y) {

                BlockState blockState = this.defaultBlockState().setValue(HANGING, direction == Direction.UP);

                if (blockState.canSurvive(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos())) {
                    return blockState.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
                }
            }
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    public boolean canSurvive(@NotNull BlockState blockState, @NotNull LevelReader levelReader, BlockPos blockPos) {
        Direction direction = attachedDirection().getOpposite();
        return Block.canSupportCenter(levelReader, blockPos.relative(direction), direction.getOpposite());
    }

    @SuppressWarnings("deprecation")
    public @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    protected static Direction attachedDirection() {
        return Direction.DOWN;
    }

    // endregion

    // region Hitbox

    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return Block.box(2.0D, 6.0D, 2.0D, 14.0D, 9.0D, 14.0D);
    }

    @SuppressWarnings("deprecation")
    public @NotNull BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos neighborPos) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return attachedDirection().getOpposite() == direction && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, neighborState, levelAccessor, blockPos, neighborPos);
    }

    @SuppressWarnings("deprecation")
    public boolean isPathfindable(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull PathComputationType pathComputationType) {
        return false;
    }

    // endregion
}