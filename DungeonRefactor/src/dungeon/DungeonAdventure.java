package dungeon;

import java.util.InputMismatchException;
import java.util.Scanner;
import entities.Hero;
import entities.HeroFactory;
import entities.Monster;
import enums.Heros;

public class DungeonAdventure {

	public static void main(String[] args) {
		Hero theHero;
		Monster theMonster;
		Scanner kin = new Scanner(System.in);
		
		Intro();
		System.out.println();
		
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
	
	public static void Intro() {
		//This is to print out the intro that i wrote make changes if you want more/less
		System.out.println("------Welcome Adventurer!------");
		System.out.println("You have answered a quest for the promise of adventure and LOOT upon "
				+ "exploring a mysterious cave.\nAs you reach the cave you find a sign posted at the entrance, it reads: " + "\n\n"
				+ "“Adventurers and Heroes complete the dungeon inside here by collecting the four pillars of OO."
				+ "\nBeware many obstacles will be in your way, \r\n" + 
				"some helpful items can also be found to keep you alive.“");
	}
	
	public static void Victory() {
		//The reward is set to one only right now since I don't know if the point system is in place or not so this is a basic victory output
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Congratulations by collecting the four pillars of OO!");
		System.out.println("Your Prize is: ");
		System.out.println("50 gold pieces");
	}

}
