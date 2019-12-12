package dungeon.weapons;

import dungeon.enums.Weapons;

public class Trident implements Weapon {
	public String attackDesc() {
		return "stabs forward with a trident at";
	}

	public Weapons getKeyword() {
		return Weapons.Trident;
	}
}
