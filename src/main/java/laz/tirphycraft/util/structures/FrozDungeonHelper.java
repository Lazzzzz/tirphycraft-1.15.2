package laz.tirphycraft.util.structures;

import java.util.Random;

import net.minecraft.util.math.Vec2f;

public class FrozDungeonHelper {

	private int sizeX = 0;
	private int sizeY = 0;
	private int steps = 0;
	private Vec2f point;
	private cells grid[][];
	private Vec2f oldPos [];
	private Random rand;

	public FrozDungeonHelper(int sizeX, int sizeY, Random random) {
		this.sizeX  = sizeX;
		this.sizeY  = sizeY;
		this.point  = new Vec2f(0, 0);
		this.rand   = random;
		this.oldPos = new Vec2f [this.sizeX * this.sizeY]; 
		initGrid();
	}

	private void initGrid() {
		this.grid = new cells[this.sizeX][this.sizeY];
		for (int i = 0; i < this.sizeX; i++) {
			for (int j = 0; j < this.sizeY; j++) {
				this.grid[i][j] = new cells(i, j);
			}
		}
	}

	public FrozDungeonHelper generateGrid() {
		int i = 0;
		boolean done = false;
		while (!done) {		
			i++;
			int next = getNextCells();
			if (next == -1) {
				this.steps --;
				this.point = oldPos[this.steps];
				if (steps == 0) break;
			} else {
				goToCells(next);
			}
		}
		
		return this;
	}

	private int getNextCells() {
		boolean valid [] = {false, false, false, false};		
		boolean   goBack = true;
		
		if (isValidMove(this.point.x + 1, this.point.y    )) {
			valid[0] = true;
			goBack   = false;
		}
		if (isValidMove(this.point.x    , this.point.y + 1)) {
			valid[1] = true;
			goBack   = false;
		}
		if (isValidMove(this.point.x - 1, this.point.y    )) {
			valid[2] = true;
			goBack   = false;
		}
		if (isValidMove(this.point.x    , this.point.y - 1)) {
			valid[3] = true;
			goBack   = false;
		}
		
		if (goBack) return -1;
		
		int dir = 0;
		while (true) {
			dir = rand.nextInt(4);
			if (valid[dir]) break;
		}
		
		return dir;
	}
	
	private boolean isValidMove(float f, float y) {
		if (f < 0 || f >= this.sizeX || y < 0 || y >= this.sizeY)
			return false;
		
		return !this.grid[(int) f][(int) y].isVisited();
	}
	
	public boolean[] getWalls(int i, int j) {
		return this.grid[i][j].getWalls();
	}
	
	public cells getLeftCells(int pos) {
		return this.grid[0][pos];
	}
	
	public cells getRightCells(int pos) {
		return this.grid[this.sizeX-1][pos];
	}
	
	public cells getTopCells(int pos) {
		return this.grid[pos][this.sizeY - 1];
	}
	
	public cells getBottomCells(int pos) {
		return this.grid[pos][0];
	}
	
	public int getSizeX() {
		return this.sizeX;
	}
	
	public int getSizeY() {
		return this.sizeY;
	}

	private void goToCells(int dir) {
		this.oldPos[this.steps] = this.point;
		this.steps ++;
		switch (dir) {
		case 0:
			this.grid[(int) this.point.x][(int) this.point.y].setWall(0, false);
			newPos(1, 0);
			this.grid[(int) this.point.x][(int) this.point.y].setWall(2, false);
			break;
		case 1:
			this.grid[(int) this.point.x][(int) this.point.y].setWall(1, false);
			newPos(0, 1);
			this.grid[(int) this.point.x][(int) this.point.y].setWall(3, false);
			break;
		case 2:
			this.grid[(int) this.point.x][(int) this.point.y].setWall(2, false);
			newPos(-1, 0);
			this.grid[(int) this.point.x][(int) this.point.y].setWall(0, false);
			break;
		case 3:
			this.grid[(int) this.point.x][(int) this.point.y].setWall(3, false);
			newPos(0, -1);
			this.grid[(int) this.point.x][(int) this.point.y].setWall(1, false);
			break;
		}
		
		this.grid[(int) this.point.x][(int) this.point.y].setVisited();
	}
	
	private void newPos(int x, int y) {
		this.point = new Vec2f(this.point.x + x, this.point.y + y);
	}
	
	public cells[][] getGrid() {
		return this.grid;
	}
	
	public class cells {

		private final int posX;
		private final int posY;
		private boolean visited = false;
		private boolean[] walls = { true, true, true, true};
		
		public cells(int posX, int posY) {
			this.posX = posX;
			this.posY = posY;
			this.visited = false;
		}

		public int getPosX() {
			return this.posX;
		}

		public int getPosY() {
			return this.posY;
		}

		public boolean isVisited() {
			return this.visited;
		}

		public void setVisited() {
			this.visited = true;
		}

		public void setWall(int direction, boolean state) {
			this.walls[direction] = state;
		}

		public boolean getWall(int direction) {
			return walls[direction];
		}
		
		public boolean [] getWalls(){
			return this.walls;
		}
	}

}
