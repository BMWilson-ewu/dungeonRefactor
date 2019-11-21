package common;

import java.util.Random;

public abstract class DungeonCharacter {
	
	private String name;
	private int hitPoints;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin;
	private int damageMax;

	public DungeonCharacter(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin,
			int damageMax) {

		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;

	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}
	
	public void addHitPoints(int hitPoints) {
		if (hitPoints <= 0)
			new IllegalArgumentException("Hit Points should not be zero or less.");
		this.hitPoints += hitPoints;
	}
	
	public void subtractHitPoints(int hitPoints) {
		
		if (hitPoints < 0) {
			throw new IllegalArgumentException("Hit Points lost must be positive.");
		}
		this.hitPoints -= hitPoints;
		if (this.hitPoints < 0) {
			this.hitPoints = 0;
		}

	}

	public boolean isAlive() {
		return (hitPoints > 0);
	}

	public AttackResult attack(DungeonCharacter opponent) {
		Random rnjesus = new Random();
		boolean canAttack = rnjesus.nextDouble() <= chanceToHit;
		int damage = (int) (rnjesus.nextDouble() * (damageMax - damageMin + 1)) + damageMin;;

		if (canAttack) {
			opponent.subtractHitPoints(damage);
		}

		return new AttackResult(damage, canAttack);
	}

}