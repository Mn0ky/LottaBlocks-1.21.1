package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.ambersand.lottablocks.LottaBlocks;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class PaperLanternBlock extends Block {

    public PaperLanternBlock(Settings properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getOutlineShape(@NotNull BlockState blockState, @NotNull BlockView blockGetter, @NotNull BlockPos blockPos, @NotNull ShapeContext collisionContext) {
        return VoxelShapes.union(Block.createCuboidShape(4.0, 0, 4.0, 12.0, 2.0, 12.0), Block.createCuboidShape(2.0, 2.0, 2.0, 14.0, 14.0, 14.0), Block.createCuboidShape(4.0, 14.0, 4.0, 12.0, 16.0, 12.0));
    }

    @Override
    public void onProjectileHit(@NotNull World level, @NotNull BlockState blockState, @NotNull BlockHitResult hitResult, @NotNull ProjectileEntity projectile) {
        this.destroyPaperLantern(level, hitResult.getBlockPos());
        super.onProjectileHit(level, blockState, hitResult, projectile);
    }

    @Override
    public void onEntityCollision(@NotNull BlockState blockState, @NotNull World level, @NotNull BlockPos blockPos, Entity entity) {
        if (LottaBlocks.HAS_ENDLESS_ENCORE && entity instanceof LivingEntity livingEntity && livingEntity.isFallFlying() && livingEntity.getVelocity().horizontalLength() >= 0.7) {
            this.destroyPaperLantern(level, blockPos);
        }
        super.onEntityCollision(blockState, level, blockPos, entity);
    }

    private void destroyPaperLantern(World level, BlockPos blockPos) {
        if (!level.isClient()) {
            level.playSound(null, blockPos, ModSoundEvents.BLOCK_PAPER_LANTERN_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F + level.getRandom().nextFloat() * 1.2F);
            level.breakBlock(blockPos, true);
        }
    }
}