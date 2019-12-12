package items;

import entities.Hero;
import enums.Items;

public class PillarOfPolymorphism implements Item {

	public String trigger(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		hero.addItem(this.getKey());
		return hero.getName() + " picked up a pillar of Polymorphism.";
	}

	public String interact(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		return hero.getName() + " examines the pillar, which emits a dim glow."
				+ " The pillar's appearance seems to be shifting each time " + hero.getName() + " looks away.";
	}

	public String getAbbreviation() {
		return "P";
	}

	public Items getKey() {
		return Items.PillarOfPolymorphism;
	}

}
