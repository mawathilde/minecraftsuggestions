package fr.mawathilde.minecraftsuggestions.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public final class MSServerConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final Features FEATURES;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        FEATURES = new Features(builder);
        CONFIG_SPEC = builder.build();
    }

    public static class Features {

        public BooleanValue enableBoneMealingDirt;
        public BooleanValue enableAngryZombieSpawn;

        public Features(ForgeConfigSpec.Builder builder) {
            builder.push("features");
            enableBoneMealingDirt = builder
                    .comment("BoneMealing dirt is enable?")
                    .define("boneMealingDirt", true);
            enableAngryZombieSpawn = builder
                    .comment("Enable angry zombie spawn?")
                    .define("angryZombieSpawn", true);
            builder.pop();
        }

    }

}
