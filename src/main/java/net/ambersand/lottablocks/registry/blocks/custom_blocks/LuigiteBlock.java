package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.ambersand.lottablocks.registry.blocks.ModBlockStateProperties;
import net.ambersand.lottablocks.registry.items.custom_items.LuigiteJumpscareItem;
import net.ambersand.lottablocks.registry.misc.ModTags;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class LuigiteBlock extends Block {

    private static final BooleanProperty SCARY = ModBlockStateProperties.SCARY;

    public LuigiteBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SCARY, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SCARY);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        if (!player.getItemInHand(interactionHand).is(ModTags.LUIGITE_BLOCKS) && !player.getItemInHand(interactionHand).is(Items.NOTE_BLOCK)) {
            if (blockState.getValue(SCARY)) {
                return InteractionResult.CONSUME;
            } else {
                this.angerLuigite(level, player, blockPos, blockState, player.getOnPos().above());
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    public void onProjectileHit(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockHitResult hitResult, @NotNull Projectile projectile) {
        if (projectile.getOwner() != null && projectile.getOwner() instanceof Player player && !player.level().isClientSide()) {
            this.angerLuigite(level, player, hitResult.getBlockPos(), blockState, hitResult.getBlockPos().above());
        }
        super.onProjectileHit(level, blockState, hitResult, projectile);
    }

    @Override
    public void tick(BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (blockState.getValue(SCARY)) {
            serverLevel.setBlock(blockPos, blockState.setValue(SCARY, false), 3);
        }
    }

    private void angerLuigite(Level level, Player player, BlockPos blockPos, BlockState blockState, BlockPos lightningPos) {

        LuigiteJumpscareItem.sendLuigiteJumpscareAnimation(player);

        ServerPlayer cause = !level.isClientSide ? (ServerPlayer) player : null;

        LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(level);

        if (lightningBolt != null) {
            lightningBolt.moveTo(Vec3.atBottomCenterOf(lightningPos));
            lightningBolt.setCause(cause);
            level.addFreshEntity(lightningBolt);
        }

        if (level.getServer() != null) level.getServer().getPlayerList().broadcastSystemMessage(Component.translatable("gui.lottablocks.luigite_message").withStyle(ChatFormatting.DARK_RED), false);
        level.playSound(null, blockPos, ModSoundEvents.BLOCK_LUIGITE_SCREAM, SoundSource.BLOCKS, 10.0F, 1.0F);
        level.gameEvent(player, GameEvent.BLOCK_ACTIVATE, blockPos);

        level.setBlock(blockPos, blockState.setValue(SCARY, true), 3);
        level.scheduleTick(blockPos, this, 20);
    }
}