package fr.mawathilde.minecraftsuggestions.init;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.enchantment.FrostAspectEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MinecraftSuggestions.MOD_ID)
public final class EnchantmentInit {

    public static void register(IForgeRegistry<Enchantment> registry) {
        registry.register(new FrostAspectEnchantment().setRegistryName("frost_aspect"));
    }

}
