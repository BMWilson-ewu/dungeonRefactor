package items;

import entities.Hero;
import enums.Items;

public class VisionPot implements Item {

	public String trigger(Hero hero) {
		hero.addItem(this.getKey());
		return hero.getName() + " picked up a vision potion";
	}

	public String interact(Hero hero) {
		String output = "";

		// Maybe move this logic somewhere else? IDK would make my life easy
		/*
		 * for(int i = hero.getY() - 1; i <= hero.getY() + 1; i++) { for(int j = 0; j <
		 * 3; j++) { for(int k = hero.getX() - 1; k <= hero.getX() + 1; k++) { try {
		 * if(j == 0) { output += dungeon[i][k].getTop() + " "; } else if(j == 1) {
		 * output += dungeon[i][k].getMid() + " "; } else if(j == 2) { output +=
		 * dungeon[i][k].getBot() + " "; } } catch(ArrayIndexOutOfBoundsException e) {
		 * output += "* * * "; } } output += "\n"; } }
		 */

		return output;
		// return hero.getName() + " drank a Vison Potion and can now see {x} Rooms
		// around them.";
	}

	public String getAbbreviation() {
		return "V";
	}

	public Items getKey() {
		return Items.VisionPotion;
	}

}
