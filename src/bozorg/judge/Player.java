package bozorg.judge;

import java.util.ArrayList;

public class Player extends Person{

    private int isWinner = 2;
    private String name;
    private int health = 100;
	private Cell[][] canSee;
    private Fan[] fans;
    private int putFan;
    private int speed;
    private int vision;
    private int power;
    private Cell place;
    private int fanNumber;
    private ArrayList<Fan> putFans = new ArrayList<Fan>();

	public Player(String name,int fanNumber, int s, int v, int p, int x, int y){
		this.name = name;
        this.fanNumber = fanNumber;
		speed = s;
		vision = v;
		power = p;
        place = setPlace(map.getCell[x][y]);
	}


    public int getIsWinner() {
        return isWinner;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void getVision(int vision) {
        for (int i = 0; i < vision * 2 + 1; i++) {
            for (int j = 0; j < vision * 2 + 1; j++) {
                canSee[i][j] = map.getPlace(getPlace().getX() - vision, getPlace().getY() - vision);
            }
        }
    }
    public void setVision(int vision) {
        this.vision = vision;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
		return power;
	}
	
	public void reducePower(int attackPower)
	{
		health -= attackPower;
	}
	
	public void toPutFan() {
        if (fanNumber != 0)
        {
            Fan addFan = new Fan();
            putFans.add(addFan);
            addFan.setPlace(place);
            fanNumber--;
        }

		
	}
	
	public void movePlayer(int direction)
	{

        if ( direction == UP && place.upWall())
        {
            time += speed;
            place = setPlace(map.getCell[place.getX()][place.getY()+1]);
        }
        if ( direction == DOWN && place.downWall())
        {
            time += speed;
            place = setPlace(map.getCell[place.getX()][place.getY()-1]);
        }
        if ( direction == LEFT && place.leftWall())
        {
            place = setPlace(map.getCell[place.getX()-1][place.getY()]);
            time += speed;
        }
        if ( direction == RIGHT && place.rightWall())
        {
            place = setPlace(map.getCell[place.getX()+1][place.getY()]);
        }
	}
	
	public void attackFan(Fan fan)
	{
			fan.setIsAlive(false); 
			fan.setPlace(null);
	}
	
	public void attackPlayer(Player player)
	{
		if ( player.getPower() <= this.getPower())
			{
				player.setIsAlive(false);
				player.setPlace(null);
			}
		else
			player.reducePower(this.getPower());
	}
	
	
	public void getGift()
	{
		if ( this.getPlace().getCellType()== SPEEDUP_CELL)
            //for 5 seconds
            speed = speed * 2;
        if ( this.getPlace().getCellType() == DARK_CELL)
           //for 3 seconds
            canSee = map.getMapGround();
        if ( this.getPlace().getCellType() == STONE_CELL)
            //for 3 seconds cant move
            movePlayer(NONE);
        if ( this.getPlace().getCellType() == FAN_CELL)
            fanNumber+=3;
        if (this.getPlace().getCellType() == JUMP_CELL)
        {
            place.changeWallType();
            time+=2;
        }
        if ( this.getPlace().getCellType() == HOSPITALL_CELL)
        {
            if (health >= 80)
                health = 100;
            else
                health+=20;
        }


	}
}

