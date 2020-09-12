package fr.mawathilde.minecraftsuggestions.init;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.util.FoodConstants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MinecraftSuggestions.MOD_ID)
public final class ItemInit {

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(FoodConstants.SWEET_BERRIES_PIE)).setRegistryName("sweet_berries_pie"));
    }

}
