package entities;
import java.util.Scanner;

import specials.SpecialAbility;
import weapons.Weapon;

public class Hero extends DungeonCharacter {
	private double chanceToBlock;
	private SpecialAbility special;

	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, SpecialAbility sp, Weapon w) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, w);
		this.special = sp;
		this.chanceToBlock = chanceToBlock;
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

	public void subtractHitPoints(int hitPoints) {
		if (defend()) {
			System.out.println(this.getName() + " BLOCKED the attack!");
		} else {
			super.subtractHitPoints(hitPoints);
		}

	}

}