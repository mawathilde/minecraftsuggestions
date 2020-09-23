package fr.mawathilde.minecraftsuggestions.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public final class MSClientConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final Renders RENDERS;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        RENDERS = new Renders(builder);
        CONFIG_SPEC = builder.build();
    }

    public static class Renders {

        public BooleanValue enableVillagerParticles;

        public Renders(ForgeConfigSpec.Builder builder) {
            builder.push("renders");
            enableVillagerParticles = builder.define("villagerParticles", true);
            builder.pop();
        }

    }

}
