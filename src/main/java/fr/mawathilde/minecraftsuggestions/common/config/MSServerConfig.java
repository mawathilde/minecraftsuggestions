package fr.mawathilde.minecraftsuggestions.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;

public final class MSServerConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final Features FEATURES;
    public static final Mobs MOBS;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        FEATURES = new Features(builder);
        MOBS = new Mobs(builder);
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

    public static class Mobs {

        public MobDifficultySpawnRateValue angryZombieSpawnRate;

        public Mobs(ForgeConfigSpec.Builder builder) {
            builder.push("mobs");
            angryZombieSpawnRate = new MobDifficultySpawnRateValue(builder.comment("Percentage of zombies that will be angry zombies"), "angryZombieSpawnRate", -1, 0.12, 0.45, 0.77);
            builder.pop();
        }

    }

    public static class MobDifficultySpawnRateValue {

        public DoubleValue peacefulRate;

        public DoubleValue easyRate;

        public DoubleValue normalRate;

        public DoubleValue hardRate;


        public MobDifficultySpawnRateValue(ForgeConfigSpec.Builder builder, String name, double peacefulDefault, double easyDefault, double normalDefault, double hardDefault) {
            builder.push(name);
            if(peacefulDefault >= 0) {
                peacefulRate = builder.defineInRange("peaceful", peacefulDefault, 0.0, 1.0);
            }
            if(easyDefault >= 0) {
                easyRate = builder.defineInRange("easy", easyDefault, 0.0, 1.0);
            }
            if(normalDefault >= 0) {
                normalRate = builder.defineInRange("normal", normalDefault, 0.0, 1.0);
            }
            if(hardDefault >= 0) {
                hardRate = builder.defineInRange("hard", hardDefault, 0.0, 1.0);
            }
            builder.pop();
        }

    }

}
