package org.yunxi.MagicalEnchantment.common.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class StarrySkyWeaponEnchant extends Enchantment {

    public static final EquipmentSlotType[] MAINHAND = new EquipmentSlotType[]{EquipmentSlotType.MAINHAND};

    public StarrySkyWeaponEnchant() {
        super(Rarity.VERY_RARE, EnchantmentType.WEAPON, MAINHAND);
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
