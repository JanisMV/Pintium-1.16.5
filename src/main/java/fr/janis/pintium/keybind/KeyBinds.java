package fr.janis.pintium.keybind;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class KeyBinds {
    public static final KeyBinding SPELLS = new KeyBinding("key.spells", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_K, "key.categories.pintium");

    public static void register()
    {
        ClientRegistry.registerKeyBinding(SPELLS);
    }

}
