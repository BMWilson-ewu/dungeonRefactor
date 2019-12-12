package items;

import entities.Hero;
import enums.Items;

public class PillarOfInheritance implements Item {

	public String trigger(Hero hero) {
		hero.addItem(this.getKey());
		return hero.getName() + " picked up a pillar of Inheritance.";
	}

	public String interact(Hero hero) {
		return hero.getName() + " examines the pillar, the pillar is partially damaged."
				+ " Parts of it have been chiped away, revealing the structure of the pillar.";
	}

	public String getAbbreviation() {
		return "P";
	}

	public Items getKey() {
		return Items.PillarOfInheritance;
	}

}
