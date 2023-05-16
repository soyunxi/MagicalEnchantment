package org.yunxi.MagicalEnchantment;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yunxi.MagicalEnchantment.common.EnchantmentInit;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MagicalEnchantment.MODID)
public class MagicalEnchantment {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "magicalenchantment";

    public MagicalEnchantment() {// Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        EnchantmentInit.ENCHANTMENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
