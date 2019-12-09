package specials;

import entities.DungeonCharacter;

public class BasicAttack {
	
	public void attack(DungeonCharacter source, DungeonCharacter target) {
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= source.getChanceToHit();

		if (canAttack) {
			damage = (int) (Math.random() * (source.getMaxDamage() - source.getMinDamage() + 1)) + source.getMinDamage();
			System.out.println(source.getName() + " " + source.getWeapon().attackDesc() + " " + target.getName() + "!");
			target.subtractHitPoints(damage);

			System.out.println();
		} else {

			System.out.println(source.getName() + "'s attack on " + target.getName() + " failed!");
			System.out.println();
		}

	}

}
