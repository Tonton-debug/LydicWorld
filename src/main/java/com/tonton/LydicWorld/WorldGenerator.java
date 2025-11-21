package com.tonton.LydicWorld;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.ChunkGenerator.BiomeGrid;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class WorldGenerator extends ChunkGenerator {

	public WorldGenerator() {
		// TODO Auto-generated constructor stub
	}
	 @Override
	    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
	        ChunkData chunk = createChunkData(world);
	        
	        return chunk;
	    }

}
