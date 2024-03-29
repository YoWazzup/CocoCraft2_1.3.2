package cococraft2.common;

import java.util.Random;

import cococraft2.common.blocks.CocoCraftBlocks;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.worldType)
		{
		case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		case  0: generateSurface(world, random, chunkX*16, chunkZ*16);
		
		}
	}
	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	{
		
		int i;
		
		for(i = 0; i < 9; i++)
		{
			//CocoStone
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(20);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(CocoCraftBlocks.Ore.blockID, 0, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
		for(i = 0; i < 12; i++)
		{
			//Mithril
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(50);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(CocoCraftBlocks.Ore.blockID, 1, 6)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
		for(i = 0; i < 12; i++)
		{
			//Silver
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(50);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(CocoCraftBlocks.Ore.blockID, 2, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
		for(i = 0; i < 9; i++)
		{
			//Amethyst
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(20);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(CocoCraftBlocks.Ore.blockID, 3, 2)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
		for(i = 0; i < 12; i++)
		{
			//Essence
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(128);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(CocoCraftBlocks.Essence.blockID, -1, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}

	private void generateNether(World world, Random random, int i, int j) 
	{
		
		
	}

}
