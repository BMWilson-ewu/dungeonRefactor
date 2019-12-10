package weapons;

import enums.Weapons;

public class GreatAxe implements Weapon {
	public String attackDesc() {
		return "slashes with a greataxe at";
	}

	public Weapons getKeyword() {
		return Weapons.GreatAxe;
	}
}
