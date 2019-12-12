package dungeon.abilities;

import dungeon.entities.DungeonCharacter;
import dungeon.enums.Abilities;

public class TwinStrike implements SpecialAbility {

	public void special(DungeonCharacter source, DungeonCharacter target) {

		if (source == null) {
			throw new IllegalArgumentException("Atacker passed was null.");
		} else if (target == null) {
			throw new IllegalArgumentException("Defender passed was null.");
		}

		double two = Math.random();
		if (two <= .4) {
			System.out.println(source.getName() + " hits twice!");
			AttackPool.getInstanceOf().getBasicAttack().attack(source, target);
			AttackPool.getInstanceOf().getBasicAttack().attack(source, target);

		} else if (two >= .8) {
			System.out.println("Oh no! " + source.getName() + " missed both attacks!");
		} else {
			System.out.println(source.getName() + " hits once!");
			AttackPool.getInstanceOf().getBasicAttack().attack(source, target);
		}
	}

	public String specialDesc() {
		return "Twin Strike";
	}

	public Abilities getKey() {
		return Abilities.TwinStrike;
	}

}
