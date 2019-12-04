package dungeon;
import entities.Hero;

public class Exit implements RoomItem {
	public String interact(Hero h) {
		if(h.getNumPillars() < 4) {
			return "The sealed exit! " + h.getName() + " may only leave once they possess " +
					"all four pillars of OO.";
		} else {
			return h.getName() + " has brought all four pillars to the exit!";
		}
	}
	public String getAbbreviation() {
		return "O";
	}
}
