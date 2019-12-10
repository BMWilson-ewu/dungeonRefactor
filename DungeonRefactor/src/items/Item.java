package items;

import entities.Hero;
import enums.Items;

public interface Item {

	public String trigger(Hero hero);

	public String interact(Hero hero);

	public String getAbbreviation();

	public Items getKey();

}
