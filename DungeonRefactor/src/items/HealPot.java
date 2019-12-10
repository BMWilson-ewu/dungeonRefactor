package items;

import java.util.Random;

import entities.Hero;
import enums.Items;

public class HealPot implements Item {

	public String trigger(Hero hero) {
		hero.addItem(this.getKey());
		return hero.getName() + " picked up a healing potion.";
	}

	public String interact(Hero hero) {
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
