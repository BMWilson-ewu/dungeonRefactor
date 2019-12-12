package abilities;

import entities.DungeonCharacter;
import enums.Abilities;

public class Smite implements SpecialAbility {

	public void special(DungeonCharacter source, DungeonCharacter target) {

		if (source == null) {
			throw new IllegalArgumentException("Atacker passed was null.");
		} else if (target == null) {
			throw new IllegalArgumentException("Defender passed was null.");
		}

		double smite = Math.random();
		if (smite <= .4) {
			int damage = (int) (Math.random() * 88);
<<<<<<< HEAD
			AttackPool.getInstanceOf().getbasicAttack().attack(source, target);
			System.out.println(
					source.getName() + " SMITES the " + target.getName() + " for " + damage + " extra damage!");
			target.subtractHitPoints(damage);
=======
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
			System.out.println(source.getName() + " attacks and SMITES the " + enemy.getName() + " for " + damage + " extra damage!");
			enemy.subtractHitPoints(damage);
>>>>>>> be60dd81033b8b487d41e65dddd86c757aadd169
		} else if (smite >= .9) {
			System.out.println(source.getName() + " failed to land the attack!");
		} else {
			System.out.println(source.getName() + " attacks but fails to smite");
			AttackPool.getInstanceOf().getbasicAttack().attack(source, target);
		}
	}

	public String specialDesc() {
		return "SMITE";
	}

	public Abilities getKey() {
		return Abilities.Smite;
	}

}
