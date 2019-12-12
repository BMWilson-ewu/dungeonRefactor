package dungeon.items;

import dungeon.entities.Hero;
import dungeon.enums.Items;

public class PillarOfAbstraction implements Item {

	public String trigger(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		hero.addItem(this.getKey());
		return hero.getName() + " picked up a pillar of Abstraction.";
	}

	public String interact(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		return hero.getName() + " examines the pillar, as they rotate the pillar parts of it become invisible... "
				+ "alsmot like part of the pillar is hidden from plain sight.";
	}

	public String getAbbreviation() {
		return "P";
	}

	public Items getKey() {
		return Items.PillarOfAbstraction;
	}

}
