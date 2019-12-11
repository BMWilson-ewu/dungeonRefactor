package dungeon;

import java.util.InputMismatchException;
import java.util.Scanner;

import abilities.AttackPool;
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
			battle(theHero, kin);

		} while (playAgain(kin));

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
	
	private static boolean playAgain(Scanner kin) {
		String again;

		System.out.println("Play again (y/n)?");
		again = kin.nextLine();

		return (again.equals("Y") || again.equals("y"));
	}

	private static void battle(Hero theHero,  Scanner kin) {
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
			System.out.println("Invalid entry. Please enter an integer 1 through 5...");
			return chooseHero(kin);
		}
		kin.nextLine();

		toRet.readName(kin);

		return toRet;
	}

}
