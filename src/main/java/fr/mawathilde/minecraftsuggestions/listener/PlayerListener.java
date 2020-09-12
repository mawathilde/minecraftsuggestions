package fr.mawathilde.minecraftsuggestions.listener;

import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerListener {

    @SubscribeEvent
    public void onPlayerBoneMeal(BonemealEvent event) {
        if (event.getBlock().getBlock() == Blocks.DIRT) {
            final Random random = new Random();
            final BlockPos pos = event.getPos();
            event.getWorld().getBiome(pos);
            event.getWorld().setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
            for (int i = 0; i < 8; i++) {
                final float x = random.nextFloat() - 0.5f;
                final float z = random.nextFloat() - 0.5f;
                event.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5 + x, pos.getY() + 1.2, pos.getZ() + 0.5 + z, 0, 0, 0);
            }
            event.setResult(Event.Result.ALLOW);
        }
    }

}
