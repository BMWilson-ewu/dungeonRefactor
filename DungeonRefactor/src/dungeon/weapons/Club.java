package dungeon.weapons;

import dungeon.enums.Weapons;

public class Club implements Weapon {
	public String attackDesc() {
		return "swings a gnarled club at";
	}

	public Weapons getKeyword() {
		return Weapons.Club;
	}
}
