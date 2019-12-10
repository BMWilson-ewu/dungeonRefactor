package dungeon;

import entities.Hero;

public interface Trap extends RoomItem {

	public String trigger(Hero hero);

	public String interact(Hero hero);

	public String getAbbreviation();

	public String geyKeyword();

}
