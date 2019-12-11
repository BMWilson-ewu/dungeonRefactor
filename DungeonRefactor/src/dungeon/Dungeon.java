package dungeon;

import java.io.Serializable;
import java.util.*;

import entities.Hero;
import entities.Monster;
import entities.MonsterFactory;
import enums.Items;
import enums.Monsters;

public class Dungeon implements Serializable {

	private static final long serialVersionUID = 4374465783899583065L;
	private Room[][] dungeonArray;

	public Dungeon(int x, int y, int monsters) {
		generateDungeon(x, y);
		populateUniqueItems(x, y);
		populateMonsters(x, y, monsters);
		populateRoomItems(x, y);
	}

	private void generateDungeon(int x, int y) {
		this.dungeonArray = new Room[y][x];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				dungeonArray[i][j] = new Room();
			}
		}
	}

	private void populateUniqueItems(int x, int y) {
		ArrayList<Items> unique = generateUniques();
		for (Items item : unique) {
			boolean placed = false;
			while (!placed) {
				int roomY = (int) (Math.random() * y);
				int roomX = (int) (Math.random() * x);
				if (placed = !this.dungeonArray[roomY][roomX].hasUniqueItem()) {
					this.dungeonArray[roomY][roomX].setUnique(item);
				}
			}
		}
	}

	private void populateMonsters(int x, int y, int monsters) {
		ArrayList<Monster> mon = generateMonsterList(monsters);
		for (Monster m : mon) {
			boolean placed = false;
			while (!placed) {
				int roomY = (int) (Math.random() * y);
				int roomX = (int) (Math.random() * x);
				if (placed = !this.dungeonArray[roomY][roomX].hasMonster()) {
					this.dungeonArray[roomY][roomX].setMonster(m);
				}
			}
		}
	}

	private void populateRoomItems(int x, int y) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				dungeonArray[i][j].populateRoomItems(dungeonArray, x, y);
			}
		}
	}

	private static Monster generateMonster() {
		int choice = 0;
		MonsterFactory m = new MonsterFactory();

		choice = (int) (Math.random() * 5) + 1;

		switch (choice) {
		case 1:
			return m.createMonster(Monsters.Ogre);

		case 2:
			return m.createMonster(Monsters.Gremlin);

		case 3:
			return m.createMonster(Monsters.Skeleton);

		case 4:
			return m.createMonster(Monsters.Minotuar);

		case 5:
			return m.createMonster(Monsters.Bugbear);

		default:

			throw new IllegalArgumentException("Random Object generated a unexpected value of " + choice + ".");

		}
	}

	private ArrayList<Monster> generateMonsterList(int num) {
		ArrayList<Monster> group = new ArrayList<Monster>();
		for (int i = 0; i < num; i++) {
			group.add(generateMonster());
		}
		return group;
	}

	private ArrayList<Items> generateUniques() {
		ArrayList<Items> items = new ArrayList<Items>();
		items.add(Items.Entrance);
		items.add(Items.Exit);
		items.add(Items.PillarOfAbstraction);
		items.add(Items.PillarOfEncapsulation);
		items.add(Items.PillarOfInheritance);
		items.add(Items.PillarOfPolymorphism);
		return items;
	}
	
	public Room moveHero(Hero h, String s) {
		
		int heroX = h.getX();
		int heroY = h.getY();
		Room curRoom = dungeonArray[heroY][heroX];
		Room nextRoom = new Room();
		
		try {
			switch(s) {
			case("North"):
				heroY = heroY - 1;
				nextRoom = dungeonArray[heroY][heroX];
				break;
			case("South"):
				heroY = heroY + 1;
				nextRoom = dungeonArray[heroY][heroX];
				break;
			case("East"):
				heroX = heroX + 1;
				nextRoom = dungeonArray[heroY][heroX];
				break;
			case("West"):
				heroX = heroX - 1;
				nextRoom = dungeonArray[heroY][heroX];
				break;
			}
			h.setX(heroX);
			h.setY(heroY);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(h.getName() + " cannot move " + s);
			return curRoom;
		}
		
		return nextRoom;
	}
	
	public String displayVision(Hero h) {
		String output = "";
		
		for(int i = h.getY() - 1; i <= h.getY() + 1; i++) { 
			for(int j = 0; j <3; j++) { 
				for(int k = h.getX() - 1; k <= h.getX() + 1; k++) { 
					try {
						if(j == 0) { output += dungeonArray[i][k].getTop() + " ";
						} else if(j == 1) {
							output += dungeonArray[i][k].getMid() + " "; 
						} else if(j == 2) { 
							output += dungeonArray[i][k].getBot() + " "; 
						} 
					} catch(ArrayIndexOutOfBoundsException e) {
						output += "* * * "; 
					} 
					
				} output += "\n"; 		
			} 	
		} 
		
		return output;
	}
	
	public String toString() {
		String dungeonString = "";
		for (int i = 0; i < dungeonArray.length; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < dungeonArray[0].length; k++) {
					if (j == 0) {
						dungeonString += dungeonArray[i][k].getTop() + " ";
					} else if (j == 1) {
						dungeonString += dungeonArray[i][k].getMid() + " ";
					} else if (j == 2) {
						dungeonString += dungeonArray[i][k].getBot() + " ";
					}
				}
				dungeonString += "\n";
			}
		}
		return dungeonString;
	}

}