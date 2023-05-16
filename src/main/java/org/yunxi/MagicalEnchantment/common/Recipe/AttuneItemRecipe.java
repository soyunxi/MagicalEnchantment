package org.yunxi.MagicalEnchantment.common.Recipe;

import hellfirepvp.astralsorcery.AstralSorcery;
import hellfirepvp.astralsorcery.common.crafting.nojson.attunement.AttunementRecipe;
import hellfirepvp.astralsorcery.common.crafting.nojson.attunement.active.ActiveCrystalAttunementRecipe;
import hellfirepvp.astralsorcery.common.tile.TileAttunementAltar;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nonnull;

public class AttuneItemRecipe extends AttunementRecipe<ActiveCrystalAttunementRecipe> {
    private static final AxisAlignedBB BOX = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

    public AttuneItemRecipe() {
        super(AstralSorcery.key("starrysky"));
    }

    @Override
    public boolean canStartCrafting(TileAttunementAltar tileAttunementAltar) {
        return false;
    }

    @Nonnull
    @Override
    public ActiveCrystalAttunementRecipe createRecipe(TileAttunementAltar tileAttunementAltar) {
        return null;
    }

}
