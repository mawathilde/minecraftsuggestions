package fr.mawathilde.minecraftsuggestions.util;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public final class FoodConstants {

    public static final Food SWEET_BERRIES_PIE = new Food.Builder().hunger(4).saturation(0.8F).build();

    public static final Food GOLDEN_BEETROOT = new Food.Builder().hunger(3).saturation(0.99F).effect(() -> new EffectInstance(Effects.HASTE, 13*20, 0), 1.0F).build();

}
