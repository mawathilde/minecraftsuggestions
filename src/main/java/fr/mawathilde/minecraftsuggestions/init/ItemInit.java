package fr.mawathilde.minecraftsuggestions.init;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.common.item.CustomSpawnEggItem;
import fr.mawathilde.minecraftsuggestions.util.FoodConstants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MinecraftSuggestions.MOD_ID)
public final class ItemInit {

    @ObjectHolder("angry_zombie_spawn_egg")
    public static CustomSpawnEggItem ANGRY_ZOMBIE_SPAWN_EGG;

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(FoodConstants.SWEET_BERRIES_PIE)).setRegistryName("sweet_berries_pie"));
        registry.register(new CustomSpawnEggItem(() -> EntityInit.ANGRY_ZOMBIE, 44975, 16711680, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("angry_zombie_spawn_egg"));
    }

}
