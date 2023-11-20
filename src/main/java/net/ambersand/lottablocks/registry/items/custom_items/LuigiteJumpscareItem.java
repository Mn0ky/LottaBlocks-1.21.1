package net.ambersand.lottablocks.registry.items.custom_items;

import net.ambersand.lottablocks.registry.sounds.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {

        ItemStack itemStack = player.getItemInHand(interactionHand);
        var minecraft = Minecraft.getInstance();

        player.getCooldowns().addCooldown(this, 20);

        if (player == minecraft.player) {
            minecraft.gameRenderer.displayItemActivation(this.asItem().getDefaultInstance());
        }

        level.playSound(null, player.getOnPos().above(), ModSoundEvents.BLOCK_LUIGITE_SCREAM, SoundSource.PLAYERS, 1.0F, 1.0F);
        player.gameEvent(GameEvent.ITEM_INTERACT_START);
        player.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}