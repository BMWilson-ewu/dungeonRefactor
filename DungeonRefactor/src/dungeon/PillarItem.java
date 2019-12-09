package dungeon;

import entities.Hero;

public class PillarItem implements RoomItem {
	
	private String name;
	
	public PillarItem(String name) {
		this.name = name;
	}

	@Override
	public String interact(Hero h) {
		h.addPillar(this);
		return h.getName() + " picked up a pillar of " + this.name + ".";
	}

	@Override
	public String getAbbreviation() {
		return "P";
	}

}
