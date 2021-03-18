package fr.janis.pintium.event;

import fr.janis.pintium.gui.SpellsGui;
import fr.janis.pintium.keybind.KeyBinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyBindEvent {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e){
        if (KeyBinds.SPELLS.isPressed()){
            Minecraft.getInstance().displayGuiScreen(new SpellsGui());
        }
    }
}
