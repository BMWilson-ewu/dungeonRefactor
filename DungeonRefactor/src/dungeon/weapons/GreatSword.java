package dungeon.weapons;

import dungeon.enums.Weapons;

public class GreatSword implements Weapon {
	public String attackDesc() {
		return "swings a mighty greatsword at";
	}

	public Weapons getKeyword() {
		return Weapons.GreatSword;
	}
}
