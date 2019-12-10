package items;

import entities.Hero;
import enums.Items;

public class PillarOfPolymorphism implements Item {

	public String trigger(Hero hero) {
		return hero.getName() + " picked up a pillar of Inheritance.";
	}

	public String interact(Hero hero) {
		return hero.getName() + " examinations the pillar, the pillar emits a light or maybe a dim energy."
				+ " The pillar seems to be pulsing not only by brightness but its structure seems to be moving slowly.";
	}

	public String getAbbreviation() {
		return "P";
	}

	public Items getKey() {
		return Items.PillarOfPolymorphism;
	}

}
