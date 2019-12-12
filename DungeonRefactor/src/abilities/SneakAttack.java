package abilities;

import entities.DungeonCharacter;
import enums.Abilities;

public class SneakAttack implements SpecialAbility {

	public void special(DungeonCharacter source, DungeonCharacter enemy) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + source.getName() + " gets an additional turn.");
			source.setTurns(source.getTurns() + 1);
			AttackPool.getInstanceOf().getBasicAttack().attack(source, enemy);
		} else if (surprise >= .9) {
			System.out.println("Uh oh! " + enemy.getName() + " saw you and" + " blocked your attack!");
		} else
			AttackPool.getInstanceOf().getBasicAttack().attack(source, enemy);
	}

	public String specialDesc() {
		return "Sneak Attack";
	}

	public Abilities getKey() {
		return Abilities.SneakAttack;
	}

}
