package items;

import entities.Hero;
import enums.Items;

public class Entrance implements Item {

	public String trigger(Hero hero) {
		return hero.getName() + " walks towards what used to be the entrance.";
	}

	public String interact(Hero hero) {
		return "The collapsed entrance " + hero.getName() + " came in from. It seems turning back "
				+ "is impossible...";
	}

	public String getAbbreviation() {
		return "I";
	}

	public Items getKey() {
		return Items.Entrance;
	}

}
