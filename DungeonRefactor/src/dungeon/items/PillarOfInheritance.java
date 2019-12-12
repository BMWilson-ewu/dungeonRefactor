package dungeon.items;

import dungeon.entities.Hero;
import dungeon.enums.Items;

public class PillarOfInheritance implements Item {

	public String trigger(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		hero.addItem(this.getKey());
		return hero.getName() + " picked up a pillar of Inheritance.";
	}

	public String interact(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
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
