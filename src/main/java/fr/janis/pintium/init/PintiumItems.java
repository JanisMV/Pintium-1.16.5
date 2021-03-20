package fr.janis.pintium.init;

import fr.janis.pintium.entities.TunaEntity;
import fr.janis.pintium.items.*;
import fr.janis.pintium.main;
import fr.janis.pintium.utils.CustomPintiumArmorMaterials;
import fr.janis.pintium.utils.CustomPintiumTiers;
import fr.janis.pintium.utils.PintiumItemGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class PintiumItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, main.MODID);

    public static final RegistryObject<Item> PINTIUM_INGOT = ITEMS.register("pintium_ingot", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));

    public static final RegistryObject<PintiumSpawnEggItem> RATEL_SPAWN_EGG = ITEMS.register("ratel_spawn_egg", () -> new PintiumSpawnEggItem(PintiumEntities.RATEL, 0x000000, 0xFFFFFF, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<PintiumSpawnEggItem> BANANOSAUR_SPAWN_EGG = ITEMS.register("bananosaur_spawn_egg", () -> new PintiumSpawnEggItem(PintiumEntities.BANANOSAUR, 0xFFE300, 0xFFFFFF, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<PintiumSpawnEggItem> TUNA_SPAWN_EGG = ITEMS.register("tuna_spawn_egg", () -> new PintiumSpawnEggItem(PintiumEntities.TUNA, 0xFFAD00, 0x47FF00, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<PintiumSpawnEggItem> BANANOFISH_SPAWN_EGG = ITEMS.register("bananofish_spawn_egg", () -> new PintiumSpawnEggItem(PintiumEntities.BANANOFISH, 0xE1FF00, 0xEEF0DC, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));

    public static final RegistryObject<Item> PINTIUM_SWORD = ITEMS.register("pintium_sword", () -> new SwordItem(CustomPintiumTiers.PINTIUM, 6, -2.0f, new Item.Properties().maxStackSize(1).group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<Item> PINTIUM_PICKAXE = ITEMS.register("pintium_pickaxe", () -> new PickaxeItem(CustomPintiumTiers.PINTIUM, 2, -2.4f, new Item.Properties().maxStackSize(1).group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<Item> PINTIUM_AXE = ITEMS.register("pintium_axe", () -> new AxeItem(CustomPintiumTiers.PINTIUM, 8, -2.6f, new Item.Properties().maxStackSize(1).group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<Item> PINTIUM_SHOVEL = ITEMS.register("pintium_shovel", () -> new ShovelItem(CustomPintiumTiers.PINTIUM, 3, -2.6f, new Item.Properties().maxStackSize(1).group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<Item> PINTIUM_HOE = ITEMS.register("pintium_hoe", () -> new HoeItem(CustomPintiumTiers.PINTIUM, -5, 0.0f, new Item.Properties().maxStackSize(1).group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<Item> PINTIUM_HAMMER = ITEMS.register("pintium_hammer", () -> new PintiumHammer(new Item.Properties().maxStackSize(1).group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    
    public static final RegistryObject<Item> PINTIUM_HELMET = ITEMS.register("pintium_helmet", () -> new ArmorItem(CustomPintiumArmorMaterials.PINTIUM_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).maxStackSize(1).isImmuneToFire()));
    public static final RegistryObject<Item> PINTIUM_CHESTPLATE = ITEMS.register("pintium_chestplate", () -> new ArmorItem(CustomPintiumArmorMaterials.PINTIUM_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).maxStackSize(1).isImmuneToFire()));
    public static final RegistryObject<Item> PINTIUM_LEGGINGS = ITEMS.register("pintium_leggings", () -> new ArmorItem(CustomPintiumArmorMaterials.PINTIUM_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).maxStackSize(1).isImmuneToFire()));
    public static final RegistryObject<Item> PINTIUM_BOOTS = ITEMS.register("pintium_boots", () -> new ArmorItem(CustomPintiumArmorMaterials.PINTIUM_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).maxStackSize(1).isImmuneToFire()));

    public static final RegistryObject<Item> PINTIUM_SEEDS =
            ITEMS.register("pintium_seeds", () -> new BlockItem(PintiumBlocks.PINTIUM_CROP.get(), new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));

    public static final RegistryObject<Item> CANNABIS_FOOD =
            ITEMS.register("cannabis_food", () -> new BlockItem(PintiumBlocks.CANNABIS_CROP.get(), new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).food(
                    new Food.Builder()
                    .hunger(3)
                    .saturation(1.4F)
                    .effect(() -> new EffectInstance(Effects.NAUSEA, 20*30, 0), 1.0F)
                    .build()
            )));

    public static final RegistryObject<Item> PINTIUM_NUGGET = ITEMS.register("pintium_nugget", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));

    public static final RegistryObject<Item> PINTIUM_STICK = ITEMS.register("pintium_stick", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));

    public static final RegistryObject<StickOfGod> STICK_OF_GOD = ITEMS.register("stick_of_god",  () -> new StickOfGod(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire().maxStackSize(1).maxDamage(80).defaultMaxDamage(80)));
    public static final RegistryObject<JumpStick> JUMP_STICK = ITEMS.register("jump_stick",  () -> new JumpStick(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire().maxStackSize(1).maxDamage(80).defaultMaxDamage(80)));
    public static final RegistryObject<SpeedStick> SPEED_STICK = ITEMS.register("speed_stick",  () -> new SpeedStick(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire().maxStackSize(1).maxDamage(80).defaultMaxDamage(80)));
    public static final RegistryObject<StrengthStick> STRENGTH_STICK = ITEMS.register("strength_stick",  () -> new StrengthStick(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire().maxStackSize(1).maxDamage(80).defaultMaxDamage(80)));
    public static final RegistryObject<SuperJumpStick> SUPER_JUMP_STICK = ITEMS.register("super_jump_stick",  () -> new SuperJumpStick(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire().maxStackSize(1).maxDamage(80).defaultMaxDamage(80)));
    public static final RegistryObject<HealStick> HEAL_STICK = ITEMS.register("heal_stick",  () -> new HealStick(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire().maxStackSize(1).maxDamage(80).defaultMaxDamage(80)));

    public static final RegistryObject<Item> COMPRESSED_PINTIUM = ITEMS.register("compressed_pintium", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<Item> HEAL_ORB = ITEMS.register("heal_orb", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<Item> JUMP_ORB = ITEMS.register("jump_orb", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<Item> SPEED_ORB = ITEMS.register("speed_orb", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));
    public static final RegistryObject<Item> STRENGTH_ORB = ITEMS.register("strength_orb", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire()));

    public static final RegistryObject<Item> PINTIUM_APPLE = ITEMS.register("pintium_apple", () -> new Item(new Item.Properties()
            .group(PintiumItemGroup.PINTIUM_TAB)
            .isImmuneToFire()
            .food(new Food.Builder()
                    .hunger(6)
                    .saturation(1.5F)
                    .effect(() -> new EffectInstance(Effects.REGENERATION, 20*30, 0), 1.0F)
                    .effect(() -> new EffectInstance(Effects.ABSORPTION, 20*600, 4), 1.0F)
                    .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 20*600, 1), 1.0F)
                    .effect(() -> new EffectInstance(Effects.RESISTANCE, 20*600, 0), 1.0F)
                    .effect(() -> new EffectInstance(Effects.STRENGTH, 20*600, 1), 1.0F)
                    .setAlwaysEdible()
                    .build())));

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire().food(
            new Food.Builder()
            .hunger(8)
            .saturation(2.0F)
            .setAlwaysEdible()
            .build()
    )));

    public static final RegistryObject<Item> POLONIUM = ITEMS.register("polonium", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire().food(
            new Food.Builder()
            .hunger(1)
            .saturation(0.0F)
            .effect(() -> new EffectInstance(Effects.STRENGTH, 20*180, 500), 1.0F)
            .effect(() -> new EffectInstance(Effects.NAUSEA, 20*30, 0), 1.0F)
            .effect(() -> new EffectInstance(Effects.RESISTANCE, 20*180, 500), 1.0F)
            .setAlwaysEdible().build()
    )));

    public static final RegistryObject<Item> DELICIOUS_TUNA = ITEMS.register("delicious_tuna", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).food(
            new Food.Builder()
            .hunger(1)
            .saturation(0.5F)
            .setAlwaysEdible()
            .build()
    )));

    public static final RegistryObject<Item> COOKED_TUNA = ITEMS.register("cooked_tuna", () -> new Item(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).food(
            new Food.Builder()
            .hunger(8)
            .saturation(1.5F)
            .setAlwaysEdible()
            .build()
    )));

    public static final RegistryObject<Item> TUNA_BUCKET = ITEMS.register("tuna_bucket", () -> new FishBucketItem(PintiumEntities.TUNA, () -> Fluids.WATER, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).maxStackSize(1)));
    public static final RegistryObject<Item> BANANOFISH_BUCKET = ITEMS.register("bananofish_bucket", () -> new FishBucketItem(PintiumEntities.BANANOFISH, () -> Fluids.WATER, new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).maxStackSize(1)));

    public static final RegistryObject<Item> LIFE_STICK = ITEMS.register("life_stick", () -> new LifeStick(new Item.Properties().group(PintiumItemGroup.PINTIUM_TAB).isImmuneToFire().maxStackSize(1).maxDamage(80).defaultMaxDamage(80)));

    //public static final RegistryObject<Item> PINTIUM_JUICE = ITEMS.register("pintium_juice", () -> new Item(new Item.Properties()
    //        .group(PintiumItemGroup.PINTIUM_TAB)
    //        .food(new Food.Builder()
    //                .hunger(6)
    //                .saturation(1.5F)
    //                .setAlwaysEdible()
    //                .build())){
    //    @Override
    //    public UseAction getUseAction(ItemStack stack) {
    //        return UseAction.DRINK;
    //    }
    //});

}