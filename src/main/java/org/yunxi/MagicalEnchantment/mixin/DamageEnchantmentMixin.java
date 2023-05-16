package org.yunxi.MagicalEnchantment.mixin;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.entity.CreatureAttribute;
import org.spongepowered.asm.mixin.*;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin {
    @Final
    @Shadow
    int damageType;
    /**
     * @author
     * @reason
     */
    @Overwrite
    public float calcDamageByCreature(int level, CreatureAttribute creatureType) {
        if (this.damageType == 0) {
            return level * 1.25F;
        } else if (this.damageType == 1 && creatureType == CreatureAttribute.UNDEAD) {
            return (float)level * 2.5F;
        } else {
            return this.damageType == 2 && creatureType == CreatureAttribute.ARTHROPOD ? (float)level * 2.5F : 0.0F;
        }
    }
}
