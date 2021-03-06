package dungeon.abilities;

import dungeon.entities.DungeonCharacter;

public class BasicAttack {

	public void attack(DungeonCharacter source, DungeonCharacter target) {

		if (source == null) {
			throw new IllegalArgumentException("Atacker passed was null.");
		} else if (target == null) {
			throw new IllegalArgumentException("Defender passed was null.");
		}

		boolean canAttack = Math.random() <= source.getChanceToHit();
		int damage = 0;

		if (canAttack) {
			damage = (int) (Math.random() * (source.getMaxDamage() - source.getMinDamage() + 1))
					+ source.getMinDamage();
			System.out.println(
					source.getName() + " " + AttackPool.getInstanceOf().getWeapon(source.getWeapon()).attackDesc() + " "
							+ target.getName() + "!");
			target.subtractHitPoints(damage);

			System.out.println();
		} else {

			System.out.println(source.getName() + "'s attack on " + target.getName() + " failed!");
			System.out.println();
		}

	}

}
