package org.yunxi.MagicalEnchantment.common.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class StarrySkyArmorEnchant extends Enchantment {

    private static final EquipmentSlotType[] ARMOR_SLOTS = new EquipmentSlotType[]{EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};

    public StarrySkyArmorEnchant() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR, ARMOR_SLOTS);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinEnchantability(int p_77321_1_) {
        return 2333;
    }

    @Override
    public int getMaxEnchantability(int p_223551_1_) {
        return 2333;
    }
}
