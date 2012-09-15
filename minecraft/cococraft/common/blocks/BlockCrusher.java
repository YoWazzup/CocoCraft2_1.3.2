package cococraft.common.blocks;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cococraft.client.ClientProxyCocoCraft;
import cococraft.common.CocoCraft;
import cococraft.common.machine.TileEntityCrusher;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class BlockCrusher extends BlockContainer{

	private Random crusherRand = new Random();
	private final boolean isActive;

	private static boolean keepCrusherInentory = false;

	public BlockCrusher(int i, boolean j)
	{
		super(i, Material.iron);
		isActive = j;
		setCreativeTab(CreativeTabs.tabBlock);
	}
	public int idDropped(int i, Random rand, int j)
	{
		return i;
	}
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}
	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.isRemote)
		{
			int var5 = par1World.getBlockId(par2, par3, par4 - 1);
			int var6 = par1World.getBlockId(par2, par3, par4 + 1);
			int var7 = par1World.getBlockId(par2 - 1, par3, par4);
			int var8 = par1World.getBlockId(par2 + 1, par3, par4);
			byte var9 = 3;

			if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
			{
				var9 = 3;
			}

			if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
			{
				var9 = 2;
			}

			if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
			{
				var9 = 5;
			}

			if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
			{
				var9 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, var9);
		}
	}
	@SideOnly(Side.CLIENT)
	public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		if(l == 1)
		{
			return ClientProxyCocoCraft.CrusherSide;
		}
		if(l == 0)
		{
			return ClientProxyCocoCraft.CrusherSide;
		}
		int i1 = iblockaccess.getBlockMetadata(i, j, k);
		if(l != i1)
		{
			return ClientProxyCocoCraft.CrusherSide;
		}
		else
		{
			return ClientProxyCocoCraft.CrusherFront;
		}
	}
	
	public int getBlockTextureFromSide(int side)
	{
		if (side == 3)
		{
			return ClientProxyCocoCraft.CrusherFront;
		}
		else
		{
			return ClientProxyCocoCraft.CrusherSide;
		}
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f)
	{
		if(world.isRemote)
		{
			return true;
		}
		else
		{
			TileEntityCrusher tile = (TileEntityCrusher)world.getBlockTileEntity(y, y, z);
			
			if(tile != null)
			{
				player.openGui(CocoCraft.proxy, 0, world, x, y, z);
				return true;
			}
		}
		return true;
	}
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityCrusher();
	}
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
        }

        if (var6 == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
        }

        if (var6 == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
        }

        if (var6 == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
        }
    }
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (!keepCrusherInentory)
        {
            TileEntityCrusher var7 = (TileEntityCrusher)par1World.getBlockTileEntity(par2, par3, par4);

            if (var7 != null)
            {
                for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
                {
                    ItemStack var9 = var7.getStackInSlot(var8);

                    if (var9 != null)
                    {
                        float var10 = this.crusherRand.nextFloat() * 0.8F + 0.1F;
                        float var11 = this.crusherRand.nextFloat() * 0.8F + 0.1F;
                        float var12 = this.crusherRand.nextFloat() * 0.8F + 0.1F;

                        while (var9.stackSize > 0)
                        {
                            int var13 = this.crusherRand.nextInt(21) + 10;

                            if (var13 > var9.stackSize)
                            {
                                var13 = var9.stackSize;
                            }

                            var9.stackSize -= var13;
                            EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

                            if (var9.hasTagCompound())
                            {
                                var14.item.setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                            }

                            float var15 = 0.05F;
                            var14.motionX = (double)((float)this.crusherRand.nextGaussian() * var15);
                            var14.motionY = (double)((float)this.crusherRand.nextGaussian() * var15 + 0.2F);
                            var14.motionZ = (double)((float)this.crusherRand.nextGaussian() * var15);
                            par1World.spawnEntityInWorld(var14);
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
}
