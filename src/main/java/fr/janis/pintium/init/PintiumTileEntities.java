package fr.janis.pintium.init;

import fr.janis.pintium.main;

import fr.janis.pintium.tileentity.TileEntityPintiumEffectInvisibleBlock;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PintiumTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, main.MODID);

    public static final RegistryObject<TileEntityType<?>> PINTIUM_EFFECT_INVISIBLE_BLOCK_TILE_ENTITY = TILE_ENTITIES.register("pintium_craft_table", () -> TileEntityType.Builder.create(TileEntityPintiumEffectInvisibleBlock::new, PintiumBlocks.PINTIUM_EFFECT_INVISIBLE_BLOCK.get()).build(null));
}
