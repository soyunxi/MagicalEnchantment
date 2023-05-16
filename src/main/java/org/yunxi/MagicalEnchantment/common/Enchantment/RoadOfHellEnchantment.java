package org.yunxi.MagicalEnchantment.common.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import org.yunxi.MagicalEnchantment.common.EnchantmentInit;

public class RoadOfHellEnchantment extends Enchantment {
    public static final EquipmentSlotType[] MAINHAND = new EquipmentSlotType[]{EquipmentSlotType.MAINHAND};

    public RoadOfHellEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentType.WEAPON, MAINHAND);
    }

    @Override
    public int getMinEnchantability(int p_77321_1_) {
        return 1 + 10 * (p_77321_1_ - 1);
    }

    @Override
    public int getMaxEnchantability(int p_223551_1_) {
        return super.getMaxEnchantability(p_223551_1_) + 50 ;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    protected boolean canApplyTogether(Enchantment p_77326_1_) {
        return super.canApplyTogether(p_77326_1_) && Enchantments.BANE_OF_ARTHROPODS != p_77326_1_ && Enchantments.SMITE != p_77326_1_ && Enchantments.SHARPNESS != p_77326_1_ && EnchantmentInit.BloodyMary.get() != p_77326_1_;
    }
}
