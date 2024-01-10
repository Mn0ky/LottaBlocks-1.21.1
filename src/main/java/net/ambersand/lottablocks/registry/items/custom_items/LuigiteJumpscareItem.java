package net.ambersand.lottablocks.registry.items.custom_items;

import io.netty.buffer.Unpooled;
import net.ambersand.lottablocks.registry.LottaBlocksRegistry;
import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class LuigiteJumpscareItem extends Item {

    public LuigiteJumpscareItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {

        player.getCooldowns().addCooldown(this, 20);
        sendLuigiteJumpscareAnimation(player);

        level.playSound(null, player.getOnPos().above(), ModSoundEvents.BLOCK_LUIGITE_SCREAM, SoundSource.PLAYERS, 10.0F, 1.0F);
        player.gameEvent(GameEvent.ITEM_INTERACT_START);

        player.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResultHolder.sidedSuccess(player.getItemInHand(interactionHand), level.isClientSide());
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {

        target.level().playSound(null, target.getOnPos().above(), ModSoundEvents.BLOCK_LUIGITE_SCREAM, SoundSource.PLAYERS, 10.0F, 1.0F);

        if (target instanceof Player player) {
            sendLuigiteJumpscareAnimation(player);
        }

        return super.hurtEnemy(itemStack, target, attacker);
    }

    public static void sendLuigiteJumpscareAnimation(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            FriendlyByteBuf packet = new FriendlyByteBuf(Unpooled.buffer());
            packet.writeInt(0);
            ServerPlayNetworking.send(serverPlayer, LottaBlocksRegistry.LUIGITE_PACKET_ID, packet);
        }
    }
}