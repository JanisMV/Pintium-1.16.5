package fr.janis.pintium.utils;

import fr.janis.pintium.init.PintiumItems;
import fr.janis.pintium.main;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public enum CustomPintiumArmorMaterials implements IArmorMaterial {
    PINTIUM_ARMOR(main.MODID + ":pintium", 42, new int[]{5, 8, 10, 5}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5f, 0.2f, () -> {
        return Ingredient.fromItems(PintiumItems.PINTIUM_INGOT.get());
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float field_234660_o_;
    private final LazyValue<Ingredient> repairMaterial;

    CustomPintiumArmorMaterials(String p_i231593_3_, int p_i231593_4_, int[] p_i231593_5_, int p_i231593_6_, SoundEvent p_i231593_7_, float p_i231593_8_, float p_i231593_9_, Supplier<Ingredient> p_i231593_10_) {
        this.name = p_i231593_3_;
        this.maxDamageFactor = p_i231593_4_;
        this.damageReductionAmountArray = p_i231593_5_;
        this.enchantability = p_i231593_6_;
        this.soundEvent = p_i231593_7_;
        this.toughness = p_i231593_8_;
        this.field_234660_o_ = p_i231593_9_;
        this.repairMaterial = new LazyValue<>(p_i231593_10_);
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.2F;
    }
}
