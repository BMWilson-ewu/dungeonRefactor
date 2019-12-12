package dungeon.abilities;

import dungeon.entities.DungeonCharacter;
import dungeon.enums.Abilities;

public class SneakAttack implements SpecialAbility {

	public void special(DungeonCharacter source, DungeonCharacter target) {

		if (source == null) {
			throw new IllegalArgumentException("Atacker passed was null.");
		} else if (target == null) {
			throw new IllegalArgumentException("Defender passed was null.");
		}

		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + source.getName() + " gets an additional turn.");
			source.setTurns(source.getTurns() + 1);
			AttackPool.getInstanceOf().getBasicAttack().attack(source, target);
		} else if (surprise >= .9) {
			System.out.println("Uh oh! " + target.getName() + " saw you and" + " blocked your attack!");
		} else
			AttackPool.getInstanceOf().getBasicAttack().attack(source, target);
	}

	public String specialDesc() {
		return "Sneak Attack";
	}

	public Abilities getKey() {
		return Abilities.SneakAttack;
	}

}
