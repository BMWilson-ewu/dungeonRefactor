package dungeon.items;

import dungeon.entities.Hero;
import dungeon.enums.Items;

public class VisionPot implements Item {

	public String trigger(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		hero.addItem(this.getKey());
		return hero.getName() + " picked up a vision potion";
	}

	public String interact(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Passed hero was null.");
		}
		return hero.getName() + " drank a Vison Potion and can now see the rooms around them.";
	}

	public String getAbbreviation() {
		return "V";
	}

	public Items getKey() {
		return Items.VisionPotion;
	}

}
