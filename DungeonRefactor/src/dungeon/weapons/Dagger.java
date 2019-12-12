package dungeon.weapons;

import dungeon.enums.Weapons;

public class Dagger implements Weapon {
	public String attackDesc() {
		return "thrusts a dagger at";
	}

	public Weapons getKeyword() {
		return Weapons.Dagger;
	}
}
