package dungeon.entities;

import java.io.Serializable;

import dungeon.enums.Weapons;

public abstract class DungeonCharacter implements Serializable {

	private static final long serialVersionUID = 3792593125795987889L;
	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;
	private int numTurns;
	private Weapons weapon;

	public DungeonCharacter(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin,
			int damageMax, Weapons weapon) {

		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.weapon = weapon;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public double getChanceToHit() {
		return this.chanceToHit;
	}

	public int getMinDamage() {
		return this.damageMin;
	}

	public int getMaxDamage() {
		return this.damageMax;
	}

	public int getTurns() {
		return this.numTurns;
	}

	public Weapons getWeapon() {
		return this.weapon;
	}

	public void addHitPoints(int hitPoints) {
		if (hitPoints <= 0)
			System.out.println("Hitpoint amount must be positive.");
		else {
			this.hitPoints += hitPoints;
			System.out.println("Remaining Hit Points: " + hitPoints);

		}
	}

	public void subtractHitPoints(int hitPoints) {
		if (hitPoints < 0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints > 0) {
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(getName() + " takes <" + hitPoints + "> points of damage.");
			System.out.println(getName() + " now has " + getHitPoints() + " hit points remaining.");
			System.out.println();
		}

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");

	}

	public void setCharacter(DungeonCharacter h) {
		this.name = h.name;
		this.hitPoints = h.hitPoints;
		this.attackSpeed = h.attackSpeed;
		this.chanceToHit = h.chanceToHit;
		this.damageMin = h.damageMin;
		this.damageMax = h.damageMax;
		this.weapon = h.weapon;
	}

	public boolean isAlive() {
		return (hitPoints > 0);
	}

	public void setTurns(int turns) {
		this.numTurns = turns;
	}

}