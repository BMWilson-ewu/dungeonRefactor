package dungeon.abilities;

import dungeon.entities.DungeonCharacter;
import dungeon.enums.Abilities;

public interface SpecialAbility {
	public void special(DungeonCharacter source, DungeonCharacter target);

	public String specialDesc();

	public Abilities getKey();
}
