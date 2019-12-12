package items;

import entities.Hero;
import enums.Items;

public class VisionPot implements Item {

	public String trigger(Hero hero) {
		hero.addItem(this.getKey());
		return hero.getName() + " picked up a vision potion";
	}

	public String interact(Hero hero) {
		return hero.getName() + " drank a Vison Potion and can now see the rooms around them.";
	}

	public String getAbbreviation() {
		return "V";
	}

	public Items getKey() {
		return Items.VisionPotion;
	}

}
