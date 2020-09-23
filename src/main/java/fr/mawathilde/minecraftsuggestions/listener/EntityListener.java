package fr.mawathilde.minecraftsuggestions.listener;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.common.config.MSServerConfig;
import fr.mawathilde.minecraftsuggestions.common.entity.AngryZombieEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = MinecraftSuggestions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityListener {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onEntitySpawning(LivingSpawnEvent.SpecialSpawn event) {
        if (MSServerConfig.FEATURES.enableAngryZombieSpawn.get()) {
            if (event.getEntityLiving().getClass() == ZombieEntity.class && event.getSpawnReason() != SpawnReason.SPAWN_EGG) {
                boolean spawn = false;
                switch (event.getWorld().getDifficulty()) {
                    case PEACEFUL:
                        break;
                    case EASY:
                        spawn = RANDOM.nextFloat() >= 0.88F;
                        break;
                    case NORMAL:
                        spawn = RANDOM.nextFloat() >= 0.51F;
                        break;
                    case HARD:
                        spawn = RANDOM.nextFloat() >= 0.33F;
                        break;
                    default:
                        spawn = false;
                }
                if (spawn) {
                    final ZombieEntity zombieEntity = (ZombieEntity) event.getEntityLiving();
                    zombieEntity.remove();
                    event.setCanceled(true);
                    event.setResult(Event.Result.DENY);
                    event.getWorld().addEntity(new AngryZombieEntity(zombieEntity));
                }
            }
        }
    }

}
