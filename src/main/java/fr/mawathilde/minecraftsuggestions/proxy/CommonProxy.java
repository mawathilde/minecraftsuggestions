package fr.mawathilde.minecraftsuggestions.proxy;

import fr.mawathilde.minecraftsuggestions.init.BlockInit;
import fr.mawathilde.minecraftsuggestions.init.EnchantmentInit;
import fr.mawathilde.minecraftsuggestions.init.ItemInit;
import fr.mawathilde.minecraftsuggestions.listener.PlayerListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {

    public void initModClass() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.BLOCKS.register(eventBus);
        ItemInit.ITEMS.register(eventBus);
        EnchantmentInit.ENCHANTMENTS.register(eventBus);
        MinecraftForge.EVENT_BUS.register(new PlayerListener());
    }

}
