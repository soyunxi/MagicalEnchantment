package org.yunxi.MagicalEnchantment.common.Event;

import javafx.scene.control.Tooltip;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.StrongholdPieces;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.yunxi.MagicalEnchantment.MagicalEnchantment;
import org.yunxi.MagicalEnchantment.common.EnchantmentInit;

import java.util.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EnchantmentEvent {

    private static final Map<UUID, Map<Integer, ItemStack>> SoulBindingMap = new HashMap<>();

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event){
        Entity source = event.getSource().getImmediateSource();
        LivingEntity entityliving = event.getEntityLiving();
        if (entityliving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityliving;
            ItemStack heldItem = player.getHeldItemMainhand();
            int CursedBladeLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.CursedBlade.get(), heldItem);

            //诅咒死亡
            if (CursedBladeLevel > 0 ) {
               player.onDeath(new DamageSource("cursesource").setDamageBypassesArmor().setDamageAllowedInCreativeMode());

            }
        }
        //噬魂者
        if (source instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) source;
            Random random = new Random();
            ItemStack heldItem = player.getHeldItemMainhand();
            int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.SoulEater.get(), heldItem);
            if (level >= 1) {
                CompoundNBT nbt = heldItem.getOrCreateChildTag("source");
                event.setAmount(event.getAmount() + nbt.getInt("source"));
            }
            int CursedBladeLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.CursedBlade.get(), heldItem);
            //诅咒加伤害
            if (CursedBladeLevel > 0 ) {
                event.setAmount(event.getAmount() * 5);
            }
            //血祭
            int BloodSacrificeLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.BloodSacrifice.get(), heldItem);
            if (BloodSacrificeLevel > 0) {
                float health = player.getHealth() / player.getMaxHealth();
                if (health > 0.9F) {
                    event.setAmount(event.getAmount() * 5.0F);
                    player.setHealth(player.getHealth() - (player.getMaxHealth() * 0.05F));
                } else if (health <= 0.9F && health > 0.8F) {
                    event.setAmount(event.getAmount() * 4.5F);
                    player.setHealth(player.getHealth() - (player.getMaxHealth() * 0.045F));
                } else if (health <= 0.8F && health > 0.7F) {
                    event.setAmount(event.getAmount() * 4.0F);
                    player.setHealth(player.getHealth() - (player.getMaxHealth() * 0.04F));
                } else if (health <= 0.7F && health > 0.6F) {
                    event.setAmount(event.getAmount() * 3.5F);
                    player.setHealth(player.getHealth() - (player.getMaxHealth() * 0.035F));
                } else if (health <= 0.6F && health > 0.5F) {
                    event.setAmount(event.getAmount() * 3.0F);
                    player.setHealth(player.getHealth() - (player.getMaxHealth() * 0.03F));
                } else if (health <= 0.5F && health > 0.4F) {
                    event.setAmount(event.getAmount() * 2.5F);
                    player.setHealth(player.getHealth() - (player.getMaxHealth() * 0.025F));
                } else if (health <= 0.4F && health > 0.3F) {
                    event.setAmount(event.getAmount() * 2.0F);
                    player.setHealth(player.getHealth() - (player.getMaxHealth() * 0.02F));
                } else if (health <= 0.3F && health > 0.2F) {
                    event.setAmount(event.getAmount() * 1.5F);
                    player.setHealth(player.getHealth() - (player.getMaxHealth() * 0.015F));
                } else {
                    player.setHealth(player.getHealth() - (player.getMaxHealth() * 0.005F));
                }
            }
            //黄泉
            int RoadOfHellLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.RoadOfHell.get(), heldItem);
            if (RoadOfHellLevel > 0 && entityliving.isEntityUndead()){
                event.setAmount(event.getAmount() + 5 * RoadOfHellLevel);
                entityliving.setFire(20 * RoadOfHellLevel);
            }
            //血腥玛丽
            int BloodyMaryLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.BloodyMary.get(), heldItem);
            if (BloodyMaryLevel > 0 && BloodyMaryLevel <= 25) {
                event.setAmount((entityliving.getMaxHealth() - entityliving.getHealth()) * 0.025F * BloodyMaryLevel + event.getAmount());
            } else if (BloodyMaryLevel > 25){
                event.setAmount(0.0F);
                player.sendMessage(new TranslationTextComponent("message." + MagicalEnchantment.MODID + ".bloodymary"), player.getUniqueID());
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event){
        Entity LivingEntity = event.getEntityLiving();
        Entity source = event.getSource().getImmediateSource();
        if (LivingEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) LivingEntity;
            ItemStack Item = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            PlayerInventory inventory = player.inventory;
            Map<Integer, ItemStack> itemStackMap = new HashMap<>();
            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                ItemStack stackInSlot = inventory.getStackInSlot(i);
                if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.SoulBinding.get(), stackInSlot) > 0) {
                    CompoundNBT nbt = stackInSlot.getOrCreateChildTag("soulbinding");
                    if (nbt.getString("soulbindinguuid").equals(player.getUniqueID().toString())) {
                        itemStackMap.put(i, stackInSlot.copy());
                    }
                }
            }
            SoulBindingMap.put(player.getUniqueID(), itemStackMap);
            //不死鸟之羽
            int PhoenixFeatherLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.PhoenixFeather.get(), Item);
            if (PhoenixFeatherLevel > 0) {
                if (Item.getMaxDamage() * 0.25 >= Item.getDamage()) {
                    //设置玩家生命并消耗耐久
                    player.setHealth(5.0f);
                    Item.setDamage((int) (Item.getDamage() * 0.75));
                    //死后给予buff
                    player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 120 * 20, 3));
                    player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 20 * 20, 1));
                    player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 300 * 20, 0));
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 300 * 20, 0));
                    //取消事件
                    event.setCanceled(true);
                }
            }
        }
        if (source instanceof ServerPlayerEntity){
            ServerPlayerEntity player = (ServerPlayerEntity) source;
            Random random = new Random();
            ItemStack heldItem = player.getHeldItemMainhand();
            int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.SoulEater.get(), heldItem);
            //噬魂者
            if (level >= 1) {
                CompoundNBT nbt = heldItem.getOrCreateChildTag("source");
                int r = random.nextInt(100);
                if (r < 4 * level) {
                    if (nbt.getInt("source") <= 3000 * level) {
                        nbt.putInt("source", nbt.getInt("source") + 1);
                        if (!source.getEntityWorld().isRemote()){
                            player.sendMessage(new StringTextComponent(I18n.format("tooltip." + MagicalEnchantment.MODID + ".sword.tooltip", nbt.getInt("source"))), player.getUniqueID());
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.SoulEater.get(), itemStack) > 1 && itemStack.getOrCreateChildTag("source").getInt("source") > 0) {
            event.getToolTip().add(new StringTextComponent(I18n.format("tooltip." + MagicalEnchantment.MODID + ".sworditem.tooltip", itemStack.getOrCreateChildTag("source").getInt("source"))));

        }
        if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.SoulBinding.get(), itemStack) > 0 && !itemStack.getOrCreateChildTag("soulbinding").getString("soulbindinguuid").equals("null")) {
            event.getToolTip().add(new StringTextComponent(I18n.format("tooltip." + MagicalEnchantment.MODID + "soulbinding.tooltip", itemStack.getOrCreateChildTag("soulbinding").getString("soulbindingname"))));
        }
    }

    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        PlayerEntity player = event.getPlayer();
        ItemStack Item = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.Wisdom.get(), Item);
        //智慧
        if (level > 0) {
            Random random = new Random();
            int r = random.nextInt(100);
            if (r < 10) {
                ItemStack crafting = event.getCrafting();
                player.inventory.addItemStackToInventory(crafting);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof ArrowEntity) {
            ArrowEntity arrow = (ArrowEntity) event.getEntity();
            Entity entity = arrow.getShooter();
            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                //黑洞边缘
                if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.BlackHoleEdge.get(), player.getHeldItemMainhand()) > 0) {
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            arrow.setMotion(arrow.getMotion().mul(2, 2, 2));
                        }
                    }, 50, 50);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            arrow.remove();
                        }
                    }, 15000);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        PlayerEntity player = event.getPlayer();
        ItemStack ItemStack = player.getHeldItemMainhand();
        CompoundNBT nbt = ItemStack.getOrCreateChildTag("soulbinding");
        if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.SoulBinding.get(), ItemStack) > 0) {
            if (nbt.getString("soulbindinguuid").equals(player.getUniqueID().toString())) {
                nbt.putString("soulbindinguuid", "null");
                nbt.putString("soulbindingname", "null");
            } else {
                nbt.putString("soulbindinguuid", player.getUniqueID().toString());
                nbt.putString("soulbindingname", player.getName().toString());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        PlayerEntity player = event.getPlayer();
        if (SoulBindingMap.containsKey(player.getUniqueID())) {
            Map<Integer, ItemStack> itemStackMap = SoulBindingMap.get(player.getUniqueID());
            for (Map.Entry<Integer, ItemStack> Entry :itemStackMap.entrySet()) {
                player.inventory.setInventorySlotContents(Entry.getKey(), Entry.getValue());
            }
            SoulBindingMap.remove(player.getUniqueID());
        }
    }
}
