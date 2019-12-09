package weapons;

import java.util.HashMap;

import specials.BasicAttack;
import specials.BasicHeal;
import specials.CrushingBlow;
import specials.HeroHeal;
import specials.SneakAttack;
import specials.SpecialAbility;

public class AttackPool {
	
	private static AttackPool attackPool;
	private BasicAttack attack;
	private BasicHeal heal;
	private HashMap<String, SpecialAbility> specialAbility;

	private AttackPool() {
		this.attack = new BasicAttack();
		this.heal = new BasicHeal();
		this.specialAbility = generateSpecialAbilities();
	}
	
	private HashMap<String, SpecialAbility> generateSpecialAbilities() {
		HashMap<String, SpecialAbility> specialAbility = new HashMap<String, SpecialAbility>();
		specialAbility.put("sneak", new SneakAttack());
		specialAbility.put("crush", new CrushingBlow());
		specialAbility.put("heal", new HeroHeal());
		return specialAbility;
	}
	
	public static AttackPool getInstanceOf() {
		if(attackPool == null) {
			return attackPool = new AttackPool();
		}
		return attackPool;
	}
	
	public SpecialAbility getSpecialAbility(String keyword) {
		return this.specialAbility.get(keyword);
	}
	
	public BasicAttack getbasicAttack() {
		return this.attack;
	}
	
	public BasicHeal getBasicHeal() {
		return this.heal;
	}
}
