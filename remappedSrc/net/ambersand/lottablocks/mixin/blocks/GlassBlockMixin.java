package net.ambersand.lottablocks.mixin.blocks;

import net.ambersand.lottablocks.registry.misc.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TranslucentBlock.class)
public class GlassBlockMixin extends Block {

    private GlassBlockMixin(Settings properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Inject(at = @At("HEAD"), method = "skipRendering", cancellable = true)
    private void lottaBlocks$occludeGlassFaces(BlockState blockState, BlockState adjacentBlock, Direction direction, CallbackInfoReturnable<Boolean> cir) {

        TagKey<Block> occludingGlass = ModTags.OCCLUDING_GLASS;

        if (blockState.isIn(occludingGlass)) cir.setReturnValue(adjacentBlock.isIn(occludingGlass) || super.isSideInvisible(blockState, adjacentBlock, direction));
    }
}