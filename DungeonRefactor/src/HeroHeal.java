public class HeroHeal implements SpecialAbility {

	public void special(DungeonCharacter source, DungeonCharacter enemy) {
		int hPoints;

		hPoints = (int) (Math.random() * (50 - 25 + 1)) + 25;
		source.addHitPoints(hPoints);
		System.out.println(source.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: "
				+ source.getHitPoints());
		System.out.println(enemy.getName() + " disliked that!");
		System.out.println();
	}

	public String specialDesc() {
		return "Heal Self";
	}
}
