package items;

import entities.Hero;
import enums.Items;

public class PillarOfInheritance implements Item {

	public String trigger(Hero hero) {
		return hero.getName() + " picked up a pillar of Inheritance.";
	}

	public String interact(Hero hero) {
		return hero.getName() + " examinations the pillar, the pillar is extremly degraded."
				+ " Parts of the pillar have been chiped away revealing a layered like structure of the pillar.";
	}

	public String getAbbreviation() {
		return "P";
	}

	public Items getKey() {
		return Items.PillarOfInheritance;
	}

}
