package dungeon;
import entities.Hero;

public class Entrance implements RoomItem {
	public String interact(Hero h) {
		return "The collapsed entrance " + h.getName() + " came in from. It seems turning back " +
				"is impossible...";
	}
	public String getAbbreviation() {
		return "I";
	}
}
