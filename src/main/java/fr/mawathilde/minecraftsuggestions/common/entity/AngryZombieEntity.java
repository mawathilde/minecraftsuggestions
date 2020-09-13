package fr.mawathilde.minecraftsuggestions.common.entity;

import fr.mawathilde.minecraftsuggestions.init.EntityInit;
import fr.mawathilde.minecraftsuggestions.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class AngryZombieEntity extends ZombieEntity {

    public AngryZombieEntity(ZombieEntity zombieEntity) {
        this(zombieEntity.world);
        setLocationAndAngles(zombieEntity.getPosX(), zombieEntity.getPosY(), zombieEntity.getPosZ(), zombieEntity.getYaw(1.0F), zombieEntity.getPitch(1.0F));
        setChild(zombieEntity.isChild());
    }

    public AngryZombieEntity(EntityType<? extends AngryZombieEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public AngryZombieEntity(World worldIn) {
        this(EntityInit.ANGRY_ZOMBIE, worldIn);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(ItemInit.ANGRY_ZOMBIE_SPAWN_EGG);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3F)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                .createMutableAttribute(Attributes.ARMOR, 2.0D)
                .createMutableAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }

}
