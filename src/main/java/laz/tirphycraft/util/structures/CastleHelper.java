package laz.tirphycraft.util.structures;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CastleHelper {

	private int radius;
	private int nb_tower;
	private World world;
	private Random rand;
	private BlockPos center;
	private ArrayList<AxisAlignedBB> areas;

	public CastleHelper(World world, BlockPos pos, Random rand, int radius) {
		this.world    = world;
		this.center   = pos;
		this.rand 	  = rand;
		this.radius   = radius;
		this.nb_tower = rand.nextInt(2)+ 6;
		this.areas    = new ArrayList<AxisAlignedBB>();
		
	}

	public void generateTowerArea() {
		int max_try = 40;
		
		for (int i = 0; i < nb_tower; i++) {
			boolean done = false;
			int k = 0;
			while (!done) {
				k++;
				if (k > max_try) break;
				
				int x = rand.nextInt(radius * 2) - radius;
				int z = rand.nextInt(radius * 2) - radius;
				int s = rand.nextInt(2) + 2;	
				
				AxisAlignedBB a = new AxisAlignedBB(center.add(x - s, 0, z - s), center.add(x + s, 1, z + s));
				done = true;
				if (x * x + z * z > radius * radius || x * x + z * z < 20 * 20) done = false; 
				
				for (int j = 0; j < areas.size(); j++) {
					if (a.intersects(areas.get(j))) {
						done = false;
						break;
					}
				}
				if (done) areas.add(a);
			}
		}
		
	}
	
	public ArrayList<AxisAlignedBB> getAreas(){
		return this.areas;
	}
}
