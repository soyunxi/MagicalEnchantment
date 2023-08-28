package org.yunxi.MagicalEnchantment.common.plugins.Botania;


import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.yunxi.MagicalEnchantment.common.Event.RegisterEvent;
import top.theillusivec4.curios.Curios;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.common.CuriosHelper;
import top.theillusivec4.curios.server.command.CurioArgumentType;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.BotaniaAPIClient;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.api.mana.ManaNetworkEvent;
import vazkii.botania.api.mana.ManaProficiencyEvent;

import java.util.ArrayList;
import java.util.List;

//TODO
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = "botanis")
public class BotaniaEnchantmentEvent {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        PlayerEntity player = event.player;
        List<ItemStack> hasnatural = new ArrayList<>();
        for (int i = 1; i < player.inventory.getSizeInventory(); i++){
            ItemStack stackInSlot = player.inventory.getStackInSlot(i);
            if (EnchantmentHelper.getEnchantmentLevel(RegisterEvent.Natural, stackInSlot) > 0) {
                hasnatural.add(stackInSlot);
            }
        }
        if (!hasnatural.isEmpty()) {
            for (ItemStack itemStack : hasnatural) {
                ManaItemHandler.instance().requestManaExactForTool(itemStack, player, 100, true);
            }
        }
    }
}
