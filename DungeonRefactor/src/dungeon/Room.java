package dungeon;
import java.util.ArrayList;
import java.util.Random;

public class Room {
	private String top;
	private String mid;
	private String bot;
	private ArrayList<Object> items;
	private double healPotChance;
	private double visPotChance;
	private double trapChance;
	
	public Room() {
		top = "* * *";
		mid = "* E *";
		bot = "* * *";
		items = new ArrayList<Object>();
		healPotChance = .1;
		visPotChance = .1;
		trapChance = .1;
	}
	
/*	public void setTop(String s) {
		this.top = s;
	}
	public void setMid(String s) {
		this.mid = s;
	}
	public void setBot(String s) {
		this.top = s;
	}*/
	
	public void buildRoom(Room[][] dungeon, int x, int y) {
		try {
			Room r = dungeon[y][x];
			if(y > 0) {
				top = "* - *";
			}
			if(y < dungeon.length - 1) {
				bot = "* - *";
			}
			if(x > 0) {
				mid = "|" + mid.substring(1);
			}
			if(x < dungeon[0].length - 1) {
				mid = mid.substring(0, dungeon[0].length - 1) + "|";
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index passed to buildRoom...x=" + x + ", y=" + y);
			e.printStackTrace();
		}
	}
	
	public void populateRoom(Room[][] dungeon, int x, int y, Object uniqueItem) {
		buildRoom(dungeon, x, y);
		items.add(uniqueItem);
		if(!(uniqueItem instanceof Entrance) && !(uniqueItem instanceof Exit)) {
			Random rng = new Random();
			double chance = rng.nextDouble();
			if(chance < healPotChance) {
				
			}
		}
		
	}
	
	public String toString() {
		return top + "\n" + mid + "\n" + bot;
	}
	
	public static void main(String[] args) {
		
		Room r = new Room();
		Room[][] dungeon = new Room[5][5];
		
		r.buildRoom(dungeon, 4, 5);
		System.out.println(r);
	}
	
	
}
