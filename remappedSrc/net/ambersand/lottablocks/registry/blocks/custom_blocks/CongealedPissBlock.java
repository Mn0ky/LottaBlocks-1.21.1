package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class CongealedPissBlock extends Block {

    public CongealedPissBlock(Settings settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onEntityCollision(@NotNull BlockState blockState, @NotNull World level, @NotNull BlockPos blockPos, @NotNull Entity entity) {

        if (entity instanceof LivingEntity livingEntity) {

            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 400));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 800));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 100));

            livingEntity.slowMovement(blockState, new Vec3d(0.9D, 1.5D, 0.9D));
        }

        super.onEntityCollision(blockState, level, blockPos, entity);
    }
}