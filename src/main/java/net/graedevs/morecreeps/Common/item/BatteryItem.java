package net.graedevs.morecreeps.Common.item;

import net.graedevs.morecreeps.Common.init.CreepsSoundHandler;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BatteryItem extends Item {
    public BatteryItem(Item.Properties properties) { super(properties); }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.getLevel().playSound(player, player, CreepsSoundHandler.SPARK.get(),
                SoundSource.AMBIENT, 1f, 1f);
        player.hurt(DamageSource.IN_FIRE, 1.0F);

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }
}
