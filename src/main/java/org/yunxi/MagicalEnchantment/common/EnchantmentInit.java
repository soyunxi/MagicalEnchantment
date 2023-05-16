package org.yunxi.MagicalEnchantment.common;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.yunxi.MagicalEnchantment.MagicalEnchantment;
import org.yunxi.MagicalEnchantment.common.Enchantment.*;

public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MagicalEnchantment.MODID);

    public static final RegistryObject<Enchantment> BloodSacrifice =
            ENCHANTMENTS.register("bloodsacrifice", BloodSacrificeEnchantment::new);

    public static final RegistryObject<Enchantment> BloodyMary =
            ENCHANTMENTS.register("bloodymary", BloodyMaryEnchantment::new);

    public static final RegistryObject<Enchantment> SoulEater =
            ENCHANTMENTS.register("souleater", SoulEaterEnchantment::new);

    public static final RegistryObject<Enchantment> CursedBlade =
            ENCHANTMENTS.register("cursedblade", CursedBladeEnchantment::new);

    public static final RegistryObject<Enchantment> RoadOfHell =
            ENCHANTMENTS.register("roadofhell", RoadOfHellEnchantment::new);

    public static final RegistryObject<Enchantment> PhoenixFeather =
            ENCHANTMENTS.register("phoenixfeather", PhoenixFeatherEnchantment::new);

    public static final RegistryObject<Enchantment> Wisdom =
            ENCHANTMENTS.register("wisdom", WisdomEnchantment::new);

    public static final RegistryObject<Enchantment> BlackHoleEdge =
            ENCHANTMENTS.register("blackholeedge", BlackHoleEdgeEnchantment::new);

    public static final RegistryObject<Enchantment> SoulBinding =
            ENCHANTMENTS.register("soulbinding", SoulBindingEnchantment::new);
}
