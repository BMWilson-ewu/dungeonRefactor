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
			AttackPool.getInstanceOf().getbasicAttack().attack(source, target);
			System.out.println(
					source.getName() + " SMITES the " + target.getName() + " for " + damage + " extra damage!");
			target.subtractHitPoints(damage);
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
