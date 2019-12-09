package dungeon;
import java.util.ArrayList;
import java.util.Random;

import entities.Monster;

public class Room {
	private String top;
	private String mid;
	private String bot;
	private ArrayList<RoomItem> items;
	private Monster m;
	private RoomItem uniqueItem;
	private double healPotChance;
	private double visPotChance;
	private double trapChance;
	
	public Room() {
		top = "* * *";
		mid = "* E *";
		bot = "* * *";
		items = new ArrayList<RoomItem>();
		m = null;
		uniqueItem = null;
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
	
	public void populateRoom(Room[][] dungeon, int x, int y) {
		buildRoom(dungeon, x, y);
		if(uniqueItem == null) {
			Random rng = new Random();
			double chance = rng.nextDouble();
			if(chance < healPotChance) {
				items.add(new HealPot());
			}
			chance = rng.nextDouble();
			if(chance < visPotChance) {
				items.add(new VisionPot());
			}
			chance = rng.nextDouble();
		}
		
	}
	
	public String toString() {
		return top + "\n" + mid + "\n" + bot;
	}
	
	public String getTop() {
		return this.top;
	}
	public String getMid() {
		return this.mid;
	}
	public String getBot() {
		return this.bot;
	}
	
	//TODO Remove this main
	public static void main(String[] args) {
		
		Room r = new Room();
		Room[][] dungeon = new Room[5][5];
		
		r.buildRoom(dungeon, 4, 5);
		System.out.println(r);
	}
	
	
}
