package bozorg.judge;

public class Map {

	private Cell[][] mapGround;
	private int row;
	private int column;
	public Map(int[][] cellType,int[][] wallType)
	{
		row = cellType.length;
		column = cellType[0].length;
		mapGround = new Cell[row][column];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
			{
				mapGround[i][j] = new Cell(cellType[i][j], wallType[i][j], i ,j);
			}
	}	
	public int getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	public int getCellType(int x, int y){
		return mapGround[x][y].getCellType();
	}
	public int getWallType(int x, int y){
		return mapGround[x][y].getWallType();
	}

    public Cell[][] getMapGround() {
        return mapGround;
    }

    public Cell getPlace(int x, int y)
    {
        return mapGround[x][y];
    }
}
