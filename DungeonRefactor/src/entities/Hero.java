package entities;
import java.util.ArrayList;
import java.util.Scanner;

import dungeon.HealPot;
import dungeon.Room;
import dungeon.RoomItem;
import dungeon.VisionPot;
import specials.SpecialAbility;
import weapons.Weapon;

public class Hero extends DungeonCharacter {
	private double chanceToBlock;
	private SpecialAbility special;
	private ArrayList<RoomItem> pillars;
	private ArrayList<RoomItem> healPots;
	private ArrayList<RoomItem> visionPots;
	private int posX;
	private int posY;

	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, SpecialAbility sp, Weapon w) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, w);
		this.special = sp;
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
		HealPot h = (HealPot)this.healPots.get(0);
		System.out.println(h.consume(this));
		healPots.remove(0);
	}
	
	public int getNumVision() {
		return visionPots.size();
	}
	
	public void addVisionPot(RoomItem h) {
		visionPots.add(h);
	}
	
	public void consumeVision(Room[][] dungeon) {
		VisionPot v = (VisionPot)this.visionPots.get(0);
		System.out.println(v.consume(this, dungeon));
		visionPots.remove(0);
	}

	public void special(DungeonCharacter enemy) {
		special.special(this, enemy);
	}

	public String readSpecial() {
		return special.specialDesc();
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
		return "Name: " + this.getName() + "\n" +
				"Hit Points: " + this.getHitPoints() + "\n" +
				"Healing Potions: " + this.healPots.size() + "\n" +
				"Vision Potioms: " + this.visionPots.size() + "\n" + 
				"Pillars of OO: " + this.pillars.size(); 
	}

	public void subtractHitPoints(int hitPoints) {
		if (defend()) {
			System.out.println(this.getName() + " BLOCKED the attack!");
		} else {
			super.subtractHitPoints(hitPoints);
		}

	}

}