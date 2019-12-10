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
import items.PillarItem;
import items.RoomItem;

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
	
	
	
	public static void main(String[] args) {

		Hero theHero;
		Monster theMonster;
		Scanner kin = new Scanner(System.in);
		
		//DungeonAdventure.Intro();
		//System.out.println();
		do {
			theHero = chooseHero(kin);
			theMonster = generateMonster();
			battle(theHero, theMonster, kin);

		} while (playAgain(kin));

	}

	private static Hero chooseHero(Scanner kin) {
		int choice = 0;
		HeroFactory h = new HeroFactory();
		Hero toRet;

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief\n" + "4. Paladin\n" +"5. Ranger");
		try {
			choice = kin.nextInt();
		} catch (InputMismatchException e) {
			kin.nextLine();
			choice = 0;
		}

		if (choice == 1) {
			toRet = h.createHero(Heros.Warrior);
		} else if (choice == 2) {
			toRet = h.createHero(Heros.Sorceress);
		} else if (choice == 3) {
			toRet = h.createHero(Heros.Thief);
		} else if(choice == 4) {
			toRet = h.createHero(Heros.Paladin);
		} else if(choice == 5) {
			toRet = h.createHero(Heros.Ranger);
		} else if(choice == 32301) {
			toRet = h.createHero(Heros.Floridaman);
		}else {
			System.out.println("Invalid entry. Please enter an integer 1 through 3...");
			return chooseHero(kin);
		}
		kin.nextLine();

		toRet.readName(kin);

		return toRet;
	}

	private static Monster generateMonster() {
		int choice;
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
			System.out.println("invalid choice, returning Skeleton");
			return m.createMonster(Monsters.Skeleton);
		}
	}

	private static boolean playAgain(Scanner kin) {
		String again;

		System.out.println("Play again (y/n)?");
		again = kin.nextLine();

		return (again.equals("Y") || again.equals("y"));
	}

	private static void battle(Hero theHero, Monster theMonster, Scanner kin) {
		String pause = "p";
		System.out.println(theHero.getName() + " battles " + theMonster.getName());
		System.out.println("---------------------------------------------");

		do {

			int turns = theHero.getAttackSpeed() / theMonster.getAttackSpeed();
			if (turns == 0) {
				turns = 1;
			}
			theHero.setTurns(turns);

			while (theHero.getTurns() > 0 && theMonster.isAlive()) {
				int option = 0;
				System.out.println("1. Attack Opponent");
				System.out.println("2. " + theHero.readSpecial());
				System.out.print("Choose an option: ");
				try {
					option = kin.nextInt();
				} catch (InputMismatchException e) {
					kin.nextLine();
					option = 0;
				}

				if (option == 1) {
					AttackPool.getInstanceOf().getbasicAttack().attack(theHero, theMonster);
				} else if (option == 2) {
					theHero.special(theMonster);
				} else {
					System.out.println("Invalid input...");
					theHero.setTurns(theHero.getTurns() + 1);
				}

				theHero.setTurns(theHero.getTurns() - 1);

			}
			kin.nextLine();

			if (theMonster.isAlive()) {
				AttackPool.getInstanceOf().getbasicAttack().attack(theMonster, theHero);

				System.out.print("\n-->q to quit, anything else to continue: ");
				pause = kin.nextLine();

			}

		} while (theHero.isAlive() && theMonster.isAlive() && !pause.equals("q"));

		if (!theMonster.isAlive()) 
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");

	}
	
	private ArrayList<Monster> generateMonsterList(int num){
		ArrayList<Monster> group = new ArrayList<Monster>();
		for(int i = 0; i < num; i++) {
			group.add(generateMonster());
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