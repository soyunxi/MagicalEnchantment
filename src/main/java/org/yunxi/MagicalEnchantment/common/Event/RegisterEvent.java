package org.yunxi.MagicalEnchantment.common.Event;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.yunxi.MagicalEnchantment.common.Enchantment.StarrySkyArmorEnchant;
import org.yunxi.MagicalEnchantment.common.Enchantment.StarrySkyToolEnchant;
import org.yunxi.MagicalEnchantment.common.Enchantment.StarrySkyWeaponEnchant;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterEvent {

    public static final Enchantment StarrySkyArmor = new StarrySkyArmorEnchant();
    public static final Enchantment StarrySkyWeapon = new StarrySkyWeaponEnchant();
    public static final Enchantment StarrySkyTool = new StarrySkyToolEnchant();

    @SubscribeEvent
    public static void onRegistryEnchantment(RegistryEvent.Register<Enchantment> event) {
        if (ModList.get().isLoaded("astralsorcery")) {
            StarrySkyArmor.setRegistryName("starryskyarmor");
            StarrySkyWeapon.setRegistryName("starryskyweapon");
            StarrySkyTool.setRegistryName("starryskytool");
            event.getRegistry().register(StarrySkyArmor);
            event.getRegistry().register(StarrySkyWeapon);
            event.getRegistry().register(StarrySkyTool);
        }
    }
}