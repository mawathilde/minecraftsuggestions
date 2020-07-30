package fr.mawathilde.minecraftsuggestions;

import com.google.common.collect.ImmutableSet;
import fr.mawathilde.minecraftsuggestions.init.BlockInit;
import fr.mawathilde.minecraftsuggestions.proxy.ClientProxy;
import fr.mawathilde.minecraftsuggestions.proxy.CommonProxy;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MinecraftSuggestions.MOD_ID)
public class MinecraftSuggestions {

    public static final String MOD_ID = "minecraftsuggestions";
    public static final CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    private static final Logger LOGGER = LogManager.getLogger();

    public MinecraftSuggestions() {
        proxy.initModClass();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        final BlockClusterFeatureConfig netherBerryBushConfig = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.NETHER_BERRY_BUSH.get().getDefaultState()), SimpleBlockPlacer.field_236447_c_)).tries(64).whitelist(ImmutableSet.of(Blocks.NETHERRACK, Blocks.field_235372_ml_, Blocks.field_235381_mu_)).func_227317_b_().build();
        Biomes.field_235253_az_.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(netherBerryBushConfig).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        final RenderType cutout = RenderType.getCutout();
        RenderTypeLookup.setRenderLayer(BlockInit.NETHER_BERRY_BUSH.get(), cutout);
    }

}
