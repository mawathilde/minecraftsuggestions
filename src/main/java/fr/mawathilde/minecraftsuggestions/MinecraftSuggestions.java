package fr.mawathilde.minecraftsuggestions;

import fr.mawathilde.minecraftsuggestions.init.BlockInit;
import fr.mawathilde.minecraftsuggestions.init.EnchantmentInit;
import fr.mawathilde.minecraftsuggestions.init.ItemInit;
import fr.mawathilde.minecraftsuggestions.listener.PlayerListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MinecraftSuggestions.MOD_ID)
public class MinecraftSuggestions {

    public static final String MOD_ID = "minecraftsuggestions";

    private static final Logger LOGGER = LogManager.getLogger();

    public MinecraftSuggestions() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockInit.BLOCKS.register(eventBus);
        ItemInit.ITEMS.register(eventBus);
        EnchantmentInit.ENCHANTMENTS.register(eventBus);
        MinecraftForge.EVENT_BUS.register(new PlayerListener());
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

}
