package fr.janis.pintium.network.packet;

import fr.janis.pintium.entities.RatelBodyGuardEntity;
import fr.janis.pintium.init.PintiumEntities;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class TameRatelPacket {

    public TameRatelPacket()
    {
    }

    public static void encode(TameRatelPacket packet, PacketBuffer buffer)
    {
    }

    public static TameRatelPacket decode(PacketBuffer buffer)
    {
        return new TameRatelPacket();
    }

    public static void handle(TameRatelPacket packet, Supplier<NetworkEvent.Context> ctxProvider) {

        RatelBodyGuardEntity ratel = new RatelBodyGuardEntity(PintiumEntities.RATEL_BODY_GUARD.get(), ctxProvider.get().getSender().getServerWorld());

        ratel.setPosition(ctxProvider.get().getSender().getPosX(), ctxProvider.get().getSender().getPosY(), ctxProvider.get().getSender().getPosZ());

        ctxProvider.get().getSender().getServerWorld().addEntity(ratel);

        ctxProvider.get().setPacketHandled(true);
    }
}