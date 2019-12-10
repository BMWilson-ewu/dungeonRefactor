package abilities;

import java.util.HashMap;

import enums.Abilities;
import enums.Items;
import enums.Weapons;
import items.*;
import weapons.*;

public class AttackPool {

	private static AttackPool attackPool;
	private BasicAttack attack;
	private BasicHeal heal;
	private HashMap<Abilities, SpecialAbility> specialAbility;
	private HashMap<Weapons, Weapon> weapons;
	private HashMap<Items, Item> items;
	private Item trap;

	private AttackPool() {
		this.attack = new BasicAttack();
		this.heal = new BasicHeal();
		this.specialAbility = generateSpecialAbilities();
		this.weapons = generateWeapons();
		this.items = generateItems();
		this.trap = new Pit();
	}

	private HashMap<Abilities, SpecialAbility> generateSpecialAbilities() {
		HashMap<Abilities, SpecialAbility> specialAbility = new HashMap<Abilities, SpecialAbility>();
		specialAbility.put(Abilities.SneakAttack, new SneakAttack());
		specialAbility.put(Abilities.CrushingBlow, new CrushingBlow());
		specialAbility.put(Abilities.HeroHeal, new HeroHeal());
		specialAbility.put(Abilities.TwinStrike, new TwinStrike());
		specialAbility.put(Abilities.Smite, new Smite());
		return specialAbility;
	}

	private HashMap<Weapons, Weapon> generateWeapons() {
		HashMap<Weapons, Weapon> weapons = new HashMap<Weapons, Weapon>();
		weapons.put(Weapons.Club, new Club());
		weapons.put(Weapons.Dagger, new Dagger());
		weapons.put(Weapons.FireStaff, new FireStaff());
		weapons.put(Weapons.Flail, new Flail());
		weapons.put(Weapons.GreatAxe, new GreatAxe());
		weapons.put(Weapons.GreatSword, new GreatSword());
		weapons.put(Weapons.Kris, new Kris());
		weapons.put(Weapons.Rapier, new Rapier());
		weapons.put(Weapons.RustyBlade, new RustyBlade());
		weapons.put(Weapons.ShortBow, new ShortBow());
		weapons.put(Weapons.Trident, new Trident());
		return weapons;
	}

	private HashMap<Items, Item> generateItems() {
		HashMap<Items, Item> items = new HashMap<Items, Item>();
		items.put(Items.Entrance, new Entrance());
		items.put(Items.Exit, new Exit());
		items.put(Items.HealingPotion, new HealPot());
		items.put(Items.VisionPotion, new VisionPot());
		items.put(Items.PillarOfAbstraction, new PillarOfAbstraction());
		items.put(Items.PillarOfEncapsulation, new PillarOfEncapsulation());
		items.put(Items.PillarOfInheritance, new PillarOfInheritance());
		items.put(Items.PillarOfPolymorphism, new PillarOfPolymorphism());
		return items;
	}

	public static AttackPool getInstanceOf() {
		if (attackPool == null) {
			return attackPool = new AttackPool();
		}
		return attackPool;
	}

	public SpecialAbility getSpecialAbility(Abilities ability) {
		if(ability == null) {
			throw new IllegalArgumentException("Abilities type was null");
		}
		return this.specialAbility.get(ability);
	}

	public Weapon getWeapon(Weapons weapon) {
		if(weapon == null) {
			throw new IllegalArgumentException("Weapons type was null");
		}
		return this.weapons.get(weapon);
	}

	public Item getItem(Items item) {
		if(item == null) {
			throw new IllegalArgumentException("Items type was null");
		}
		return items.get(item);
	}

	public BasicAttack getbasicAttack() {
		return this.attack;
	}

	public BasicHeal getBasicHeal() {
		return this.heal;
	}

	public Item getTrap() {
		return this.trap;
	}

}