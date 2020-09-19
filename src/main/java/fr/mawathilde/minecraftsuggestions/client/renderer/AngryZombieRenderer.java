package fr.mawathilde.minecraftsuggestions.client.renderer;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.ZombieModel;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AngryZombieRenderer extends AbstractZombieRenderer<ZombieEntity, ZombieModel<ZombieEntity>> {

    protected static final ResourceLocation ANGRY_ZOMBIE_TEXTURE = new ResourceLocation(MinecraftSuggestions.MOD_ID, "textures/entity/zombie/angry_zombie.png");

    public AngryZombieRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ZombieModel<>(0.0F, false), new ZombieModel<>(0.5F, true), new ZombieModel<>(1.0F, true));
    }

    @Override
    public ResourceLocation getEntityTexture(ZombieEntity entity) {
        return ANGRY_ZOMBIE_TEXTURE;
    }

}