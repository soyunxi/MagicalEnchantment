package org.yunxi.MagicalEnchantment.common.Enchantment;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import java.util.Set;

public class NaturalEnchantment extends Enchantment {
    public NaturalEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentType.BREAKABLE, new EquipmentSlotType[]{
                EquipmentSlotType.CHEST, EquipmentSlotType.FEET, EquipmentSlotType.HEAD, EquipmentSlotType.LEGS, EquipmentSlotType.MAINHAND, EquipmentSlotType.OFFHAND
        });
    }

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }

    @Override
    public void onUserHurt(LivingEntity p_151367_1_, Entity p_151367_2_, int p_151367_3_) {
        super.onUserHurt(p_151367_1_, p_151367_2_, p_151367_3_);
    }

    @Override
    public int getMinEnchantability(int p_77321_1_) {
        return 28;
    }

    @Override
    protected boolean canApplyTogether(Enchantment p_77326_1_) {
        return super.canApplyTogether(p_77326_1_) && Enchantments.MENDING != p_77326_1_;
    }


}

