package net.ambersand.lottablocks.mixin.blocks;

import net.ambersand.lottablocks.registry.misc.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalConnectingBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PaneBlock.class)
public abstract class GlassPaneBlockMixin extends HorizontalConnectingBlock {

    private GlassPaneBlockMixin(float f, float g, float h, float i, float j, Settings properties) {
        super(f, g, h, i, j, properties);
    }

    @Inject(at = @At("HEAD"), method = "skipRendering", cancellable = true)
    private void lottaBlocks$occludeGlassPaneFaces(BlockState blockState, BlockState adjacentBlock, Direction direction, CallbackInfoReturnable<Boolean> cir) {

        if (!(adjacentBlock.getBlock() instanceof PaneBlock)) return;

        if (adjacentBlock.isIn(ModTags.OCCLUDING_GLASS_PANES) && (!direction.getAxis().isHorizontal() || blockState.get(FACING_PROPERTIES.get(direction)) && adjacentBlock.get(FACING_PROPERTIES.get(direction.getOpposite())))) {
            cir.setReturnValue(true);
        }
    }
}