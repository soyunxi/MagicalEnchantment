package org.yunxi.MagicalEnchantment.common.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class SoulBindingEnchantment extends Enchantment {
    public static final EquipmentSlotType[] slots = new EquipmentSlotType[]{EquipmentSlotType.MAINHAND, EquipmentSlotType.CHEST, EquipmentSlotType.FEET, EquipmentSlotType.HEAD, EquipmentSlotType.OFFHAND, EquipmentSlotType.LEGS};
    public SoulBindingEnchantment() {
        super(Rarity.COMMON, EnchantmentType.VANISHABLE, slots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 10;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return 2333;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return true;
    }


}
