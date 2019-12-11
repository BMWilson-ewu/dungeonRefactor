package abilities;

import entities.DungeonCharacter;

import enums.Abilities;

public class TwinStrike implements SpecialAbility {


	public void special(DungeonCharacter source, DungeonCharacter enemy) {
		double two = Math.random();
		if (two <= .4) {
			System.out.println(source.getName() + " hits twice!");
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
		} else if (two >= .8) {
			System.out.println("Oh no! " + source.getName() + " missed both attacks!");
		} else {
			System.out.println(source.getName() + " hits once!");
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
		}
	}

	public String specialDesc() {
		return "Twin Strike";
	}

	public Abilities getKey() {
		return Abilities.TwinStrike;
	}

}
