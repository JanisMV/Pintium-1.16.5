package fr.janis.pintium.tileentity;

import fr.janis.pintium.init.PintiumTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPintiumEffectInvisibleBlock extends TileEntity implements ITickableTileEntity {

    private int counter = 0;

    public TileEntityPintiumEffectInvisibleBlock() {

        super(PintiumTileEntities.PINTIUM_EFFECT_INVISIBLE_BLOCK_TILE_ENTITY.get());

    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) { //fonction read
        super.read(state, nbt);

        this.setCounter(nbt.getInt("counter"));

    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);

        compound.putInt("counter", this.getCounter());

        return compound;
    }

    @Override
    public void tick(){
        setCounter(getCounter()+1);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
