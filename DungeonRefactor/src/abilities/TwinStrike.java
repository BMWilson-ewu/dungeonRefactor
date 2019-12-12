package abilities;

import entities.DungeonCharacter;
import enums.Abilities;

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
<<<<<<< HEAD
			AttackPool.getInstanceOf().getbasicAttack().attack(source, target);
=======
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
>>>>>>> be60dd81033b8b487d41e65dddd86c757aadd169
		} else if (two >= .8) {
			System.out.println("Oh no! " + source.getName() + " missed both attacks!");
		} else {
			System.out.println(source.getName() + " hits once!");
			AttackPool.getInstanceOf().getbasicAttack().attack(source, target);
		}
	}

	public String specialDesc() {
		return "Twin Strike";
	}

	public Abilities getKey() {
		return Abilities.TwinStrike;
	}

}
