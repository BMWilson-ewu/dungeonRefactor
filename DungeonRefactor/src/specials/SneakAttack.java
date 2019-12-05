package specials;
import entities.DungeonCharacter;

public class SneakAttack implements SpecialAbility {
	public void special(DungeonCharacter source, DungeonCharacter enemy) {
		double surprise = Math.random();
		if (surprise <= .4) {
			System.out.println("Surprise attack was successful!\n" + source.getName() + " gets an additional turn.");
			source.setTurns(source.getTurns() + 1);
			source.attack(enemy);
		} // end surprise
		else if (surprise >= .9) {
			System.out.println("Uh oh! " + enemy.getName() + " saw you and" + " blocked your attack!");
		} else
			source.attack(enemy);
	}

	public String specialDesc() {
		return "Sneak Attack";
	}
}
