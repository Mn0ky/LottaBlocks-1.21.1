package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class CongealedPissBlock extends Block {

    public CongealedPissBlock(Properties settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void entityInside(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Entity entity) {

        if (entity instanceof LivingEntity livingEntity) {

            livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 800));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100));

            livingEntity.makeStuckInBlock(blockState, new Vec3(0.9D, 1.5D, 0.9D));
        }

        super.entityInside(blockState, level, blockPos, entity);
    }
}