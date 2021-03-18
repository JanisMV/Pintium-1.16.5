package fr.janis.pintium.network.packet;

import fr.janis.pintium.entities.CreeperBodyGuardEntity;
import fr.janis.pintium.entities.RatelBodyGuardEntity;
import fr.janis.pintium.entities.SkeletonBodyGuardEntity;
import fr.janis.pintium.entities.ZombieBodyGuardEntity;
import fr.janis.pintium.init.PintiumEntities;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class TameCreeperPacket {

    public TameCreeperPacket()
    {
    }

    public static void encode(TameCreeperPacket packet, PacketBuffer buffer)
    {
    }

    public static TameCreeperPacket decode(PacketBuffer buffer)
    {
        return new TameCreeperPacket();
    }

    public static void handle(TameCreeperPacket packet, Supplier<NetworkEvent.Context> ctxProvider) {

        CreeperBodyGuardEntity creeper = new CreeperBodyGuardEntity(PintiumEntities.CREEPER_BODY_GUARD.get(), ctxProvider.get().getSender().getServerWorld());

        creeper.setPosition(ctxProvider.get().getSender().getPosX(), ctxProvider.get().getSender().getPosY(), ctxProvider.get().getSender().getPosZ());

        ctxProvider.get().getSender().getServerWorld().addEntity(creeper);

        ctxProvider.get().setPacketHandled(true);
    }
}