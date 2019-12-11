package items;

import entities.Hero;
import enums.Items;

public class PillarOfEncapsulation implements Item {

	public String trigger(Hero hero) {
		return hero.getName() + " picked up a pillar of Encapsulation.";
	}

	public String interact(Hero hero) {
		return hero.getName()
				+ " examines the pillar, it appears to be made out of an extremly hard material.";
	}

	public String getAbbreviation() {
		return "P";
	}

	public Items getKey() {
		return Items.PillarOfEncapsulation;
	}

}
