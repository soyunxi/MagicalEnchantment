package org.yunxi.MagicalEnchantment.mixin;


import net.minecraft.enchantment.InfinityEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentMixin {
    /**
     * @author
     * @reason
     */
    @Overwrite
    public int getMinEnchantability(int enchantmentLevel) {
        return 20 * enchantmentLevel;
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    public int getMaxLevel() {
        return 3;
    }
}
