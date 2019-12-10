package dungeon;

import java.util.ArrayList;
import java.util.Random;

import entities.Hero;
import entities.Monster;
import items.HealPot;
import items.Item;
import items.Pit;
import items.VisionPot;

public class Room {
	private String top;
	private String mid;
	private String bot;
	private ArrayList<Item> items;
	private Monster m;
	private Item uniqueItem;
	private double healPotChance;
	private double visPotChance;
	private double trapChance;

	public Room() {
		top = "* * *";
		mid = "* E *";
		bot = "* * *";
		items = new ArrayList<Item>();
		m = null;
		uniqueItem = null;
		healPotChance = .1;
		visPotChance = .1;
		trapChance = .1;
	}

	/*
	 * public void setTop(String s) { this.top = s; } public void setMid(String s) {
	 * this.mid = s; } public void setBot(String s) { this.top = s; }
	 */

	public void buildRoom(Room[][] dungeon, int x, int y) {
		try {
			Room r = dungeon[y][x];
			if (y > 0) {
				top = "* - *";
			}
			if (y < dungeon.length - 1) {
				bot = "* - *";
			}
			if (x > 0) {
				mid = "|" + mid.substring(1);
			}
			if (x < dungeon[0].length - 1) {
				mid = mid.substring(0, dungeon[0].length - 1) + "|";
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			/*
			 * System.out.println("Invalid index passed to buildRoom...x=" + x + ", y=" +
			 * y); e.printStackTrace();
			 */
		}
	}

	public boolean setUnique(Item item) {
		if (this.uniqueItem == null) {
			this.uniqueItem = item;
			return true;
		} else {
			return false;
		}
	}

	public String interactUnique(Hero h) {
		if (uniqueItem != null) {
			Item item = this.uniqueItem;
			uniqueItem = null;
			return item.interact(h);
		} else {
			return "";
		}
	}

	// this method should be called after setUnique and setMonster to work properly
	public void populateRoomItems(Room[][] dungeon, int x, int y) {
		buildRoom(dungeon, x, y);
		if (uniqueItem == null) {
			Random rng = new Random();
			double chance = rng.nextDouble();
			if (chance < healPotChance) {
				items.add(new HealPot());
			}
			chance = rng.nextDouble();
			if (chance < visPotChance) {
				items.add(new VisionPot());
			}
			chance = rng.nextDouble();
			if (chance < trapChance) {
				items.add((Item) new Pit()); // BAD HERE
			}
		}
		setLetter();
	}

	private void setLetter() {
		String letter = "";
		if (this.uniqueItem != null) {
			letter += this.uniqueItem.getAbbreviation();
		}
		if (this.m != null) {
			letter += "X";
		}
		for (Item item : this.items) {
			letter += item.getAbbreviation();
		}

		if (letter.length() > 1) {
			this.mid = "* M *";
		} else if (letter.length() == 1) {
			this.mid = "* " + letter + " *";
		}
	}

	public boolean setMonster(Monster m) {
		if (this.m == null && this.uniqueItem == null) {
			this.m = m;
			return true;
		} else {
			return false;
		}
	}

	public Monster getMonster() {
		Monster toRet = this.m;
		this.m = null;
		return toRet;
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
}
