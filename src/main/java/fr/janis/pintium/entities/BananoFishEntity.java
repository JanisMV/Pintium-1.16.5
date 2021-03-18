package fr.janis.pintium.entities;

import fr.janis.pintium.init.PintiumItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BananoFishEntity extends AbstractFishEntity {

    public BananoFishEntity(EntityType<? extends AbstractFishEntity> type, World worldIn) {
        super(type, worldIn);
        //EntitySpawnPlacementRegistry.register(PintiumEntities.RATEL.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
    }

    // registerAttributes
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.50D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, 0.75D));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 0.75D, 1));
    }

    @Override
    protected ItemStack getFishBucket() {
        return PintiumItems.BANANOFISH_BUCKET.get().getDefaultInstance();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player){
        return 1 + this.world.rand.nextInt(4);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COD_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COD_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_COD_HURT;
    }
}
