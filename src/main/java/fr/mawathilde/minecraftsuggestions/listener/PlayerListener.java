package fr.mawathilde.minecraftsuggestions.listener;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.common.config.MSClientConfig;
import fr.mawathilde.minecraftsuggestions.common.config.MSServerConfig;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = MinecraftSuggestions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerListener {

    @SubscribeEvent
    public static void onPlayerBoneMeal(BonemealEvent event) {
        if (MSServerConfig.FEATURES.enableBoneMealingDirt.get()) {
            if (event.getBlock().getBlock() == Blocks.DIRT) {
                final Random random = new Random();
                final BlockPos pos = event.getPos();
                event.getWorld().setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
                if (event.getWorld().isRemote && MSClientConfig.RENDERS.enableVillagerParticles.get()) {
                    for (int i = 0; i < 8; i++) {
                        final float x = random.nextFloat() - 0.5f;
                        final float z = random.nextFloat() - 0.5f;
                        event.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5 + x, pos.getY() + 1.2, pos.getZ() + 0.5 + z, 0, 0, 0);
                    }
                }
                event.setResult(Event.Result.DENY);
                event.getStack().shrink(1);
            }
        }
    }

}
