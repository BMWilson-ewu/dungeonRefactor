package weapons;

import enums.Weapons;

public class FireStaff implements Weapon {
	public String attackDesc() {
		return "launches a fireball at";
	}

	public Weapons getKeyword() {
		return Weapons.FireStaff;
	}
}
