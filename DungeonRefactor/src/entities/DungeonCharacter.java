package entities;
import weapons.Weapon;

public abstract class DungeonCharacter {

	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin, damageMax;
	private int numTurns;
	private Weapon weapon;

	public DungeonCharacter(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin,
			int damageMax, Weapon w) {

		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.weapon = w;

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
	
	public Weapon getWeapon() {
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

	public boolean isAlive() {
		return (hitPoints > 0);
	}

	public void setTurns(int turns) {
		this.numTurns = turns;
	}

}