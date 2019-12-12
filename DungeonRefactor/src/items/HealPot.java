package items;

import java.util.Random;

import entities.Hero;
import enums.Items;

public class HealPot implements Item {

	public String trigger(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		hero.addItem(this.getKey());
		return hero.getName() + " picked up a healing potion.";
	}

	public String interact(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		Random rng = new Random();
		int heal = rng.nextInt(11) + 5;
		hero.addHitPoints(heal);
		return hero.getName() + " drank a Healing Potion and healed for " + heal + " points";
	}

	public String getAbbreviation() {
		return "H";
	}

	public Items getKey() {
		return Items.HealingPotion;
	}

}
