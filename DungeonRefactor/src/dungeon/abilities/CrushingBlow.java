package dungeon.abilities;

import dungeon.entities.DungeonCharacter;
import dungeon.enums.Abilities;

public class CrushingBlow implements SpecialAbility {

	public void special(DungeonCharacter source, DungeonCharacter target) {

		if (source == null) {
			throw new IllegalArgumentException("Atacker passed was null.");
		} else if (target == null) {
			throw new IllegalArgumentException("Defender passed was null.");
		}

		if (Math.random() <= .4) {
			int damage = (int) (Math.random() * 76) + 100;
			System.out.println(source.getName() + " lands a CRUSHING BLOW for " + damage + " damage!");
			target.subtractHitPoints(damage);
		} else {
			System.out.println(source.getName() + " failed to land a crushing blow");
			System.out.println();
		}
	}

	public String specialDesc() {
		return "Crushing Blow";
	}

	public Abilities getKey() {
		return Abilities.CrushingBlow;
	}

}
