package org.yunxi.MagicalEnchantment.common.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import org.yunxi.MagicalEnchantment.common.EnchantmentInit;

public class BloodSacrificeEnchantment extends Enchantment {
    public static final EquipmentSlotType[] MAINHAND = new EquipmentSlotType[]{EquipmentSlotType.MAINHAND};

    public BloodSacrificeEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentType.WEAPON, MAINHAND);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel * 50);
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMaxEnchantability(enchantmentLevel * 50);
    }

    @Override
    protected boolean canApplyTogether(Enchantment p_77326_1_) {
        return super.canApplyTogether(p_77326_1_) && Enchantments.SHARPNESS != p_77326_1_ && Enchantments.SMITE != p_77326_1_ && Enchantments.BANE_OF_ARTHROPODS !=p_77326_1_ && EnchantmentInit.SoulEater.get() != p_77326_1_;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
}
