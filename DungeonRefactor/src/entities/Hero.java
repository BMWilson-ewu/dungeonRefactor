package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import abilities.AttackPool;
import enums.Abilities;
import enums.Items;
import enums.Weapons;

public class Hero extends DungeonCharacter implements Serializable {

	private static final long serialVersionUID = 7325368055168446121L;
	private double chanceToBlock;
	private ArrayList<Items> items;
	private Abilities specialAttack;
	private int posX;
	private int posY;

	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, Abilities sp, Weapons w) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, w);
		this.specialAttack = sp;
		this.chanceToBlock = chanceToBlock;
		this.items = new ArrayList<Items>();
	}

	public int getNumPillars() {
		int count = 0;
		for (Items item : items) {
			if (item == Items.PillarOfAbstraction || item == Items.PillarOfEncapsulation
					|| item == Items.PillarOfInheritance || item == Items.PillarOfPolymorphism) {
				count++;
			}
		}
		return count;
	}

	private int getNumHeal() {
		int count = 0;
		for (Items item : items) {
			if (item == Items.HealingPotion) {
				count++;
			}
		}
		return count;
	}

	private int getNumVision() {
		int count = 0;
		for (Items item : items) {
			if (item == Items.VisionPotion) {
				count++;
			}
		}
		return count;
	}

	public void addItem(Items item) {
		items.add(item);
	}

	public void consumeHeal() {
		for (Items item : items) {
			if (item == Items.HealingPotion) {
				System.out.println(AttackPool.getInstanceOf().getItem(item).interact(this));
				this.items.remove(item);
				return;
			}
		}
	}

	public void consumeVision() {
		for (Items item : items) {
			if (item == Items.VisionPotion) {
				System.out.println(AttackPool.getInstanceOf().getItem(item).interact(this));
				this.items.remove(item);
				return;
			}
		}
	}

	public void special(DungeonCharacter enemy) {
		AttackPool.getInstanceOf().getSpecialAbility(specialAttack).special(this, enemy);
	}

	public String readSpecial() {
		return AttackPool.getInstanceOf().getSpecialAbility(specialAttack).specialDesc();
	}

	public void readName(Scanner kin) {
		System.out.print("Enter character name: ");
		this.setName(kin.nextLine());
	}

	public boolean defend() {
		return Math.random() <= chanceToBlock;

	}

	public void setX(int x) {
		this.posX = x;
	}

	public int getX() {
		return this.posX;
	}

	public void setY(int y) {
		this.posY = y;
	}

	public int getY() {
		return this.posY;
	}

	public String toString() {
		return "Name: " + this.getName() + "\n" + "Hit Points: " + this.getHitPoints() + "\n" + "Healing Potions: "
				+ this.getNumHeal() + "\n" + "Vision Potioms: " + this.getNumVision() + "\n" + "Pillars of OO: "
				+ this.getNumPillars();
	}

	public void subtractHitPoints(int hitPoints) {
		if (defend()) {
			System.out.println(this.getName() + " BLOCKED the attack!");
		} else {
			super.subtractHitPoints(hitPoints);
		}

	}
	
	public void takeDamage(int hitPoints) {
		super.subtractHitPoints(hitPoints);
	}

}