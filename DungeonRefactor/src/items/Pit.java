package items;

import java.util.Random;

import entities.Hero;
import enums.Items;

public class Pit implements Item {

	public String trigger(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		return hero.getName() + " fell into a pit.";
	}

	public String interact(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		Random rng = new Random();
		int damage = rng.nextInt(20) + 1;
		hero.subtractHitPoints(damage);
		return hero.getName() + " lost " + damage + " hit points due to a pit.";
	}

	public String getAbbreviation() {
		return "T";
	}

	public Items getKey() {
		return Items.Pit;
	}

}
