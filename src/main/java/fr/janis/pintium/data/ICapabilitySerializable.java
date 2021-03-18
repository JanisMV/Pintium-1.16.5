package fr.janis.pintium.data;

import net.minecraft.nbt.INBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

public interface ICapabilitySerializable<T extends INBT> extends ICapabilityProvider, INBTSerializable<T> { }