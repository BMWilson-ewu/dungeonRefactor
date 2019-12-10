package abilities;

import entities.DungeonCharacter;
<<<<<<< HEAD:DungeonRefactor/src/specials/TwinStrike.java
import weapons.AttackPool;
=======
import enums.Abilities;

public class TwinStrike implements SpecialAbility {
>>>>>>> eca2a7e2f5cdb6fa46fdd60fdb851970ad0e273c:DungeonRefactor/src/abilities/TwinStrike.java

	public void special(DungeonCharacter source, DungeonCharacter enemy) {
		double two = Math.random();
		if (two <= .4) {
			System.out.println(source.getName() + " hits twice!");
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
<<<<<<< HEAD:DungeonRefactor/src/specials/TwinStrike.java
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
		} // end surprise
		else if (two >= .8) {
=======
		} else if (two >= .8) {
>>>>>>> eca2a7e2f5cdb6fa46fdd60fdb851970ad0e273c:DungeonRefactor/src/abilities/TwinStrike.java
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
