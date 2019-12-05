package dungeon;

import java.util.Random;

import entities.Hero;

public class RoomTrap implements RoomItem {
	
	private String name;
	
	public RoomTrap(String name) {
		this.name = name;
	}

	@Override
	public String interact(Hero h) {
		return h.getName() + " fell into a " + this.name + ".";
	}

	@Override
	public String getAbbreviation() {
		return "T";
	}
	
	public String trigger(Hero h) {
		Random rng = new Random();
		int damage = rng.nextInt(20) +1;
		return h.getName() + " lost " + damage + " hit points due to a " + this.name;
	}

}
