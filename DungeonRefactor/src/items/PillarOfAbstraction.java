package items;

import entities.Hero;
import enums.Items;

public class PillarOfAbstraction implements Item {

	public String trigger(Hero hero) {
		return hero.getName() + " picked up a pillar of Abstraction.";
	}

	public String interact(Hero hero) {
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
