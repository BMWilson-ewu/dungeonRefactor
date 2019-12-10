package weapons;

import enums.Weapons;

public class Rapier implements Weapon {
	public String attackDesc() {
		return "lunges with the rapier at";
	}

	public Weapons getKeyword() {
		return Weapons.Rapier;
	}
}
