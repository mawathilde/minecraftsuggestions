package fr.mawathilde.minecraftsuggestions;

import fr.mawathilde.minecraftsuggestions.client.ConfigGuiFactory;
import fr.mawathilde.minecraftsuggestions.common.config.MSClientConfig;
import fr.mawathilde.minecraftsuggestions.common.config.MSServerConfig;
import fr.mawathilde.minecraftsuggestions.common.entity.AngryZombieEntity;
import fr.mawathilde.minecraftsuggestions.init.EntityInit;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MinecraftSuggestions.MOD_ID)
public class MinecraftSuggestions {

    public static final String MOD_ID = "minecraftsuggestions";

    public MinecraftSuggestions() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MSServerConfig.CONFIG_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MSClientConfig.CONFIG_SPEC);
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () -> ConfigGuiFactory::createConfigGui);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(EntityInit.ANGRY_ZOMBIE, AngryZombieEntity.setCustomAttributes().create());
    }

}
