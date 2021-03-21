package fr.janis.pintium.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PintiumFeatures {

    public ConfiguredFeature<?, ?> PINTIUM_OVERWORLD_ORE;
    public ConfiguredFeature<?, ?> PINTIUM_NETHER_ORE;

    public void init(){

        PINTIUM_OVERWORLD_ORE = register("pintium_overworld_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PintiumBlocks.PINTIUM_OVERWORLD_ORE.get().getDefaultState(), 6))
        .square()
        .range(12) //Couche ou l'on le trouve
        .count(2)); // Nombre de filons par chunk

        PINTIUM_NETHER_ORE = register("pintium_nether_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, PintiumBlocks.PINTIUM_NETHER_ORE.get().getDefaultState(), 6))
        .square()
        .range(20)
        .count(2));
    }

    public <FC extends IFeatureConfig>ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature){

        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);

    }

    @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent e){

        BiomeGenerationSettingsBuilder generation = e.getGeneration();
        if(e.getCategory() != Biome.Category.NETHER){
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, PINTIUM_OVERWORLD_ORE);
        }
        else{
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, PINTIUM_NETHER_ORE);
        }

        if (e.getCategory() == Biome.Category.NETHER) {}

        else if (e.getCategory() == Biome.Category.THEEND) {}

        else {
            if (e.getCategory() != Biome.Category.OCEAN && e.getCategory() != Biome.Category.RIVER){
                e.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(PintiumEntities.RATEL.get(), 3, 5, 5));
                e.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(PintiumEntities.BANANOSAUR.get(), 1, 1, 5));
            }
            else {
                e.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(PintiumEntities.TUNA.get(), 5, 5, 5));
                e.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(PintiumEntities.BANANOFISH.get(), 5, 5, 5));
            }
        }
    }
}
