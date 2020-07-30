package fr.mawathilde.minecraftsuggestions.init;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.block.NetherBushBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public final class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Block.class, MinecraftSuggestions.MOD_ID);

    public static final RegistryObject<NetherBushBlock> NETHER_BERRY_BUSH = BLOCKS.register("nether_berry_bush", () -> new NetherBushBlock(Block.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));

}
