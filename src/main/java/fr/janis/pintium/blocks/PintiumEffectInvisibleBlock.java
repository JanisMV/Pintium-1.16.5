package fr.janis.pintium.blocks;

import fr.janis.pintium.gui.SpellsGui;
import fr.janis.pintium.init.PintiumBlocks;
import fr.janis.pintium.init.PintiumItems;
import fr.janis.pintium.tileentity.TileEntityPintiumEffectInvisibleBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.command.impl.EffectCommand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.potion.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;

public class PintiumEffectInvisibleBlock extends Block {

    public PintiumEffectInvisibleBlock() {
        super(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(5f, 28f).harvestTool(ToolType.AXE).harvestLevel(2).setRequiresTool());
    }

    @Override
    public boolean hasTileEntity(BlockState state){
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world){
        return new TileEntityPintiumEffectInvisibleBlock();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(worldIn.getTileEntity(pos) instanceof TileEntityPintiumEffectInvisibleBlock){
            TileEntityPintiumEffectInvisibleBlock tileEntity = (TileEntityPintiumEffectInvisibleBlock) worldIn.getTileEntity(pos);

            player.sendStatusMessage(new StringTextComponent("Counter : " + tileEntity.getCounter()), true);
            player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 1200, 1, true, false));
            Minecraft.getInstance().displayGuiScreen(new SpellsGui());

            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }
}
