package fr.janis.pintium.utils;

import fr.janis.pintium.init.PintiumItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class PintiumItemGroup {
    public static final ItemGroup PINTIUM_TAB = new ItemGroup("pintium_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(PintiumItems.PINTIUM_INGOT.get());
        }
    };
}
