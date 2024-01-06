package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class PaperLanternBlock extends Block {

    public PaperLanternBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return Shapes.or(Block.box(4.0, 0, 4.0, 12.0, 2.0, 12.0), Block.box(2.0, 2.0, 2.0, 14.0, 14.0, 14.0), Block.box(4.0, 14.0, 4.0, 12.0, 16.0, 12.0));
    }

    @Override
    public void onProjectileHit(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockHitResult blockHitResult, @NotNull Projectile projectile) {

        // Paper Lanterns are broken when hit by a projectile

        BlockPos blockPos = blockHitResult.getBlockPos();

        if (!level.isClientSide) {
            level.playSound(null, blockPos, ModSoundEvents.BLOCK_PAPER_LANTERN_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F + level.random.nextFloat() * 1.2F);
            level.destroyBlock(blockPos, true);
        }
    }
}