package dungeon.weapons;

import dungeon.enums.Weapons;

public class RustyBlade implements Weapon {
	public String attackDesc() {
		return "swings a rusty blade at";
	}

	public Weapons getKeyword() {
		return Weapons.RustyBlade;
	}
}
