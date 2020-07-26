package fr.mawathilde.minecraftsuggestions.init;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.enchantment.FrostAspectEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public final class EnchantmentInit {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(Enchantment.class, MinecraftSuggestions.MOD_ID);

    public static final RegistryObject<FrostAspectEnchantment> FROST_ASPECT = ENCHANTMENTS.register("frost_aspect", FrostAspectEnchantment::new);

}
