
package cococraft.common;

import java.util.Random;

import cococraft.common.blocks.CocoCraft2Blocks;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorCoco implements IWorldGenerator{

	
	public static CocoCraft2Blocks blocks;
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
		
		for (i = 0; i < 9; ++ i)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(20);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(blocks.Ores.blockID, 0, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
			//System.out.println("Generated Ore Coco");
		}
		for (i = 0; i < 12; ++ i)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(50);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(blocks.Ores.blockID, 1, 6)).generate(world, random, Xcoord, Ycoord, Zcoord);
			//System.out.println("Generated Ore Mithril");
		}
		for (i = 0; i < 12; ++ i)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(50);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(blocks.Ores.blockID, 2, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
			//System.out.println("Generated Ore Silver");
		}
		for (i = 0; i < 9; ++ i)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(14);
			int Zcoord = blockZ + random.nextInt(16);
			(new WorldGenMinable(blocks.Ores.blockID,3 , 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
			//System.out.println("Generated Ore Amethyst");
		}
	}
	private void generateNether(World world, Random random, int blockX, int blockY)
	{

	}
}
