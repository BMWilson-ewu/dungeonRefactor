package common;

import heros.Hero;
import heros.HeroType;
import heros.Sorceress;
import heros.Thief;
import heros.Warrior;
import monsters.Gremlin;
import monsters.Monster;
import monsters.Ogre;
import monsters.Skeleton;

/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright: Copyright (c) 2001 Company: Code Dogs Inc. I.M. Knurdy
 *
 * History: 11/4/2001: Wrote program --created DungeonCharacter class --created
 * Hero class --created Monster class --had Hero battle Monster --fixed attack
 * quirks (dead monster can no longer attack) --made Hero and Monster abstract
 * --created Warrior --created Ogre --made Warrior and Ogre battle --added
 * battleChoices to Hero --added special skill to Warrior --made Warrior and
 * Ogre battle --created Sorceress --created Thief --created Skeleton --created
 * Gremlin --added game play features to Dungeon.java (this file) 11/27/2001:
 * Finished documenting program version 1.0
 */

/*
 * This class is the driver file for the Heroes and Monsters project. It will do
 * the following:
 * 
 * 1. Allow the user to choose a hero 2. Randomly select a monster 3. Allow the
 * hero to battle the monster
 * 
 * Once a battle concludes, the user has the option of repeating the above
 * 
 */
public class Dungeon {

	public static void main(String[] args) {

		Hero theHero;
		Monster theMonster;

		do {
			theHero = chooseHero();
			theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

	}// end main method

	/*-------------------------------------------------------------------
	chooseHero allows the user to select a hero, creates that hero, and
	returns it.  It utilizes a polymorphic reference (Hero) to accomplish
	this task
	---------------------------------------------------------------------*/
	private static Hero chooseHero() {
		int choice;
		Hero theHero; // Never used

		System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");
		choice = Keyboard.readInt();

		// Add try catch block for input validation

		switch (choice) {
		case 1:
			return new Warrior();

		case 2:
			return new Sorceress();

		case 3:
			return new Thief();

		default:
			System.out.println("invalid choice, returning Thief");
			return new Thief();
		// No reason for default switch, use input validation instead
		}// end switch
	}// end chooseHero method

	/*-------------------------------------------------------------------
	generateMonster randomly selects a Monster and returns it.  It utilizes
	a polymorphic reference (Monster) to accomplish this task.
	---------------------------------------------------------------------*/
	private static Monster generateMonster() {
		int choice;

		// Use different library to get random Int?
		choice = (int) (Math.random() * 3) + 1;

		switch (choice) {
		case 1:
			return new Ogre();

		case 2:
			return new Gremlin();

		case 3:
			return new Skeleton();

		default:
			System.out.println("invalid choice, returning Skeleton");
			return new Skeleton();
		// No reason for the default switch
		}// end switch
	}// end generateMonster method

	/*-------------------------------------------------------------------
	playAgain allows gets choice from user to play another game.  It returns
	true if the user chooses to continue, false otherwise.
	---------------------------------------------------------------------*/
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

		// Hits opponets
		// Heros
		// Warrior

		// Thief
		// Was this shit blank?

		// Sorceress

		// Skeleton
		System.out.println(theMonster.getName() + " slices his rusty blade at " + theHero.getName() + ":");

		// Gremlin
		System.out.println(theMonster + " jabs his kris at " + theHero.getName() + ":");

		// Ogre
		System.out.println(theMonster + " slowly swings a club toward's " + theHero.getName() + ":");

	}// end battle method

	private static boolean areAlive(Hero theHero, Monster theMonster) {
		return theHero.isAlive() && theMonster.isAlive();
	}

	private void monsterAttack() {
		// if sucess
		System.out.println(getName() + " hit " + " for <" + hitPoints + "> points damage.");
		System.out.println(getName() + " now has " + getHitPoints() + " hit points remaining.");
		System.out.println();
		System.out.println();

		// if failed to attack

		System.out.println();
	}

	private static void heroAttack(Hero theHero, Monster theMonster) {

		int turns = theHero.getTurns();
		HeroType heroType = theHero.getType();
		AttackResult attackDetails;

		int choice = 0;

		do {

			System.out.println("1. Attack Opponent");
			displaySpecial(heroType);
			System.out.print("Choose an option: ");

			choice = Keyboard.readInt();

			switch (choice) {
			case 1:
				attackDetails = theHero.attack(theMonster);
				displayAttackResults(heroType, attackDetails, theHero, theMonster);
				break;
			case 2:
				attackDetails = theHero.specialAttack(theMonster);
				displaySpecialAttackResults(heroType, attackDetails, theHero, theMonster);
				break;
			default:
				System.out.println("invalid choice!");
			}// end switch

			turns--;
		} while (areAlive(theHero, theMonster) && turns > 0);
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

	private static void displayAttackResults(HeroType heroType, AttackResult attackDetails, Hero theHero,
			Monster theMonster) {
		
		if (attackDetails.getCouldAttack()) {

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
		} else {
			System.out.println(theHero.getName() + "'s attack on " + theMonster.getName() + " failed!\n");
		}

	}

	private static void displaySpecialAttackResults(HeroType heroType, AttackResult attackDetails, Hero theHero,
			Monster theMonster) {
		switch (heroType) {
		case WARRIOR:
			System.out.println(theHero.getName() + " swings a mighty sword at " + theMonster.getName() + ":");
			break;
		case THIEF:
			// What should we add for the thiefs basic attack
			break;
		case SORCERESS:
			System.out.println(theHero.getName() + " casts a spell of fireball at " + theMonster.getName() + ":");
			break;
		}
	}

}// end Dungeon class