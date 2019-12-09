package specials;
import entities.DungeonCharacter;

public class TwinStrike implements SpecialAbility{
	public void special(DungeonCharacter source, DungeonCharacter enemy) {
		double two = Math.random();
		if (two <= .4) {
			System.out.println(source.getName() + " hits twice!");
			source.attack(enemy);
			source.attack(enemy);
		} // end surprise
		else if (two >= .8) {
			System.out.println("Oh no! " + source.getName() + " missed both attacks!");
		} else {
			System.out.println(source.getName() + " hits once!");
			source.attack(enemy);
		}
			
	}

	public String specialDesc() {
		return "Twin Strike";
	}
}
