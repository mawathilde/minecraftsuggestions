package fr.mawathilde.minecraftsuggestions.util;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public final class FoodConstants {

    public static final Food NETHER_BERRIES = new Food.Builder().hunger(2).saturation(0.08F).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 8 * 20, 0), 1.0F).build();

}
