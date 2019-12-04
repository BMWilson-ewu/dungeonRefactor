package dungeon;

import java.util.Random;

import entities.Hero;

public class HealPot implements RoomItem {
	public String interact(Hero h) {
		h.addHealPot(new HealPot());
		return h.getName() + " picked up a healing potion.";
	}
	public String getAbbreviation() {
		return "H";
	}
	public String consume(Hero h) {
		Random rng = new Random();
		int heal = rng.nextInt(11) + 5;
		h.addHitPoints(heal);
		return h.getName() + " healed for " + heal + " points";
	}
}
