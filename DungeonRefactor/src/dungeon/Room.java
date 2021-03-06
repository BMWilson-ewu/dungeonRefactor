package dungeon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import dungeon.abilities.AttackPool;
import dungeon.entities.Hero;
import dungeon.entities.Monster;
import dungeon.enums.Items;

public class Room implements Serializable {

	private static final long serialVersionUID = 5977389200185624172L;
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
		healPotChance = .2;
		visPotChance = .1;
		trapChance = .1;
	}

	public boolean hasMonster() {
		return m != null;
	}

	public Monster getMonster() {
		Monster mon = this.m;
		this.m = null;
		setLetter();
		return mon;
	}

	public void setMonster(Monster monster) {
		if (hasMonster()) {
			throw new IllegalArgumentException("Room already has a Monster");
		}
		this.m = monster;
	}

	public boolean hasItems() {
		return items.size() > 0;
	}

	public ArrayList<Items> getItems() {
		return this.items;
	}
	
	public void clearItems() {
		this.items.clear();
		setLetter();
	}

	public void setItem(Items item) {
		if (item == null) {
			throw new IllegalArgumentException("Passed item was null");
		}
		items.add(item);
	}

	public boolean hasUniqueItem() {
		return this.uniqueItem != null;
	}

	public Items getUniqueItem() {
		Items item = this.uniqueItem;
		if (item != Items.Entrance && item != Items.Exit) {
			this.uniqueItem = null;
		}
		setLetter();
		return item;
	}
	
	public Items peekUniqueItem() {
		return this.uniqueItem;
	}

	public void setUnique(Items item) {
		if (hasUniqueItem()) {
			throw new IllegalArgumentException("Room already has a Unique Item");
		}
		this.uniqueItem = item;
	}

	public void buildRoom(Room[][] dungeon, int x, int y) {
		try {
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

		}
	}

	public String interactUnique(Hero h) {
		if (uniqueItem != null) {
			String message = AttackPool.getInstanceOf().getItem(uniqueItem).interact(h);
			if (uniqueItem != Items.Entrance && uniqueItem != Items.Exit) {
				this.uniqueItem = null;
			}
			setLetter();
			return message;
		} else {
			return "";
		}
	}

	public void populateRoomItems(Room[][] dungeon, int x, int y) {
		buildRoom(dungeon, x, y);
		if (!hasUniqueItem()) {
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
		if (this.items.size() != 0) {
			for (Items item : this.items) {
				letter += AttackPool.getInstanceOf().getItem(item).getAbbreviation();
			}
		}
		if (letter.length() > 1) {
			this.mid = this.mid.substring(0, 2) + "M" + this.mid.substring(3);
		} else if (letter.length() == 1) {
			this.mid = this.mid.substring(0, 2) + letter + this.mid.substring(3);
		} else {
			this.mid = this.mid.substring(0, 2) + "E" + this.mid.substring(3);
		}
	}
	
	public void setRoom(Room r) {
		if(r == null) {
			throw new IllegalArgumentException();
		}
		this.top = r.top;
		this.mid = r.mid;
		this.bot = r.bot;
		this.items = r.items;
		this.m = r.m;
		this.uniqueItem = r.uniqueItem;
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
