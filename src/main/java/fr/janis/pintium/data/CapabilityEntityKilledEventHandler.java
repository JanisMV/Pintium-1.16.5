package fr.janis.pintium.data;

import fr.janis.pintium.main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityEntityKilledEventHandler {
    @SubscribeEvent
    public static void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> e){
        if (e.getObject() instanceof PlayerEntity){
            EntityKilledProvider provider = new EntityKilledProvider();
            e.addCapability(new ResourceLocation(main.MODID, "name"), provider);
            e.addListener(provider::invalidate);

            main.LOGGER.debug("Ready");
        }
    }
}
