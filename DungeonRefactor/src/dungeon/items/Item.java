package dungeon.items;

import dungeon.entities.Hero;
import dungeon.enums.Items;

public interface Item {

	public String trigger(Hero hero);

	public String interact(Hero hero);

	public String getAbbreviation();

	public Items getKey();

}
