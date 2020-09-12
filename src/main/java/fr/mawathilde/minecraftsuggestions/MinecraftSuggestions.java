package fr.mawathilde.minecraftsuggestions;

import fr.mawathilde.minecraftsuggestions.proxy.ClientProxy;
import fr.mawathilde.minecraftsuggestions.proxy.CommonProxy;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MinecraftSuggestions.MOD_ID)
public class MinecraftSuggestions {

    public static final String MOD_ID = "minecraftsuggestions";
    public static final CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    private static final Logger LOGGER = LogManager.getLogger();

    public MinecraftSuggestions() {
        proxy.initModClass();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

}
