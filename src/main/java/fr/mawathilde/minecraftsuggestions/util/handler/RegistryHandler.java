package fr.mawathilde.minecraftsuggestions.util.handler;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.init.BlockInit;
import fr.mawathilde.minecraftsuggestions.init.EnchantmentInit;
import fr.mawathilde.minecraftsuggestions.init.EntityInit;
import fr.mawathilde.minecraftsuggestions.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MinecraftSuggestions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class RegistryHandler {

    @SubscribeEvent
    public static void onItemsRegister(RegistryEvent.Register<Item> event) {
        ItemInit.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onBlocksRegister(RegistryEvent.Register<Block> event) {
        BlockInit.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onEnchantmentsRegister(RegistryEvent.Register<Enchantment> event) {
        EnchantmentInit.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onEntityTypesRegister(RegistryEvent.Register<EntityType<?>> event) {
        EntityInit.register(event.getRegistry());
    }

}
