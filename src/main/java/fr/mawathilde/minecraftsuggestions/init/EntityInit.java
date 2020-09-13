package fr.mawathilde.minecraftsuggestions.init;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.common.entity.AngryZombieEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MinecraftSuggestions.MOD_ID)
public final class EntityInit {

    @ObjectHolder("angry_zombie")
    public static EntityType<AngryZombieEntity> ANGRY_ZOMBIE;

    public static void register(IForgeRegistry<EntityType<?>> registry) {
        register(registry, "angry_zombie", EntityType.Builder.<AngryZombieEntity>create(AngryZombieEntity::new, EntityClassification.MONSTER).size(0.6F, 1.95F).func_233606_a_(8));
    }

    private static void register(IForgeRegistry<EntityType<?>> registry, String key, EntityType.Builder<?> builder) {
        registry.register(builder.build(key).setRegistryName(key));
    }

}
