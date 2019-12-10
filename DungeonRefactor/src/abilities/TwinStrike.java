package abilities;

import entities.DungeonCharacter;
<<<<<<< HEAD:DungeonRefactor/src/abilities/TwinStrike.java
import enums.Abilities;

public class TwinStrike implements SpecialAbility {
=======
import weapons.AttackPool;
>>>>>>> jhentz:DungeonRefactor/src/specials/TwinStrike.java

	public void special(DungeonCharacter source, DungeonCharacter enemy) {
		double two = Math.random();
		if (two <= .4) {
			System.out.println(source.getName() + " hits twice!");
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
<<<<<<< HEAD:DungeonRefactor/src/abilities/TwinStrike.java
		} else if (two >= .8) {
=======
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
		} // end surprise
		else if (two >= .8) {
>>>>>>> jhentz:DungeonRefactor/src/specials/TwinStrike.java
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
