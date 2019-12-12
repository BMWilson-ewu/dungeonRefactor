package dungeon.abilities;

import dungeon.entities.DungeonCharacter;
import dungeon.enums.Abilities;

public class HeroHeal implements SpecialAbility {

	public void special(DungeonCharacter source, DungeonCharacter target) {
		
		if (source == null) {
			throw new IllegalArgumentException("Atacker passed was null.");
		} else if (target == null) {
			throw new IllegalArgumentException("Defender passed was null.");
		}
		
		int hPoints;

		hPoints = (int) (Math.random() * (50 - 25 + 1)) + 25;
		source.addHitPoints(hPoints);
		System.out.println(source.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: "
				+ source.getHitPoints());
		System.out.println(target.getName() + " disliked that!");
		System.out.println();
	}

	public String specialDesc() {
		return "Heal Self";
	}

	public Abilities getKey() {
		return Abilities.HeroHeal;
	}

}
