package org.yunxi.MagicalEnchantment.common.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class PhoenixFeatherEnchantment extends Enchantment {
    private static final EquipmentSlotType[] ARMOR_SLOTS = new EquipmentSlotType[]{EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};

    public PhoenixFeatherEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, ARMOR_SLOTS);
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

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.getItem() instanceof ArmorItem && ((ArmorItem)stack.getItem()).getEquipmentSlot() == EquipmentSlotType.CHEST;
    }

    @Override
    protected boolean canApplyTogether(Enchantment p_77326_1_) {
        return super.canApplyTogether(p_77326_1_);
    }
}
