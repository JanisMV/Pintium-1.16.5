package fr.janis.pintium.network;

import fr.janis.pintium.main;
import fr.janis.pintium.network.packet.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Network {
    public static final String PROTOCOL_VERSION = String.valueOf(1);
    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(main.MODID, "pintium_channel"))
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .simpleChannel();

    public static void registerNetworkPackets()
    {
        CHANNEL.messageBuilder(SpawnABoatPacket.class, 0)
                .encoder(SpawnABoatPacket::encode)
                .decoder(SpawnABoatPacket::decode)
                .consumer(SpawnABoatPacket::handle)
                .add();
        CHANNEL.messageBuilder(SpawnSomeZombiesPacket.class, 1)
                .encoder(SpawnSomeZombiesPacket::encode)
                .decoder(SpawnSomeZombiesPacket::decode)
                .consumer(SpawnSomeZombiesPacket::handle)
                .add();
        CHANNEL.messageBuilder(TransformToABlockPacket.class, 2)
                .encoder(TransformToABlockPacket::encode)
                .decoder(TransformToABlockPacket::decode)
                .consumer(TransformToABlockPacket::handle)
                .add();
        CHANNEL.messageBuilder(LaunchFireBall.class, 3)
                .encoder(LaunchFireBall::encode)
                .decoder(LaunchFireBall::decode)
                .consumer(LaunchFireBall::handle)
                .add();
        CHANNEL.messageBuilder(CannabisPacket.class, 4)
                .encoder(CannabisPacket::encode)
                .decoder(CannabisPacket::decode)
                .consumer(CannabisPacket::handle)
                .add();
        CHANNEL.messageBuilder(TameRatelPacket.class, 5)
                .encoder(TameRatelPacket::encode)
                .decoder(TameRatelPacket::decode)
                .consumer(TameRatelPacket::handle)
                .add();
    }
}
