package net.graedevs.morecreeps.Common.item;

import net.graedevs.morecreeps.Common.init.CreepsSoundHandler;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BandaidItem extends Item {

    public static final int amount = 4;
    public BandaidItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (player.getHealth() < 20f) {
            player.heal(amount);
            player.getItemInHand(hand).shrink(1);
            player.getLevel().playSound(player, player, CreepsSoundHandler.BANDAID_SOUND.get(),
                    SoundSource.AMBIENT, 1f, 1f);
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }
}
