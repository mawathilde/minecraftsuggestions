package fr.mawathilde.minecraftsuggestions.init;

import fr.mawathilde.minecraftsuggestions.MinecraftSuggestions;
import fr.mawathilde.minecraftsuggestions.util.FoodConstants;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Item.class, MinecraftSuggestions.MOD_ID);

    public static final RegistryObject<Item> NETHER_BERRIES = ITEMS.register("nether_berries", () -> new BlockNamedItem(BlockInit.NETHER_BERRY_BUSH.get(), new Item.Properties().group(ItemGroup.FOOD).food(FoodConstants.NETHER_BERRIES)));

}
