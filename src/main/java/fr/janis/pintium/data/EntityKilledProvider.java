package fr.janis.pintium.data;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityKilledProvider implements ICapabilitySerializable<CompoundNBT> {

    private final EntityKilled name = new EntityKilled();
    private final LazyOptional<IEntityKilled> nameOptional = LazyOptional.of(() -> name);

    public void invalidate() {
        nameOptional.invalidate();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return nameOptional.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        if (CapabilityEntityKilled.ENTITY_KILLED_CAPABILITY == null){
            return new CompoundNBT();
        }
        else {
            return (CompoundNBT) CapabilityEntityKilled.ENTITY_KILLED_CAPABILITY.writeNBT(name, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (CapabilityEntityKilled.ENTITY_KILLED_CAPABILITY != null){
            CapabilityEntityKilled.ENTITY_KILLED_CAPABILITY.readNBT(name, null, nbt);
        }
    }
}
