package fr.janis.pintium.entities;

import fr.janis.pintium.init.PintiumEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class BananosaurEntity extends AnimalEntity {

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.APPLE);

    public BananosaurEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
        //EntitySpawnPlacementRegistry.register(PintiumEntities.RATEL.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
    }

    // registerAttributes
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.50D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 1)
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new FollowParentGoal(this, 0.50D));
        this.goalSelector.addGoal(2, new PanicGoal(this, 0.75D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1D, TEMPTATION_ITEMS, false));
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.75D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player){
        return 1 + this.world.rand.nextInt(4);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SALMON_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SALMON_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SALMON_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        super.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return PintiumEntities.BANANOSAUR.get().create(this.world);
    }
}
