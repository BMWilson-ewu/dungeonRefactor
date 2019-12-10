package dungeon;

import java.util.Random;

import entities.Hero;

public class Pit implements Trap {
	
	public String trigger(Hero hero) {
		return hero.getName() + " fell into a pit.";
	}

	public String interact(Hero hero) {
		Random rng = new Random();
		int damage = rng.nextInt(20) + 1;
		hero.subtractHitPoints(damage);
		return hero.getName() + " lost " + damage + " hit points due to a pit.";
	}

	public String getAbbreviation() {
		return "T";
	}

	public String geyKeyword() {
		return "pit";
	}
	
}
