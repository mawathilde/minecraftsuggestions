package fr.mawathilde.minecraftsuggestions;

import fr.mawathilde.minecraftsuggestions.common.entity.AngryZombieEntity;
import fr.mawathilde.minecraftsuggestions.init.EntityInit;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
        eventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(EntityInit.ANGRY_ZOMBIE, AngryZombieEntity.setCustomAttributes().create());
    }

}
