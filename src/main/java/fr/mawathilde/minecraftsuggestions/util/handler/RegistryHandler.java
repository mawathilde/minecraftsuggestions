package fr.mawathilde.minecraftsuggestions.util.handler;

import fr.mawathilde.minecraftsuggestions.init.BlockInit;
import fr.mawathilde.minecraftsuggestions.init.EnchantmentInit;
import fr.mawathilde.minecraftsuggestions.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class RegistryHandler {

    @SubscribeEvent
    public void onItemsRegister(RegistryEvent.Register<Item> event) {
        ItemInit.register(event.getRegistry());
    }

    @SubscribeEvent
    public void onBlocksRegister(RegistryEvent.Register<Block> event) {
        BlockInit.register(event.getRegistry());
    }

    @SubscribeEvent
    public void onEnchantmentsRegister(RegistryEvent.Register<Enchantment> event) {
        EnchantmentInit.register(event.getRegistry());
    }

}
