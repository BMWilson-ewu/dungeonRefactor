package abilities;

import entities.DungeonCharacter;
<<<<<<< HEAD:DungeonRefactor/src/abilities/Smite.java
import enums.Abilities;
=======
import weapons.AttackPool;
>>>>>>> jhentz:DungeonRefactor/src/specials/Smite.java

public class Smite implements SpecialAbility {
	public void special(DungeonCharacter source, DungeonCharacter enemy) {
		double smite = Math.random();
		if (smite <= .4) {
			int damage = (int) (Math.random() * 88);
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
<<<<<<< HEAD:DungeonRefactor/src/abilities/Smite.java
			System.out.println(source.getName() + " SMITES the with his attack" + enemy.getName() + " for " + damage
					+ " extra damage!");
=======
			System.out.println(source.getName() + " SMITES the with his attack " + enemy.getName() + " for " + damage + " extra damage!");
>>>>>>> jhentz:DungeonRefactor/src/specials/Smite.java
			enemy.subtractHitPoints(damage);
		} else if (smite >= .9) {
			System.out.println(source.getName() + " failed to land the attack!");
		} else {
			System.out.println(source.getName() + " attacks but fails to smite");
			AttackPool.getInstanceOf().getbasicAttack().attack(source, enemy);
		}
	}

	public String specialDesc() {
		return "SMITE";
	}

	public Abilities getKey() {
		return Abilities.Smite;
	}

}
