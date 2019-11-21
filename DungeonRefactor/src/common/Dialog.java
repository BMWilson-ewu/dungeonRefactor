package common;

import java.util.Scanner;

import builders.HeroFactory;
import builders.MonsterFactory;
import heros.Hero;
import heros.HeroType;
import monsters.Monster;
import monsters.MonsterType;

public class Dialog {

	Scanner kb = new Scanner(System.in);

	String chooseName() {
		String name = "";

		do {
			try {
				name = kb.nextLine();
			} catch (Exception e) {
				name = "";
			}
		} while (name.equals(""));
		return name;
	}

	Hero chooseHero() {

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");
		int choice = Keyboard.readInt();

		return new HeroFactory().createHero(choice);

	}

	Monster generateMonster() {

		int choice = (int) (Math.random() * 3) + 1;

		return new MonsterFactory().createMonster(choice);
	}

	void battleStartDetails(Hero theHero, Monster theMonster) {
		System.out.println(theHero.getName() + " battles " + theMonster.getName());
		System.out.println("---------------------------------------------\n");
	}

	void numberOfTurns(Hero theHero, Monster theMonster) {
		System.out.println("Number of turns this round is: " + theHero.determinTurns(theMonster));
	}

	void displayBattleResults(Hero theHero, Monster theMonster) {
		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else
			System.out.println("Quitters never win ;-)");
	}

	boolean playAgain() {
		String input = "";
		System.out.println("Play again (y/n)?");
		try {
			input = kb.nextLine();
		} catch (Exception e) {
			input = "";
			System.out.println("Please don't break the program.");
		}
		return (input.toLowerCase()).contentEquals("y");
	}

	boolean displayQuitButton() {
		String input = "";
		System.out.print("\n-->q to quit, anything else to continue: ");

		try {
			input = kb.nextLine();
		} catch (Exception e) {
			input = "";
			System.out.println("Please don't break the program.");
		}
		return (input.toLowerCase()).contentEquals("q");
	}

	void displayMonsterAttackResults(Hero theHero, Monster theMonster) {
		MonsterType monsterType = theMonster.getType();
		AttackResult attackDetails = theMonster.attack(theHero);
		switch (monsterType) {
		case GREMLIN:
			System.out.println(theMonster.getName() + " jabs his kris at " + theHero.getName() + ":");
			break;
		case OGRE:
			System.out.println(theMonster.getName() + " slowly swings a club toward's " + theHero.getName() + ":");
			break;
		case SKELETON:
			System.out.println(theMonster.getName() + " slices his rusty blade at " + theHero.getName() + ":");
			break;
		}
		if (attackDetails.getCouldAttack()) {
			System.out.println(
					theMonster.getName() + " hit " + " for <" + attackDetails.getDamageDone() + "> points of damage.");
			System.out.println(theHero.getName() + " now has " + theHero.getHitPoints() + " hit points remaining.");
		} else {
			System.out.println(theMonster.getName() + "'s attack on " + theHero.getName() + " failed!\n");
		}

	}

	void displayMonsterHealResults(Hero theHero, Monster theMonster) {
		AttackResult healDetails = theMonster.heal();
		if (healDetails.getCouldAttack()) {
			System.out.println(theMonster.getName() + " healed itself for " + healDetails.getDamageDone() + " points.\n"
					+ "Total hit points remaining are: " + theMonster.getHitPoints() + "\n");
		}
	}

	int displayHeroChoices(Hero theHero, Monster theMonster) {

		System.out.println("1. Attack Opponent");
		displaySpecial(theHero);
		System.out.print("Choose an option: ");

		int choice;

		do {
			try {
				choice = kb.nextInt();
			} catch (Exception e) {
				choice = 0;
				System.out.println("Please enter a valid option.");
			}
		} while (choice < 1 || choice > 2);
		return choice;
	}

	private void displaySpecial(Hero theHero) {
		HeroType heroType = theHero.getType();

		switch (heroType) {
		case WARRIOR:
			System.out.println("2. Crushing Blow on Opponent");
			break;
		case THIEF:
			System.out.println("2. Surprise Attack");
			break;
		case SORCERESS:
			System.out.println("2. Increase Hit Points");
			break;
		}
	}

	void displayHeroAttackResults(Hero theHero, Monster theMonster) {
		HeroType heroType = theHero.getType();
		AttackResult attackDetails = theHero.attack(theMonster);

		switch (heroType) {
		case WARRIOR:
			System.out.println(theHero.getName() + " swings a mighty sword at " + theMonster.getName() + ":");
			break;
		case THIEF:
			// TODO What should we add for the thiefs basic attack
			break;
		case SORCERESS:
			System.out.println(theHero.getName() + " casts a spell of fireball at " + theMonster.getName() + ":");
			break;
		}
		if (attackDetails.getCouldAttack()) {
			System.out.println(
					theHero.getName() + " hit " + " for <" + attackDetails.getDamageDone() + "> points of damage.");
		} else {
			System.out.println(theHero.getName() + "'s attack on " + theMonster.getName() + " failed!\n");
		}

	}

	void displayHeroSpecialAttackResults(Hero theHero, Monster theMonster) {
		HeroType heroType = theHero.getType();
		AttackResult attackDetails = theHero.specialAttack(theMonster);
		switch (heroType) {
		case WARRIOR:
			if (attackDetails.getCouldAttack()) {
				System.out.println(
						theHero.getName() + " lands a CRUSHING BLOW for " + attackDetails.getDamageDone() + " damage!");
			} else {
				System.out.println(theHero.getName() + " failed to land a crushing blow.\n");
			}
			break;
		case THIEF:
			if (attackDetails.getCouldAttack()) {
				System.out
						.println("Surprise attack was successful!\n" + theHero.getName() + " gets an additional turn.");
			} else if (attackDetails.getDamageDone() < 0) {
				System.out.println("Uh oh! " + theMonster.getName() + " saw you and" + " blocked your attack!");
			} else {
				displayHeroAttackResults(theHero, theMonster);
			}
			break;
		case SORCERESS:
			System.out.println(theHero.getName() + " added [" + attackDetails.getDamageDone() + "] points.\n"
					+ "Total hit points remaining are: " + theHero.getHitPoints() + "\n");
			break;
		}
	}

}
