package dungeon;

import entities.Hero;

public class VisionPot implements RoomItem {

	@Override
	public String interact(Hero h) {
		// TODO Auto-generated method stub
		h.addVisionPot(new VisionPot());
		return h.getName() + " picked up a vision potion";
	}

	@Override
	public String getAbbreviation() {
		// TODO Auto-generated method stub
		return "V";
	}
	
	public String consume(Hero h, Room[][] dungeon) {
		String output = "";
		
		for(int i = h.getY() - 1; i <= h.getY() + 1; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = h.getX() - 1; k <= h.getX() + 1; k++) {
					try {
						if(j == 0) {
							output += dungeon[i][k].getTop() + " ";
						} else if(j == 1) {
							output += dungeon[i][k].getMid() + " ";
						} else if(j == 2) {
							output += dungeon[i][k].getBot() + " ";
						}
					} catch(ArrayIndexOutOfBoundsException e) {
						output += "* * * ";
					}
				}
				output += "\n";
			}
		}
		
		return output;
	}
}
