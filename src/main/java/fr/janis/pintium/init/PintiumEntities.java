package fr.janis.pintium.init;

import fr.janis.pintium.entities.*;
import fr.janis.pintium.main;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PintiumEntities {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, main.MODID);

    // Entity Types
    public static final RegistryObject<EntityType<RatelEntity>> RATEL = ENTITY_TYPES.register("ratel",
            () -> EntityType.Builder.create(RatelEntity::new, EntityClassification.MONSTER)
                    .size(1.0F, 1.0F)
                    .build(new ResourceLocation(main.MODID, "ratel").toString())
    );
    
    public static final RegistryObject<EntityType<RatelBodyGuardEntity>> RATEL_BODY_GUARD = ENTITY_TYPES.register(
            "ratel_body_guard",
            () -> EntityType.Builder.create(RatelBodyGuardEntity::new, EntityClassification.MONSTER)
                .size(1.0F, 1.0F)
            .build(new ResourceLocation(main.MODID, "ratel").toString())
    );

    public static final RegistryObject<EntityType<ZombieBodyGuardEntity>> ZOMBIE_BODY_GUARD = ENTITY_TYPES.register(
            "zombie_body_guard",
            () -> EntityType.Builder.create(ZombieBodyGuardEntity::new, EntityClassification.MONSTER)
                    .size(1.0F, 1.0F)
                    .build(new ResourceLocation(main.MODID, "zombie").toString())
    );

    public static final RegistryObject<EntityType<SkeletonBodyGuardEntity>> SKELETON_BODY_GUARD = ENTITY_TYPES.register(
            "skeleton_body_guard",
            () -> EntityType.Builder.create(SkeletonBodyGuardEntity::new, EntityClassification.MONSTER)
                    .size(1.0F, 1.0F)
                    .build(new ResourceLocation(main.MODID, "skeleton").toString())
    );

    public static final RegistryObject<EntityType<CreeperBodyGuardEntity>> CREEPER_BODY_GUARD = ENTITY_TYPES.register(
            "creeper_body_guard",
            () -> EntityType.Builder.create(CreeperBodyGuardEntity::new, EntityClassification.MONSTER)
                    .size(1.0F, 1.0F)
                    .build(new ResourceLocation(main.MODID, "creeper").toString())
    );

    public static final RegistryObject<EntityType<BananosaurEntity>> BANANOSAUR = ENTITY_TYPES.register("bananosaur",
            () -> EntityType.Builder.create(BananosaurEntity::new, EntityClassification.CREATURE)
            .size(2.0F, 2.0F)
            .build(new ResourceLocation(main.MODID, "bananosaur").toString())
    );

    public static final RegistryObject<EntityType<TunaEntity>> TUNA = ENTITY_TYPES.register("tuna",
            () -> EntityType.Builder.create(TunaEntity::new, EntityClassification.WATER_CREATURE)
            .size(1.0F, 1.0F)
            .build(new ResourceLocation(main.MODID, "tuna").toString())
    );

    public static final RegistryObject<EntityType<BananoFishEntity>> BANANOFISH = ENTITY_TYPES.register("bananofish",
            () -> EntityType.Builder.create(BananoFishEntity::new, EntityClassification.WATER_CREATURE)
            .size(1.0F, 1.0F)
            .build(new ResourceLocation(main.MODID, "bananofish").toString())
    );
}
