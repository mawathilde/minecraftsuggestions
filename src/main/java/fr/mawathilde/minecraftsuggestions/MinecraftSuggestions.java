package fr.mawathilde.minecraftsuggestions;

import fr.mawathilde.minecraftsuggestions.listener.PlayerListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MinecraftSuggestions.MOD_ID)
public class MinecraftSuggestions {

    public static final String MOD_ID = "minecraftsuggestions";

    private static final Logger LOGGER = LogManager.getLogger();

    public MinecraftSuggestions() {
        MinecraftForge.EVENT_BUS.register(new PlayerListener());
    }

}
