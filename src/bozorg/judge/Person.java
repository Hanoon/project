package bozorg.judge;

public class Person {

	public Boolean getIsAlive() {
		return isAlive;
	}
	public Cell getPlace() {
		return place;
	}
	private Boolean isAlive = true;
	private Cell place;
	
	public void setPlace(Cell place) {
		this.place = place;
	}
	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}
}
