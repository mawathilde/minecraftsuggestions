package fr.mawathilde.minecraftsuggestions.common.item;

import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;

import java.util.function.Supplier;

@SuppressWarnings("ConstantConditions")
public class CustomSpawnEggItem extends SpawnEggItem {

    protected Supplier<EntityType<?>> entityTypeSupplier;

    public CustomSpawnEggItem(Supplier<EntityType<?>> entityTypeSupplier, int primaryColorIn, int secondaryColorIn, Properties builder) {
        super(null, primaryColorIn, secondaryColorIn, builder);
        this.entityTypeSupplier = entityTypeSupplier;
    }

    @Override
    public EntityType<?> getType(CompoundNBT nbt) {
        if (nbt != null && nbt.contains("EntityTag", 10)) {
            CompoundNBT compoundnbt = nbt.getCompound("EntityTag");
            if (compoundnbt.contains("id", 8)) {
                return EntityType.byKey(compoundnbt.getString("id")).orElse(entityTypeSupplier.get());
            }
        }
        return entityTypeSupplier.get();
    }

}
