package fr.janis.pintium.init;
import fr.janis.pintium.blocks.PintiumEffectInvisibleBlock;
import fr.janis.pintium.main;

import fr.janis.pintium.utils.PintiumItemGroup;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.block.TallFlowerBlock;

import java.util.function.Supplier;

public class    PintiumBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, main.MODID);

    public static final RegistryObject<Block> PINTIUM_BLOCK = createBlock("pintium_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(8f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().sound(SoundType.METAL)));
    public static final RegistryObject<Block> PINTIUM_EFFECT_INVISIBLE_BLOCK = createBlock("pintium_effect_invisible_block", PintiumEffectInvisibleBlock::new);

    public static final RegistryObject<Block> PINTIUM_OVERWORLD_ORE = createBlock("pintium_overworld_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(4f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().sound(SoundType.STONE)));
    public static final RegistryObject<Block> PINTIUM_NETHER_ORE = createBlock("pintium_nether_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(4f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool().sound(SoundType.STONE)));

    public static final RegistryObject<Block> PINTIUM_CROP =
            BLOCKS.register("pintium_crop", () -> new PintiumCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> CANNABIS_CROP =
            BLOCKS.register("cannabis_crop", () -> new CannabisCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);

        if(name.equals("pintium_effect_invisible_block")){
            PintiumItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }
        else{
            PintiumItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
        }

        return block;
    }

}
