package weapons;

import enums.Weapons;

public class Kris implements Weapon {
	public String attackDesc() {
		return "jabs its kris at";
	}

	public Weapons getKeyword() {
		return Weapons.Kris;
	}
}
