package dungeon;
import entities.Hero;

public interface RoomItem {
	public String interact(Hero h);
	public String getAbbreviation();
}
