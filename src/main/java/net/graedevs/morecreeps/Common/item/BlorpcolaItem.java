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

public class BlorpcolaItem extends Item {

    private static final int amount = 2;

    public BlorpcolaItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.swing(hand);
        player.getLevel().playSound(player, player, CreepsSoundHandler.BLORPCOLA.get(),
                SoundSource.AMBIENT, 1f, 1f);
        player.getItemInHand(hand).shrink(1);
        player.heal(amount);

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }
}
