package fr.janis.pintium.utils;

import fr.janis.pintium.init.PintiumItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;


public enum CustomPintiumTiers implements IItemTier {
    PINTIUM(5, 3000, 14.0F, 5.0F, 22, new LazyValue<>(() -> {
        return Ingredient.fromItems(PintiumItems.PINTIUM_INGOT.get());
    }));

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    CustomPintiumTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, LazyValue<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
}
