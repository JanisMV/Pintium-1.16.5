package fr.janis.pintium.data;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class CapabilityEntityKilled {
    @CapabilityInject(IEntityKilled.class)
    public static Capability<IEntityKilled> ENTITY_KILLED_CAPABILITY = null;

    public static void register(){
        CapabilityManager.INSTANCE.register(IEntityKilled.class, new Storage(), EntityKilled::new);
    }

    public static class Storage implements Capability.IStorage<IEntityKilled> {

        @Nullable
        @Override
        public INBT writeNBT(Capability<IEntityKilled> capability, IEntityKilled instance, Direction side) {
            CompoundNBT tag = new CompoundNBT();
            if (instance.getName() != null){
                tag.putString("name", instance.getName());
            }
            return tag;
        }

        @Override
        public void readNBT(Capability<IEntityKilled> capability, IEntityKilled instance, Direction side, INBT nbt) {
            String name = ((CompoundNBT) nbt).getString("name");
            if (!name.isEmpty()){
                instance.setName(name);
            }
        }
    }
}
