package dungeon;
import java.util.*;
import abilities.AttackPool;
import entities.Hero;
import entities.HeroFactory;
import entities.Monster;
import entities.MonsterFactory;
import enums.Heros;
import enums.Monsters;
import items.Entrance;
import items.Exit;

public class Dungeon {
	
	private Room[][] dungeonArray;
	
	public Dungeon(int x, int y, int monsters) {
		dungeonArray = new Room[y][x];
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				dungeonArray[i][j] = new Room();
			}
		}
		//populate unique items
		ArrayList<RoomItem> unique = generateUniques();
		for(RoomItem u: unique) {
			boolean placed = false;
			while(!placed) {
				int roomY = (int)(Math.random() * y);
				int roomX = (int)(Math.random() * x);
				placed = dungeonArray[roomY][roomX].setUnique(u);
			}
		}
		
		//populate monsters
		ArrayList<Monster> mon = generateMonsterList(monsters);
		for(Monster m: mon) {
			boolean placed = false;
			while(!placed) {
				int roomY = (int)(Math.random() * y);
				int roomX = (int)(Math.random() * x);
				placed = dungeonArray[roomY][roomX].setMonster(m);
			}
		}
		
		//build rooms w/ proper abbreviations
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				dungeonArray[i][j].populateRoomItems(dungeonArray, x, y);
			}
		}
	}

	private ArrayList<Monster> generateMonsterList(int num){
		ArrayList<Monster> group = new ArrayList<Monster>();
		for(int i = 0; i < num; i++) {
			group.add(DungeonAdventure.generateMonster());
		}
		return group;
	}
	
	private ArrayList<RoomItem> generateUniques(){
		ArrayList<RoomItem> items = new ArrayList<RoomItem>();
		items.add(new Entrance());
		items.add(new Exit());
		items.add(new PillarItem("Abstraction"));
		items.add(new PillarItem("Encapsulation"));
		items.add(new PillarItem("Inheritance"));
		items.add(new PillarItem("Polymorphism"));
		
		return items;
	}
	
	public String toString() {
		
		String dungeonString = "";
		for(int i = 0; i < dungeonArray.length; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < dungeonArray[0].length; k++) {
					if(j == 0) {
						dungeonString += dungeonArray[i][k].getTop() + " ";
					} else if(j == 1) {
						dungeonString += dungeonArray[i][k].getMid() + " ";
					} else if(j == 2) {
						dungeonString += dungeonArray[i][k].getBot() + " ";
					}
				}
				dungeonString += "\n";
			}
		}
		return dungeonString;
	}

}