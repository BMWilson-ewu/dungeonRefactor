package dungeon;

public class DungeonAdventure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void Intro() {
		//This is to print out the intro that i wrote make changes if you want more/less
		System.out.println("------Welcome Adventurer!------");
		System.out.println("You have answered a quest for the promise of adventure and LOOT upon "
				+ "exploring a mysterious cave.\nAs you reach the cave you find a sign posted at the entrance, it reads: " + "\n\n"
				+ "�Adventurers and Heroes complete the dungeon inside here by collecting the four pillars of OO."
				+ "\nBeware many obstacles will be in your way, \r\n" + 
				"some helpful items can also be found to keep you alive.�");
	}
	
	public static void Victory() {
		//The reward is set to one only right now since I don't know if the point system is in place or not so this is a basic victory output
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Congratulations by collecting the four pillars of OO!");
		System.out.println("Your Prize is: ");
		System.out.println("50 gold pieces");
		
		//if the point system is implemented we can do if else to check the amount of points and using a getPoints method and then reward accordingly
		/*
		 if(theHero.getPoints() > 250)
		 sysout(50 gp)
		 else if(theHero.getPoints() > 100)
		 sysout(50 sp)
		 else
		 sysout(3 copper)
		 */
	}

}