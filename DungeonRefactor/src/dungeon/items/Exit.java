package dungeon.items;

import dungeon.entities.Hero;
import dungeon.enums.Items;

public class Exit implements Item {

	public String trigger(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		return hero.getName() + " walks towards the exit.";
	}

	public String interact(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		if (hero.getNumPillars() < 4) {
			return "The sealed exit! " + hero.getName() + " may only leave once they possess "
					+ "all four pillars of OO.";
		} else {
			return hero.getName() + " has brought all four pillars to the exit!";
		}
	}

	public String getAbbreviation() {
		return "O";
	}

	public Items getKey() {
		return Items.Exit;
	}

}
