package net.graedevs.morecreeps.Common.entity;

import net.graedevs.morecreeps.Client.render.BlorpRender;
import net.graedevs.morecreeps.Common.init.CreepsSoundHandler;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.AxisAlignedLinearPosTest;

public class BlorpEntity extends Monster {

    private static final EntityDataAccessor<Boolean> hungry = SynchedEntityData.defineId(BlorpEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> hungryTime = SynchedEntityData.defineId(BlorpEntity.class, EntityDataSerializers.INT);

    public BlorpEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.xpReward = 5;


    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 5.0)
                .add(Attributes.MOVEMENT_SPEED, 0.6)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.ATTACK_SPEED, 2)
                .add(Attributes.ATTACK_KNOCKBACK,2);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.2));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BlorpEntity.class, true));
    }

    public void tick() {
        super.tick();
    }

    private void setHungry(boolean b) {
        entityData.set(hungry, Boolean.valueOf(b));
    }

    public boolean getHungry()
    {
        return ((Boolean)entityData.get(hungry)).booleanValue();
    }

    private void setHungryTime(int i)
    {
        entityData.set(hungryTime, i);
    }

    public int getHungryTime()
    {
        return entityData.get(hungryTime);
    }

    public float getBlockPathWeight(BlockPos blockPos) {
        Block block = getCommandSenderWorld().getBlockState(blockPos).getBlock();

        if(block == Blocks.OAK_LEAVES || block == Blocks.SPRUCE_LEAVES || block == Blocks.OAK_LOG || block == Blocks.SPRUCE_LOG) {
            return 10f;
        }
        return this.getBlockPathWeight(blockPos);
    }

    public SoundEvent getAmbientSound() {
        return CreepsSoundHandler.BLORPSOUND.get();
    }

    public SoundEvent getHurtSound(DamageSource damageSourceIN) {
        return CreepsSoundHandler.BLORPHURT.get();
    }

    public SoundEvent getDeathSound() {
        return CreepsSoundHandler.BLORPDEATH.get();
    }

    @Override
    protected int calculateFallDamage(float distance, float amount) {
        return super.calculateFallDamage(distance, amount) - 10;
    }

    public MobType getMobType() {
        return MobType.UNDEFINED;
    }
}
