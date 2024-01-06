package net.ambersand.lottablocks.registry.blocks.custom_blocks;

import net.ambersand.lottablocks.registry.blocks.ModBlockStateProperties;
import net.ambersand.lottablocks.registry.items.ModItems;
import net.ambersand.lottablocks.registry.misc.ModTags;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

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

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        if (!player.getItemInHand(interactionHand).is(ModTags.LUIGITE_BLOCKS)) {
            if (blockState.getValue(SCARY)) {
                return InteractionResult.CONSUME;
            } else {

                ServerPlayer cause = !level.isClientSide ? (ServerPlayer) player : null;
                var minecraft = Minecraft.getInstance();

                LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(level);

                if (lightningBolt != null) {
                    lightningBolt.moveTo(Vec3.atBottomCenterOf(player.getOnPos().above()));
                    lightningBolt.setCause(cause);
                    level.addFreshEntity(lightningBolt);
                }

                if (level.getServer() != null) {
                    level.getServer().getPlayerList().broadcastSystemMessage(Component.translatable("gui.lottablocks.luigite_message").withStyle(ChatFormatting.DARK_RED), false);
                }

                if (player == minecraft.player) {
                    minecraft.gameRenderer.displayItemActivation(ModItems.LUIGITE_JUMPSCARE.getDefaultInstance());
                }

                level.playSound(null, blockPos, ModSoundEvents.BLOCK_LUIGITE_SCREAM, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(player, GameEvent.BLOCK_ACTIVATE, blockPos);

                level.setBlock(blockPos, blockState.setValue(SCARY, true), 3);
                level.scheduleTick(blockPos, this, 20);

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick(BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (blockState.getValue(SCARY)) {
            serverLevel.setBlock(blockPos, blockState.setValue(SCARY, false), 3);
        }
    }
}