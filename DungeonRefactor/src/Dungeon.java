import java.util.*;

/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */



/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{
    public static void main(String[] args)
	{

		Hero theHero;
		Monster theMonster;
		Scanner kin = new Scanner(System.in);

		do
		{
		    theHero = chooseHero(kin);
		    theMonster = generateMonster();
			battle(theHero, theMonster, kin);

		} while (playAgain(kin));

    }//end main method

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
	//Removed useless hero reference
    //Added scanner to the parms to use instead of Keyboard object w/ try-catch for input
    //Changed switch to conditional block
    public static Hero chooseHero(Scanner kin)
	{
		int choice = 0;
		HeroFactory h = new HeroFactory();
		Hero toRet;

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		try {
			choice = kin.nextInt();
		} catch (InputMismatchException e) {
			kin.nextLine();
			choice = 0;
			//System.out.println("Invalid input, please enter an integer...");
		}

		if(choice == 1) {
			toRet = h.createHero("Warrior");
		} else if(choice == 2) {
			toRet = h.createHero("Sorceress");
		} else if(choice == 3) {
			toRet = h.createHero("Thief");
		} else {
			System.out.println("Invalid entry. Please enter an integer 1 through 3...");
			return chooseHero(kin);
		}
		kin.nextLine();
		
		toRet.readName(kin);
		
		return toRet;
		
		
		/*switch(choice)
		{
			case 1: return new Warrior();

			case 2: return new Sorceress();

			case 3: return new Thief();

			default: System.out.println("invalid choice, returning Thief");
				     return new Thief();
		}//end switch*/
	}//end chooseHero method

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
	public static Monster generateMonster()
	{
		int choice;
		MonsterFactory m = new MonsterFactory();

		choice = (int)(Math.random() * 3) + 1;

		switch(choice)
		{
			case 1: return m.createMonster("Ogre");

			case 2: return m.createMonster("Gremlin");

			case 3: return m.createMonster("Skeleton");

			default: System.out.println("invalid choice, returning Skeleton");
				     return m.createMonster("Skeleton");
		}//end switch
	}//end generateMonster method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain(Scanner kin)
	{
		String again;

		System.out.println("Play again (y/n)?");
		again = kin.nextLine();

		return (again.equals("Y") || again.equals("y"));
	}//end playAgain method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster, Scanner kin)
	{
		String pause = "p";
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		do {
			 /*//hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);
			*/
			
			//Intended battle loop
			int turns = theHero.getAttackSpeed()/theMonster.getAttackSpeed();
			if(turns == 0) {
				turns = 1;
			}
			theHero.setTurns(turns);
			
			//start hero phase
			while(theHero.getTurns() > 0 && theMonster.isAlive()) {
				int option = 0;
				System.out.println("1. Attack Opponent");
			    System.out.println("2. " + theHero.readSpecial());
			    System.out.print("Choose an option: ");
			    try {
			    	option = kin.nextInt();
			    } catch (InputMismatchException e){
			    	kin.nextLine();
			    	option = 0;
			    }
			    
			    if(option == 1) {
			    	theHero.attack(theMonster);
			    } else if(option == 2) {
			    	theHero.special(theMonster);
			    } else {
			    	System.out.println("Invalid input...");
			    	theHero.setTurns(theHero.getTurns() + 1);
			    }
			    
			    theHero.setTurns(theHero.getTurns() - 1);
			    
			}//end hero phase
			kin.nextLine();
			
			//start monster phase
			if(theMonster.isAlive()) {
				theMonster.attack(theHero);
				
				//let the player bail out if desired
				System.out.print("\n-->q to quit, anything else to continue: ");
				pause = kin.nextLine();
				
			}//end monster phase
			
			

		
		} while (theHero.isAlive() && theMonster.isAlive() && !pause.equals("q"));//end battle loop
		
		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");
		   

	}//end battle method


}//end Dungeon class