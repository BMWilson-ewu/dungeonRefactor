package weapons;

import enums.Weapons;

public class ShortBow implements Weapon {
	public String attackDesc() {
		return "shoots the shortbow at";
	}

	public Weapons getKeyword() {
		return Weapons.ShortBow;
	}
}
