package dungeon;

import java.util.Scanner;
import entities.Hero;
import entities.Monster;

public class DungeonAdventure {

	public static void main(String[] args) {
		Hero theHero;
		Monster theMonster;
		Scanner kin = new Scanner(System.in);
		
		Intro();
		System.out.println();
		
		do {
			theHero = Dungeon.chooseHero(kin);
			theMonster = generateMonster();
			battle(theHero, theMonster, kin);

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

}
