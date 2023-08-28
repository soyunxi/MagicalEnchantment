package org.yunxi.MagicalEnchantment.common.plugins.Astralsorcery.Recipe;

import hellfirepvp.astralsorcery.AstralSorcery;
import hellfirepvp.astralsorcery.common.constellation.world.DayTimeHelper;
import hellfirepvp.astralsorcery.common.crafting.nojson.attunement.AttunementRecipe;
import hellfirepvp.astralsorcery.common.crafting.nojson.attunement.active.ActiveCrystalAttunementRecipe;
import hellfirepvp.astralsorcery.common.tile.TileAttunementAltar;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = "astralsorcery")
public class AttuneItemRecipe extends AttunementRecipe<ActiveCrystalAttunementRecipe> {
    private static final AxisAlignedBB BOX = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

    public AttuneItemRecipe() {
        super(AstralSorcery.key("starryskycrystal"));
    }

    @Override
    public boolean canStartCrafting(TileAttunementAltar tileAttunementAltar) {
        World world = tileAttunementAltar.getWorld();
        if (DayTimeHelper.isNight(world)){

        }
        return false;
    }

    @Nonnull
    @Override
    public ActiveCrystalAttunementRecipe createRecipe(TileAttunementAltar tileAttunementAltar) {
        return null;
    }

}
