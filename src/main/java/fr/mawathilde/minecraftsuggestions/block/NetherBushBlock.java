package fr.mawathilde.minecraftsuggestions.block;

import fr.mawathilde.minecraftsuggestions.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class NetherBushBlock extends SweetBerryBushBlock {

    public NetherBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(ItemInit.NETHER_BERRIES.get());
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.get(AGE);
        boolean flag = i == 3;
        if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i > 1) {
            int j = 1 + worldIn.rand.nextInt(2);
            spawnAsEntity(worldIn, pos, new ItemStack(ItemInit.NETHER_BERRIES.get(), j + (flag ? 1 : 0)));
            worldIn.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, 1), 2);
            return ActionResultType.func_233537_a_(worldIn.isRemote);
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            entity.setMotionMultiplier(state, new Vector3d(0.8, 0.75, 0.8));
            if (!world.isRemote && state.get(AGE) > 0 && (entity.lastTickPosX != entity.getPosX() || entity.lastTickPosZ != entity.getPosZ())) {
                double d0 = Math.abs(entity.getPosX() - entity.lastTickPosX);
                double d1 = Math.abs(entity.getPosZ() - entity.lastTickPosZ);
                if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                    entity.attackEntityFrom(DamageSource.HOT_FLOOR, 1);
                }
            }
        }
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader world, BlockPos pos) {
        return state.isIn(Blocks.NETHERRACK) || state.isIn(Blocks.field_235372_ml_) || state.isIn(Blocks.field_235381_mu_);
    }

}
