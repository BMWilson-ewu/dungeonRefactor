package dungeon;

import java.util.ArrayList;
import java.util.Random;

import abilities.AttackPool;
import entities.Hero;
import entities.Monster;
import enums.Items;

public class Room {

	private String top;
	private String mid;
	private String bot;
	private ArrayList<Items> items;
	private Monster m;
	private Items uniqueItem;
	private double healPotChance;
	private double visPotChance;
	private double trapChance;

	public Room() {
		top = "* * *";
		mid = "* E *";
		bot = "* * *";
		items = new ArrayList<Items>();
		m = null;
		uniqueItem = null;
		healPotChance = .1;
		visPotChance = .1;
		trapChance = .1;
	}

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

	public boolean setUnique(Items item) {
		if (this.uniqueItem == null) {
			this.uniqueItem = item;
			return true;
		} else {
			return false;
		}
	}

	public String interactUnique(Hero h) {
		if (uniqueItem != null) {
			return AttackPool.getInstanceOf().getItem(uniqueItem).interact(h);
//			Items item = this.uniqueItem;
//			uniqueItem = null;
//			return item.interact(h);
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
				items.add(Items.HealingPotion);
			}
			chance = rng.nextDouble();
			if (chance < visPotChance) {
				items.add(Items.VisionPotion);
			}
			chance = rng.nextDouble();
			if (chance < trapChance) {
				items.add(Items.Pit);
			}
		}
		setLetter();
	}

	private void setLetter() {
		String letter = "";
		if (this.uniqueItem != null) {
			letter += AttackPool.getInstanceOf().getItem(uniqueItem).getAbbreviation();
		}
		if (this.m != null) {
			letter += "X";
		}
		for (Items item : this.items) {
			letter += AttackPool.getInstanceOf().getItem(item).getAbbreviation();
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
