package dungeon;
import java.util.*;

import entities.Hero;
import entities.HeroFactory;
import entities.Monster;
import entities.MonsterFactory;

public class Dungeon {
	public static void main(String[] args) {

		Hero theHero;
		Monster theMonster;
		Scanner kin = new Scanner(System.in);

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

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");
		try {
			choice = kin.nextInt();
		} catch (InputMismatchException e) {
			kin.nextLine();
			choice = 0;
		}

		if (choice == 1) {
			toRet = h.createHero("Warrior");
		} else if (choice == 2) {
			toRet = h.createHero("Sorceress");
		} else if (choice == 3) {
			toRet = h.createHero("Thief");
		} else {
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

		choice = (int) (Math.random() * 3) + 1;

		switch (choice) {
		case 1:
			return m.createMonster("Ogre");

		case 2:
			return m.createMonster("Gremlin");

		case 3:
			return m.createMonster("Skeleton");

		default:
			System.out.println("invalid choice, returning Skeleton");
			return m.createMonster("Skeleton");
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
					theHero.attack(theMonster);
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
				theMonster.attack(theHero);

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

}