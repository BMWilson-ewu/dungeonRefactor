package common;

import heros.Hero;
import monsters.Monster;

public class Dungeon {

	private static Hero theHero;
	private static Monster theMonster;
	private static Dialog dialog;

	public static void main(String[] args) {

		dialog = new Dialog();

		do {
			theHero = dialog.chooseHero();
			theMonster = dialog.generateMonster();
			battle(theHero, theMonster);

		} while (dialog.playAgain());

	}

	private static boolean areAlive() {
		return theHero.isAlive() && theMonster.isAlive();
	}

	private static void battle(Hero theHero, Monster theMonster) {

		dialog.battleStartDetails(theHero, theMonster);

		do {
			dialog.numberOfTurns(theHero, theMonster);
			do {
				heroAttack();
				if (areAlive()) {
					monsterAttack();
				}
			} while (areAlive());

		} while (areAlive() && dialog.displayQuitButton());

		dialog.displayBattleResults(theHero, theMonster);

	}

	private static void monsterAttack() {
		dialog.displayMonsterAttackResults(theHero, theMonster);
		dialog.displayMonsterHealResults(theHero, theMonster);
	}

	private static void heroAttack() {
		int choice = 0;
		do {
			choice = dialog.displayHeroChoices(theHero, theMonster);

			switch (choice) {
			case 1:
				dialog.displayHeroAttackResults(theHero, theMonster);
				break;
			case 2:
				dialog.displayHeroSpecialAttackResults(theHero, theMonster);
				break;
			default:
				throw new IllegalArgumentException("Attack choice is not valid.");
			}

			theHero.decrementTurnCount();
		} while (areAlive() && theHero.getTurns() > 0);
	}

}