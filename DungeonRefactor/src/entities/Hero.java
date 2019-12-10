package entities;

import java.util.ArrayList;
import java.util.Scanner;

import abilities.AttackPool;
import dungeon.HealPot;
import dungeon.RoomItem;
import enums.Abilities;
import enums.Weapons;

public class Hero extends DungeonCharacter {
	private double chanceToBlock;
	private ArrayList<RoomItem> pillars;
	private ArrayList<RoomItem> healPots;
	private ArrayList<RoomItem> visionPots;
	private Abilities specialAttack;
	private int posX;
	private int posY;

	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, Abilities sp, Weapons w) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, w);
		this.chanceToBlock = chanceToBlock;
	}

	public int getNumPillars() {
		return pillars.size();
	}

	public void addPillar(RoomItem p) {
		pillars.add(p);
	}

	public int getNumHeal() {
		return healPots.size();
	}

	public void addHealPot(RoomItem h) {
		healPots.add(h);
	}

	public void consumeHeal() {
		HealPot h = (HealPot) this.healPots.get(0);
		System.out.println(h.consume(this));
		healPots.remove(0);
	}

	public int getNumVision() {
		return healPots.size();
	}

	public void addVisionPot(RoomItem h) {
		visionPots.add(h);
	}

	public void consumeVision() {
		visionPots.remove(0);
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

	public String toString() {
		return "Name: " + this.getName() + "\n" + "Hit Points: " + this.getHitPoints() + "\n" + "Healing Potions: "
				+ this.healPots.size() + "\n" + "Vision Potioms: " + this.visionPots.size() + "\n" + "Pillars of OO: "
				+ this.pillars.size();
	}

	public void subtractHitPoints(int hitPoints) {
		if (defend()) {
			System.out.println(this.getName() + " BLOCKED the attack!");
		} else {
			super.subtractHitPoints(hitPoints);
		}

	}

}