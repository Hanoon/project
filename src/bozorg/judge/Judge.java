package bozorg.judge;

import java.util.ArrayList;

import bozorg.common.GameObjectID;

public class Judge extends JudgeAbstract {

	int time = 0;
	int MapWidth, MapHeight;
	int[][] cellsType = new int[100][100];
	int[][] wallsType = new int[100][100];
	int[] players = new int[4];
    public Map map = new Map(cellsType, wallsType);
    Player[] AllPlayers = new Player[4];

    public void addPlayers(){
        int x, y;
        for(int i = 0; i < 4; i++)
        {
            x = i * getMapWidth();
            y = i/2 * getMapHeight();
            if(players[i] == SAMAN)
                AllPlayers[i] = new Player("SAMAN", 100, 2, 3, 5, x, y);
            else if(players[i] == JAFAR)
                AllPlayers[i] = new Player("JAFAR", 0, 2, 6, 4, x, y);
            else if(players[i] == REZA)
                AllPlayers[i] = new Player("REZA",10, 2, 3, 5, x, y);
            else if(players[i] == HASIN)
                AllPlayers[i] = new Player("HASIN", 5, 3, 3, 1, x, y);
        }
    }
	// map functions
	public ArrayList<GameObjectID> loadMap(int[][] cellsType,
			int[][] wallsType, int[] players) {
		this.cellsType = cellsType;
		this.wallsType = wallsType;
		this.players = players;
	}

	public int getMapWidth() {
		return MapWidth;
	}

	public int getMapHeight() {
		return MapHeight;
	}

	public int getMapCellType(int col, int row) {
		return cellsType[row][col];
	}

	public abstract int getMapCellType(int col, int row, GameObjectID player);

	public int getMapWallType(int col, int row){
		return wallsType[row][col];
	}

	public int getMapWallType(int col, int row, GameObjectID player);

	public void setup();
	
	public void next50milis();

	// logic functions

}
