package org.yunxi.MagicalEnchantment.mixin;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TieredItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.mixin.Mixin;
import org.yunxi.MagicalEnchantment.MagicalEnchantment;
import org.yunxi.MagicalEnchantment.common.EnchantmentInit;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(SwordItem.class)
public abstract class SwordItemMixin extends TieredItem {
    private final IItemTier tier = ((SwordItem) (Object) this).getTier();

    private final float damage = tier.getAttackDamage();

    public SwordItemMixin(IItemTier p_i48459_1_, Properties p_i48459_2_) {
        super(p_i48459_1_, p_i48459_2_);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.SoulEater.get(), stack);
        //噬魂者
        if (level >= 1) {
            CompoundNBT nbt = stack.getOrCreateChildTag("source");
            if (nbt.getInt("source") > 0 ) {
                tooltip.add(new StringTextComponent(I18n.format("tooltip." + MagicalEnchantment.MODID + ".sworditem.tooltip", nbt.getInt("source"))));
            }
        }
    }
}
