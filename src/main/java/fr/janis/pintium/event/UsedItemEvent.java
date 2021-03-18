package fr.janis.pintium.event;

import fr.janis.pintium.init.PintiumItems;
import fr.janis.pintium.network.Network;
import fr.janis.pintium.network.packet.CannabisPacket;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class UsedItemEvent {
    @SubscribeEvent
    public void onItemUsedEvent(final LivingEntityUseItemEvent.Finish e){
        if (e.getItem().getItem() == PintiumItems.CANNABIS_FOOD.get()){
            Network.CHANNEL.sendToServer(new CannabisPacket());
        }
    }
}
