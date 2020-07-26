package fr.mawathilde.minecraftsuggestions;

import fr.mawathilde.minecraftsuggestions.init.EnchantmentInit;
import fr.mawathilde.minecraftsuggestions.listener.PlayerListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MinecraftSuggestions.MOD_ID)
public class MinecraftSuggestions {

    public static final String MOD_ID = "minecraftsuggestions";

    private static final Logger LOGGER = LogManager.getLogger();

    public MinecraftSuggestions() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EnchantmentInit.ENCHANTMENTS.register(eventBus);
        MinecraftForge.EVENT_BUS.register(new PlayerListener());
    }

}
