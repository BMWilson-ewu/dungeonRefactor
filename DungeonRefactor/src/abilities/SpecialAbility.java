package abilities;

import entities.DungeonCharacter;
import enums.Abilities;

public interface SpecialAbility {
	public void special(DungeonCharacter source, DungeonCharacter target);

	public String specialDesc();

	public Abilities getKey();
}
