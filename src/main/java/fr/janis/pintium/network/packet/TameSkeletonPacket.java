package fr.janis.pintium.network.packet;

import fr.janis.pintium.entities.RatelBodyGuardEntity;
import fr.janis.pintium.entities.SkeletonBodyGuardEntity;
import fr.janis.pintium.entities.ZombieBodyGuardEntity;
import fr.janis.pintium.init.PintiumEntities;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class TameSkeletonPacket {

    public TameSkeletonPacket()
    {
    }

    public static void encode(TameSkeletonPacket packet, PacketBuffer buffer)
    {
    }

    public static TameSkeletonPacket decode(PacketBuffer buffer)
    {
        return new TameSkeletonPacket();
    }

    public static void handle(TameSkeletonPacket packet, Supplier<NetworkEvent.Context> ctxProvider) {

        SkeletonBodyGuardEntity skeleton = new SkeletonBodyGuardEntity(PintiumEntities.SKELETON_BODY_GUARD.get(), ctxProvider.get().getSender().getServerWorld());

        skeleton.setPosition(ctxProvider.get().getSender().getPosX(), ctxProvider.get().getSender().getPosY(), ctxProvider.get().getSender().getPosZ());

        ctxProvider.get().getSender().getServerWorld().addEntity(skeleton);

        ctxProvider.get().setPacketHandled(true);
    }
}