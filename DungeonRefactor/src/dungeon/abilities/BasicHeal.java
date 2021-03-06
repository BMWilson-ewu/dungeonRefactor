package dungeon.abilities;

import dungeon.entities.Monster;

public class BasicHeal {

	public void heal(Monster source) {

		if (source == null) {
			throw new IllegalArgumentException("Source was null");
		}

		boolean canHeal = (Math.random() <= source.getChanceToHeal()) && (source.getHitPoints() > 0);
		int healPoints = 0;

		if (canHeal) {
			healPoints = (int) (Math.random() * (source.getMaxHeal() - source.getMinHeal() + 1)) + source.getMinHeal();
			source.addHitPoints(healPoints);
			System.out.println(source.getName() + " healed itself for " + healPoints + " points.\n"
					+ "Total hit points remaining are: " + source.getHitPoints());
			System.out.println();
		}
	}

}
