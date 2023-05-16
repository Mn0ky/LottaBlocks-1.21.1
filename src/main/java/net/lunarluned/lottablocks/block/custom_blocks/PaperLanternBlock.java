package net.lunarluned.lottablocks.block.custom_blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.lunarluned.lottablocks.sound.ModSoundEvents;
import org.jetbrains.annotations.NotNull;

public class PaperLanternBlock extends Block {

    public static final VoxelShape SHAPE = Shapes.or(Block.box(4.0, 0, 4.0, 12.0, 2.0, 12.0), Block.box(2.0, 2.0, 2.0, 14.0, 14.0, 14.0), Block.box(4.0, 14.0, 4.0, 12.0, 16.0, 12.0));

    public PaperLanternBlock(Properties settings) {
        super(settings);
    }

    // Gets the hitbox shape for the block

    @SuppressWarnings("ALL")
    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    // Paper Lanterns are broken when pushed by pistons

    @SuppressWarnings("ALL")
    public PushReaction getPistonPushReaction(@NotNull BlockState state) {
        return PushReaction.DESTROY;
    }


    // Paper Lanterns are broken when hit by a projectile

    @SuppressWarnings("ALL")
    @Override
    public void onProjectileHit(@NotNull Level level, @NotNull BlockState state, @NotNull BlockHitResult hit, @NotNull Projectile projectile) {
        if (!level.isClientSide) {
            BlockPos blockPos = hit.getBlockPos();
            level.playSound(null, blockPos, ModSoundEvents.BLOCK_PAPER_LANTERN_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F + level.random.nextFloat() * 1.2F);
            level.destroyBlock(blockPos, true);
        }
    }
}