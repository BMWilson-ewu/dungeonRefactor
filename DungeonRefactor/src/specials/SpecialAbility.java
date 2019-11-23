package specials;
import entities.DungeonCharacter;

public interface SpecialAbility {
	public void special(DungeonCharacter source, DungeonCharacter target);

	public String specialDesc();
}
