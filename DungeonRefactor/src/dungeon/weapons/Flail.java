package dungeon.weapons;

import dungeon.enums.Weapons;

public class Flail implements Weapon {
	public String attackDesc() {
		return "swings a wicked flail at";
	}

	public Weapons getKeyword() {
		return Weapons.Flail;
	}
}