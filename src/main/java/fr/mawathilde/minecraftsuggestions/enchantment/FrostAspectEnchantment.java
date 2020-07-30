package fr.mawathilde.minecraftsuggestions.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FrostAspectEnchantment extends Enchantment {

    public FrostAspectEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            final LivingEntity livingEntity = (LivingEntity) target;
            livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20 * 3, level - 1, false, true, true));
        }
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 10 + 20 * (enchantmentLevel - 1);
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

}
