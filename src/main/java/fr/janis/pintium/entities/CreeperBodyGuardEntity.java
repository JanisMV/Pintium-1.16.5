package fr.janis.pintium.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class CreeperBodyGuardEntity extends CreeperEntity {

    public CreeperBodyGuardEntity(EntityType<? extends CreeperEntity> type, World worldIn) {
        super(type, worldIn);
    }

    // registerAttributes
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void registerGoals() {
        //super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new CreeperSwellGoal(this));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, OcelotEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, CatEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));

        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PiglinEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, CowEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SheepEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PigEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SkeletonEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, CreeperEntity.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, SpiderEntity.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, BananosaurEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, PillagerEntity.class, true));
        this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, WitchEntity.class, true));
        this.targetSelector.addGoal(11, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.addGoal(12, new NearestAttackableTargetGoal<>(this, HorseEntity.class, true));
        this.targetSelector.addGoal(13, new NearestAttackableTargetGoal<>(this, RatelEntity.class, true));
        this.targetSelector.addGoal(14, new NearestAttackableTargetGoal<>(this, BlazeEntity.class, true));
        this.targetSelector.addGoal(15, new NearestAttackableTargetGoal<>(this, CaveSpiderEntity.class, true));
        this.targetSelector.addGoal(16, new NearestAttackableTargetGoal<>(this, EndermanEntity.class, true));
        this.targetSelector.addGoal(17, new NearestAttackableTargetGoal<>(this, ElderGuardianEntity.class, true));
        this.targetSelector.addGoal(18, new NearestAttackableTargetGoal<>(this, EndermiteEntity.class, true));
        this.targetSelector.addGoal(19, new NearestAttackableTargetGoal<>(this, EvokerEntity.class, true));
        this.targetSelector.addGoal(20, new NearestAttackableTargetGoal<>(this, GhastEntity.class, true));
        this.targetSelector.addGoal(21, new NearestAttackableTargetGoal<>(this, HoglinEntity.class, true));
        this.targetSelector.addGoal(22, new NearestAttackableTargetGoal<>(this, HuskEntity.class, true));
        this.targetSelector.addGoal(23, new NearestAttackableTargetGoal<>(this, IllusionerEntity.class, true));
        this.targetSelector.addGoal(24, new NearestAttackableTargetGoal<>(this, MagmaCubeEntity.class, true));
        this.targetSelector.addGoal(25, new NearestAttackableTargetGoal<>(this, PhantomEntity.class, true));
        this.targetSelector.addGoal(26, new NearestAttackableTargetGoal<>(this, RavagerEntity.class, true));
        this.targetSelector.addGoal(27, new NearestAttackableTargetGoal<>(this, ShulkerEntity.class, true));
        this.targetSelector.addGoal(28, new NearestAttackableTargetGoal<>(this, SilverfishEntity.class, true));
        this.targetSelector.addGoal(29, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(30, new NearestAttackableTargetGoal<>(this, WitherSkeletonEntity.class, true));
        this.targetSelector.addGoal(31, new NearestAttackableTargetGoal<>(this, ZoglinEntity.class, true));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player){
        return 0;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id){
        super.handleStatusUpdate(id);
    }
}
