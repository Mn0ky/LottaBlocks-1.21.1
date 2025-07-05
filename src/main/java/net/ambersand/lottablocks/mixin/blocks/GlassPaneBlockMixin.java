package net.ambersand.lottablocks.mixin.blocks;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.ambersand.lottablocks.registry.misc.ModTags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(IronBarsBlock.class)
public abstract class GlassPaneBlockMixin extends CrossCollisionBlock {

    private GlassPaneBlockMixin(float f, float g, float h, float i, float j, Properties properties) {
        super(f, g, h, i, j, properties);
    }

    @Inject(at = @At("HEAD"), method = "skipRendering", cancellable = true)
    private void lottaBlocks$occludeGlassPaneFaces(BlockState blockState, BlockState adjacentBlock, Direction direction, CallbackInfoReturnable<Boolean> cir) {

        if (!(adjacentBlock.getBlock() instanceof IronBarsBlock)) return;

        if (adjacentBlock.is(ModTags.OCCLUDING_GLASS_PANES) && (!direction.getAxis().isHorizontal() || blockState.getValue(PROPERTY_BY_DIRECTION.get(direction)) && adjacentBlock.getValue(PROPERTY_BY_DIRECTION.get(direction.getOpposite())))) {
            cir.setReturnValue(true);
        }
    }
}