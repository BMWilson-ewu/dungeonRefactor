package dungeon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import abilities.AttackPool;
import entities.Hero;
import entities.HeroFactory;
import entities.Monster;
import enums.Heros;
import enums.Items;

//During the process of developing this project, our group has been highly cooperative. General
//responsibilities are outlined here:
//Hunter Rich: Lead on unit tests, memento, and enumeration
//Bryan Wilson: Lead on Room and Dungeon design, and general item behaviors
//Justin Entz: Lead on addition of new hero and monster types, and design of DungeonAdventure

public class DungeonAdventure {

	public static void main(String[] args) {
		Scanner kin = new Scanner(System.in);
		boolean cont = false;
		
		
		do {
			Dungeon theDungeon = new Dungeon(5, 5, 5);

			Intro();
			System.out.println();

			Hero theHero = chooseHero(kin);
			Room curRoom = theDungeon.manageEntrance(theHero);

			do {

				if (curRoom.hasMonster()) {
					Monster theMonster = curRoom.getMonster();
					battle(theHero, theMonster, kin);
				}
				
				System.out.println(curRoom.toString());
				
				if (theHero.isAlive()) {
					if (curRoom.hasUniqueItem()) {
						Items uniqueItem = curRoom.getUniqueItem();
						System.out.println(AttackPool.getInstanceOf().getItem(uniqueItem).trigger(theHero));
						System.out.println(AttackPool.getInstanceOf().getItem(uniqueItem).interact(theHero));
					}

					if (curRoom.hasItems()) {
						ArrayList<Items> curRoomItems = curRoom.getItems();
						for (Items i : curRoomItems) {
							System.out.println(AttackPool.getInstanceOf().getItem(i).trigger(theHero));
							if (i == Items.Pit) {
								System.out.println(AttackPool.getInstanceOf().getItem(i).interact(theHero));
							}
						}
						curRoom.clearItems();
					}

					System.out.println(theHero.toString());

					int act = chooseAction(kin);
					curRoom = executeAction(act, theHero, theDungeon, curRoom);

				}
			} while (theHero.isAlive() && (theHero.getNumPillars() != 4 || curRoom.getUniqueItem() != Items.Exit));

			if (theHero.isAlive()) {
				Items uniqueItem = curRoom.getUniqueItem();
				System.out.println(AttackPool.getInstanceOf().getItem(uniqueItem).trigger(theHero));
				System.out.println(AttackPool.getInstanceOf().getItem(uniqueItem).interact(theHero));
				Victory();
			} else {
				System.out.println("The hero has been defeated!");
			}
			kin.nextLine();
			cont = playAgain(kin);
		} while (cont);

	}

	private static int chooseAction(Scanner yeet) {
		//Secret key to display whole dungeon: 627
		int action = 0;
		do {
			System.out.println("What do you want to do?\n" + 
					"1. Move North\n" + 
					"2. Move East\n" + 
					"3. Move South\n"+ 
					"4. Move West\n" + 
					"5. Use Healing potion\n" + 
					"6. Use Vision potion\n" + 
					"7. Save\n"+ 
					"8. Load\n");
			try {
				action = yeet.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter valid number(1-8)");
			}
		} while ((action < 0 || action > 8) && action != 627);

		return action;
	}

	private static Room executeAction(int d, Hero theHero, Dungeon theDungeon, Room curRoom) {
		switch (d) {
		case 1:
			return curRoom = theDungeon.moveHero(theHero, "North");

		case 2:
			return curRoom = theDungeon.moveHero(theHero, "East");

		case 3:
			return curRoom = theDungeon.moveHero(theHero, "South");

		case 4:
			return curRoom = theDungeon.moveHero(theHero, "West");

		case 5:
			theHero.consumeHeal();
			return curRoom;

		case 6:
			theHero.consumeVision();
			System.out.println(theDungeon.displayVision(theHero));
			return curRoom;

		case 7:
			try {
				saveState(theDungeon, curRoom, theHero);
			} catch(IOException e) {
				System.out.println("Could not save dungeon state...");
				e.printStackTrace();
			}
			return curRoom;

		case 8:
			try {
				ArrayList<Object> saves = loadSerializedFile();
				theDungeon.setDungeon((Dungeon)saves.get(0));
				curRoom.setRoom((Room)saves.get(1));
				theHero.setCharacter((Hero)saves.get(2));
			} catch(Exception e) {
				System.out.println("Could not load dungeon state...");
				e.printStackTrace();
			}
			return curRoom;
		case 627:
			System.out.println(theDungeon.toString());
			return curRoom;
		default:
			throw new IllegalArgumentException("Invalid Action");
		}
	}

	private static Hero chooseHero(Scanner kin) {
		int choice = 0;
		HeroFactory h = new HeroFactory();
		Hero toRet;

		System.out.println(
				"Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief\n" + "4. Paladin\n" + "5. Ranger");
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
		} else if (choice == 4) {
			toRet = h.createHero(Heros.Paladin);
		} else if (choice == 5) {
			toRet = h.createHero(Heros.Ranger);
		} else if (choice == 32301) {
			toRet = h.createHero(Heros.Floridaman);
		} else {
			kin.nextLine();
			System.out.println("Invalid entry. Please enter an integer 1 through 5...");
			return chooseHero(kin);
		}
		kin.nextLine();

		toRet.readName(kin);

		return toRet;
	}

	private static void battle(Hero theHero, Monster theMonster, Scanner kin) {
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

			}

		} while (theHero.isAlive() && theMonster.isAlive());

		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");

	}

	private static boolean playAgain(Scanner kin) {
		String again;

		System.out.println("Play again (y/n)?");
		again = kin.nextLine();

		return (again.equals("Y") || again.equals("y"));
	}

	private static void Intro() {
		System.out.println("------Welcome Adventurer!------");
		System.out.println("You have answered a quest for the promise of adventure and LOOT upon "
				+ "exploring a mysterious cave.\nAs you reach the cave you find a sign posted at the entrance, it reads: "
				+ "\n\n"
				+ "\"Adventurers and Heroes complete the dungeon inside here by collecting the four pillars of OO."
				+ "\nBeware many obstacles will be in your way, \r\n"
				+ "some helpful items can also be found to keep you alive.\"");
	}

	private static void Victory() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Congratulations by collecting the four pillars of OO!");
		System.out.println("Your Prize is: ");
		System.out.println("50 gold pieces");
	}
	
	@SuppressWarnings("unchecked")
	private static final ArrayList<Object> loadSerializedFile() throws IOException, ClassNotFoundException {
		ArrayList<Object> itemsToLoad = new ArrayList<Object>();
		try {
			File saveFile = new File("./saveGame");
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(saveFile));
			itemsToLoad = (ArrayList<Object>) in.readObject();
			in.close();
			System.out.println("Adventure loaded!");
		} catch(IOException e) {
			e.printStackTrace();
		}
		return itemsToLoad;
	}

	private static final void saveState(Dungeon dungeon, Room currentRoom, Hero hero) throws IOException {
		ArrayList<Object> itemsToSave = new ArrayList<Object>();
		itemsToSave.add(dungeon);
		itemsToSave.add(currentRoom);
		itemsToSave.add(hero);
		try {
			File saveFile = new File("./saveGame");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
			out.writeObject(itemsToSave);
			out.close();
			System.out.println("Adventure saved!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
