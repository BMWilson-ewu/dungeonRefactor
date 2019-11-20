package common;

import java.util.Random;

/**
 * Title: DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a role playing
 * game
 *
 * class variables (all will be directly accessible from derived classes): name
 * (name of character) hitPoints (points of damage a character can take before
 * killed) attackSpeed (how fast the character can attack) chanceToHit (chance
 * an attack will strike the opponent) damageMin, damageMax (range of damage the
 * character can inflict on opponent)
 *
 * class methods (all are directly accessible by derived classes):
 * DungeonCharacter(String name, int hitPoints, int attackSpeed, double
 * chanceToHit, int damageMin, int damageMax) public String getName() public int
 * getHitPoints() public int getAttackSpeed() public void addHitPoints(int
 * hitPoints) public void subtractHitPoints(int hitPoints) -- this method will
 * be overridden public boolean isAlive() public void attack(DungeonCharacter
 * opponent) -- this method will be overridden
 *
 * Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public abstract class DungeonCharacter implements Comparable {

	protected String name;
	protected int hitPoints;
	protected int attackSpeed;
	protected double chanceToHit;
	protected int damageMin, damageMax;

	public int compareTo(Object o) {
		return 1;
	}

//-----------------------------------------------------------------
//explicit constructor to initialize instance variables -- it is called
// by derived classes
	public DungeonCharacter(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin,
			int damageMax) {

		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;

	}// end constructor

//-----------------------------------------------------------------
	public String getName() {
		return name;
	}// end getName

//-----------------------------------------------------------------
	public int getHitPoints() {
		return hitPoints;
	}// end getHitPoints
//-----------------------------------------------------------------

	public int getAttackSpeed() {
		return attackSpeed;
	}// end getAttackSpeed

	/*-------------------------------------------------------
	addHitPoints is used to increment the hitpoints a dungeon character has
	
	Receives: number of hit points to add
	Returns: nothing
	
	This method calls: nothing
	This method is called by: heal method of monsters and Sorceress
	---------------------------------------------------------*/
	public void addHitPoints(int hitPoints) {
		if (hitPoints <= 0)
			System.out.println("Hitpoint amount must be positive.");
		else {
			this.hitPoints += hitPoints;
			// System.out.println("Remaining Hit Points: " + hitPoints);

		}
	}// end addHitPoints method

	/*-------------------------------------------------------
	subtractHitPoints is used to decrement the hitpoints a dungeon character has.
	It also reports the damage and remaining hit points (these things could be
	done in separate methods to make code more modular ;-)
	
	Receives: number of hit points to subtract
	Returns: nothing
	
	This method calls: nothing
	This method is called by: overridden versions in Hero and Monster
	---------------------------------------------------------*/
	public void subtractHitPoints(int hitPoints) {
		// Why state hit points must be positive?
		if (hitPoints < 0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints > 0) {
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
		} // end else if

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");

	}// end method

	/*-------------------------------------------------------
	isAlive is used to see if a character is still alive by checking hit points
	
	Receives: nothing
	Returns: true is hero is alive, false otherwise
	
	This method calls: nothing
	This method is called by: unknown (intended for external use)
	---------------------------------------------------------*/
	public boolean isAlive() {
		return (hitPoints > 0);
	}// end isAlive method

	/*-------------------------------------------------------
	attack allows character to attempt attack on opponent.  First, chance to hit
	is considered.  If a hit can occur, then the damage is calculated based on
	character's damage range.  This damage is then applied to the opponenet.
	
	Receives: opponent being attacked
	Returns: nothing
	
	This method calls: Math.random(), subtractHitPoints()
	This method is called by: overridden versions of the method in monster and
	hero classes and externally
	---------------------------------------------------------*/

	// switch to boolean
	public AttackResult attack(DungeonCharacter opponent) {
		boolean canAttack = false;
		int damage = 0;

		Random rnjesus = new Random();

		canAttack = rnjesus.nextDouble() <= chanceToHit;

		if (canAttack) {
			damage = (int) (rnjesus.nextDouble() * (damageMax - damageMin + 1)) + damageMin;
			opponent.subtractHitPoints(damage);
		} // end if can attack
		else {

		} // end else

		return new AttackResult(damage, canAttack);

	}// end attack method

//-----------------------------------------------------------------

}// end class Character