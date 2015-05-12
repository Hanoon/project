package bozorg.judge;

public class Cell {

	public int x, y;
	private int wallType;
	private int cellType;
	public Cell(int wallType, int cellType, int x, int y) {
		this.wallType = wallType;
		this.cellType = cellType;
		this.x = x;
		this.y = y;
	}
	public int getCellType() {
		return cellType;
	}
	public int getWallType() {
		return wallType;
	}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean rightWall()
    {
        int[] right = {2,3,6,7,10,11,14,15};
        for (int i = 0; i < right.length; i++) {
            if ( right[i] == wallType )
                return false;
        }
        return true;
    }
    public boolean leftWall()
    {
        int[] left = {8,9,10,11,12,13,14,15};
        for (int i = 0; i < left.length; i++) {
            if ( left[i] == wallType )
                return false;
        }
        return true;
    }

    public boolean downWall()
    {
        int[] down = {15,14,13,12,5,4,6,7};
        for (int i = 0; i < down.length; i++) {
            if ( down[i] == wallType )
                return false;
        }
        return true;
    }

    public boolean upWall()
    {
        int[] up = {1,3,5,7,8,11,13,15};
        for (int i = 0; i < up.length; i++) {
            if ( up[i] == wallType )
                return false;
        }
        return true;
    }

    public void changeWallType()
    {
        wallType = 0;
    }
}
