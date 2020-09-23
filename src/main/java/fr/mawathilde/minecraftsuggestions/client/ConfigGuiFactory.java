package fr.mawathilde.minecraftsuggestions.client;

import fr.mawathilde.minecraftsuggestions.common.config.MSClientConfig;
import me.shedaniel.clothconfig2.forge.api.ConfigBuilder;
import me.shedaniel.clothconfig2.forge.api.ConfigCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.TranslationTextComponent;

public final class ConfigGuiFactory {

    public static Screen createConfigGui(final Minecraft mc, final Screen parentScreen) {
        final ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parentScreen)
                .setTitle(new TranslationTextComponent("config.minecraftsuggestions.title"));
        final ConfigCategory rendersCategory = builder.getOrCreateCategory(new TranslationTextComponent("config.minecraftsuggestions.category.renders"));
        rendersCategory.addEntry(builder.entryBuilder()
                .startBooleanToggle(new TranslationTextComponent("config.minecraftsuggestions.entry.villager_particles"), MSClientConfig.RENDERS.enableVillagerParticles.get())
                .setDefaultValue(true)
                .setSaveConsumer(MSClientConfig.RENDERS.enableVillagerParticles::set)
                .build()
        );
        return builder.build();
    }

}
