package common;

import builders.HeroFactory;
import builders.MonsterFactory;
import heros.Hero;
import heros.HeroType;
import monsters.Monster;
import monsters.MonsterType;

public class Dungeon {

	public static void main(String[] args) {

		Hero theHero;
		Monster theMonster;
		Dialog dialog = new Dialog();

		do {
			theHero = chooseHero();
			theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

	}
	
	private static Hero chooseHero() {

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");
		int choice = Keyboard.readInt();


		return new HeroFactory().createHero(choice);

	}

	private static Monster generateMonster() {

		int choice = (int) (Math.random() * 3) + 1;

		return new MonsterFactory().createMonster(choice);
	}
	
	private static boolean playAgain() {
		char again; // assign a value, "" for blank

		System.out.println("Play again (y/n)?");

		// Maybe pass in a scanner instead. TBD
		again = Keyboard.readChar();

		// Before validation use .toUpperCase() or .toLowerCase()
		return (again == 'Y' || again == 'y');
	}// end playAgain method

	/*-------------------------------------------------------------------
	battle is the actual combat portion of the game.  It requires a Hero
	and a Monster to be passed in.  Battle occurs in rounds.  The Hero
	goes first, then the Monster.  At the conclusion of each round, the
	user has the option of quitting.
	---------------------------------------------------------------------*/
	private static void battle(Hero theHero, Monster theMonster) {

		// Start Battle
		System.out.println(theHero.getName() + " battles " + theMonster.getName());
		System.out.println("---------------------------------------------\n");

		// Battle Loop
		// Add a check to see if user wants to quit the game
		while (areAlive(theHero, theMonster)) {

			System.out.println("Number of turns this round is: " + theHero.determinTurns(theMonster));

			// monster's turn (provided it's still alive!)
			do {
				heroAttack(theHero, theMonster);
				if (areAlive(theHero, theMonster)) {
					monsterAttack(theHero, theMonster);
				}
			} while (areAlive(theHero, theMonster));

			if (theMonster.isAlive())
				theMonster.attack(theHero);

			// let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");

		} // end Battle Loop

		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else// both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}// end battle method

	private static boolean areAlive(Hero theHero, Monster theMonster) {
		return theHero.isAlive() && theMonster.isAlive();
	}

	private static void monsterAttack(Hero theHero, Monster theMonster) {

		MonsterType monsterType = theMonster.getType();

		displayMonsterAttackResults(monsterType, theMonster.attack(theHero), theHero, theMonster);
		displayMonsterHealResults(monsterType, theMonster.heal(), theHero, theMonster);

	}

	private static void displayMonsterAttackResults(MonsterType monsterType, AttackResult attackDetails, Hero theHero,
			Monster theMonster) {

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

	private static void displayMonsterHealResults(MonsterType monsterType, AttackResult healDetails, Hero theHero,
			Monster theMonster) {
		if (healDetails.getCouldAttack()) {
			System.out.println(theMonster.getName() + " healed itself for " + healDetails.getDamageDone() + " points.\n"
					+ "Total hit points remaining are: " + theMonster.getHitPoints() + "\n");
		}
	}

	private static void heroAttack(Hero theHero, Monster theMonster) {

		HeroType heroType = theHero.getType();

		int choice = 0;

		do {

			System.out.println("1. Attack Opponent");
			displaySpecial(heroType);
			System.out.print("Choose an option: ");

			choice = Keyboard.readInt();
			// surround with try catch

			switch (choice) {
			case 1:
				displayHeroAttackResults(heroType, theHero.attack(theMonster), theHero, theMonster);
				break;
			case 2:
				displayHeroSpecialAttackResults(heroType, theHero.specialAttack(theMonster), theHero, theMonster);
				break;
			default:
				System.out.println("invalid choice!");
				// get rid of default system.out.println or replace with exception
			}// end switch

			theHero.decrementTurnCount();
		} while (areAlive(theHero, theMonster) && theHero.getTurns() > 0);
	}

	private static void displaySpecial(HeroType heroType) {
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

	private static void displayHeroAttackResults(HeroType heroType, AttackResult attackDetails, Hero theHero,
			Monster theMonster) {

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

	private static void displayHeroSpecialAttackResults(HeroType heroType, AttackResult attackDetails, Hero theHero,
			Monster theMonster) {
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
				AttackResult morphDetails = new AttackResult(attackDetails.getDamageDone(), true);
				displayHeroAttackResults(heroType, morphDetails, theHero, theMonster);
			}
			break;
		case SORCERESS:
			System.out.println(theHero.getName() + " added [" + attackDetails.getDamageDone() + "] points.\n"
					+ "Total hit points remaining are: " + theHero.getHitPoints() + "\n");
			break;
		}
	}

}// end Dungeon class