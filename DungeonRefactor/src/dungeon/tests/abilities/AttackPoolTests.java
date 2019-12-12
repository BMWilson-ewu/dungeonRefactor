package dungeon.tests.abilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.abilities.AttackPool;
import dungeon.abilities.BasicAttack;
import dungeon.abilities.BasicHeal;
import dungeon.abilities.SpecialAbility;
import dungeon.enums.Abilities;
import dungeon.enums.Items;
import dungeon.enums.Weapons;
import dungeon.items.Item;
import dungeon.weapons.Weapon;

class AttackPoolTests {

	@Test
	void getInstanceOf_returnIsNotNull_TRUE() {
		assertTrue(AttackPool.getInstanceOf() != null);
	}
	
	@Test
	void getSpecialAbility_returnOfSneakAttackIsNotNull_TRUE() {
		Abilities sutKey = Abilities.SneakAttack;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) != null);
	}
	
	@Test
	void getSpecialAbility_returnOfSneakAttackIsInstanceOfSpecialAbility_TRUE() {
		Abilities sutKey = Abilities.SneakAttack;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) instanceof SpecialAbility);
	}
	
	@Test
	void getSpecialAbility_returnOfCrushingBlowIsNotNull_TRUE() {
		Abilities sutKey = Abilities.CrushingBlow;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) != null);
	}
	
	@Test
	void getSpecialAbility_returnOfCrushingBlowIsInstanceOfSpecialAbility_TRUE() {
		Abilities sutKey = Abilities.CrushingBlow;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) instanceof SpecialAbility);
	}
	
	@Test
	void getSpecialAbility_returnOfHeroHealIsNotNull_TRUE() {
		Abilities sutKey = Abilities.HeroHeal;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) != null);
	}
	
	@Test
	void getSpecialAbility_returnOfHeroHealIsInstanceOfSpecialAbility_TRUE() {
		Abilities sutKey = Abilities.HeroHeal;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) instanceof SpecialAbility);
	}
	
	@Test
	void getSpecialAbility_returnOfTwinStrikeIsNotNull_TRUE() {
		Abilities sutKey = Abilities.TwinStrike;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) != null);
	}
	
	@Test
	void getSpecialAbility_returnOfTwinStrikeIsInstanceOfSpecialAbility_TRUE() {
		Abilities sutKey = Abilities.TwinStrike;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) instanceof SpecialAbility);
	}
	
	@Test
	void getSpecialAbility_returnOfSmiteIsNotNull_TRUE() {
		Abilities sutKey = Abilities.Smite;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) != null);
	}
	
	@Test
	void getSpecialAbility_returnOfSmiteIsInstanceOfSpecialAbility_TRUE() {
		Abilities sutKey = Abilities.Smite;
		assertTrue(AttackPool.getInstanceOf().getSpecialAbility(sutKey) instanceof SpecialAbility);
	}
	
	@Test
	void getWeapon_returnOfClubIsNotNull_TRUE() {
		Weapons sutKey = Weapons.Club;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfClubIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.Club;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfDaggerIsNotNull_TRUE() {
		Weapons sutKey = Weapons.Dagger;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfDaggerIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.Dagger;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfFireStaffIsNotNull_TRUE() {
		Weapons sutKey = Weapons.FireStaff;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfFireStaffIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.FireStaff;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfFlailIsNotNull_TRUE() {
		Weapons sutKey = Weapons.Flail;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfFlailIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.Flail;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfGreatAxeIsNotNull_TRUE() {
		Weapons sutKey = Weapons.GreatAxe;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfGreatAxeIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.GreatAxe;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfGreatSwordIsNotNull_TRUE() {
		Weapons sutKey = Weapons.GreatSword;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfGreatSwordIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.GreatSword;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfKrisIsNotNull_TRUE() {
		Weapons sutKey = Weapons.Kris;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfKrisIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.Kris;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfRapierIsNotNull_TRUE() {
		Weapons sutKey = Weapons.Rapier;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfRapierIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.Rapier;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfRustyBladeIsNotNull_TRUE() {
		Weapons sutKey = Weapons.RustyBlade;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfRustyBladeIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.RustyBlade;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfShortBowIsNotNull_TRUE() {
		Weapons sutKey = Weapons.ShortBow;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfShortBowIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.ShortBow;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getWeapon_returnOfTridentIsNotNull_TRUE() {
		Weapons sutKey = Weapons.Trident;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) != null);
	}
	
	@Test
	void getWeapon_returnOfTridentIsInstanceOfWeapon_TRUE() {
		Weapons sutKey = Weapons.Trident;
		assertTrue(AttackPool.getInstanceOf().getWeapon(sutKey) instanceof Weapon);
	}
	
	@Test
	void getItem_returnOfEntranceIsNotNull_TRUE() {
		Items sutKey = Items.Entrance;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) != null);
	}
	
	@Test
	void getItem_returnOfEntranceIsInstanceOfItem_TRUE() {
		Items sutKey = Items.Entrance;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) instanceof Item);
	}
	
	@Test
	void getItem_returnOfExitIsNotNull_TRUE() {
		Items sutKey = Items.Exit;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) != null);
	}
	
	@Test
	void getItem_returnOfExitIsInstanceOfItem_TRUE() {
		Items sutKey = Items.Exit;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) instanceof Item);
	}
	
	@Test
	void getItem_returnOfHealingPotionIsNotNull_TRUE() {
		Items sutKey = Items.HealingPotion;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) != null);
	}
	
	@Test
	void getItem_returnOfHealingPotionIsInstanceOfItem_TRUE() {
		Items sutKey = Items.HealingPotion;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) instanceof Item);
	}
	
	@Test
	void getItem_returnOfVisionPotionIsNotNull_TRUE() {
		Items sutKey = Items.VisionPotion;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) != null);
	}
	
	@Test
	void getItem_returnOfVisionPotionIsInstanceOfItem_TRUE() {
		Items sutKey = Items.VisionPotion;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) instanceof Item);
	}
	
	@Test
	void getItem_returnOfPillarOfAbstractionIsNotNull_TRUE() {
		Items sutKey = Items.PillarOfAbstraction;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) != null);
	}
	
	@Test
	void getItem_returnOfPillarOfAbstractionIsInstanceOfItem_TRUE() {
		Items sutKey = Items.PillarOfAbstraction;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) instanceof Item);
	}
	
	@Test
	void getItem_returnOfPillarOfEncapsulationIsNotNull_TRUE() {
		Items sutKey = Items.PillarOfEncapsulation;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) != null);
	}
	
	@Test
	void getItem_returnOfPillarOfEncapsulationIsInstanceOfItem_TRUE() {
		Items sutKey = Items.PillarOfEncapsulation;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) instanceof Item);
	}
	
	@Test
	void getItem_returnOfPillarOfInheritanceIsNotNull_TRUE() {
		Items sutKey = Items.PillarOfInheritance;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) != null);
	}
	
	@Test
	void getItem_returnOfPillarOfInheritanceIsInstanceOfItem_TRUE() {
		Items sutKey = Items.PillarOfInheritance;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) instanceof Item);
	}
	
	@Test
	void getItem_returnOfPillarOfPolymorphismIsNotNull_TRUE() {
		Items sutKey = Items.PillarOfPolymorphism;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) != null);
	}
	
	@Test
	void getItem_returnOfPillarOfPolymorphismIsInstanceOfItem_TRUE() {
		Items sutKey = Items.PillarOfPolymorphism;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) instanceof Item);
	}
	
	@Test
	void getItem_returnOfPitIsNotNull_TRUE() {
		Items sutKey = Items.Pit;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) != null);
	}
	
	@Test
	void getItem_returnOfPitIsInstanceOfItem_TRUE() {
		Items sutKey = Items.Pit;
		assertTrue(AttackPool.getInstanceOf().getItem(sutKey) instanceof Item);
	}
	
	@Test
	void getbasicAttack_returnOfBasicAttackIsNotNull_TRUE() {
		assertTrue(AttackPool.getInstanceOf().getBasicAttack() != null);
	}
	
	@Test
	void getbasicAttack_returnOfBasicAttackIsInstanceOfBasicAttack_TRUE() {
		assertTrue(AttackPool.getInstanceOf().getBasicAttack() instanceof BasicAttack);
	}

	@Test
	void getbasicAttack_returnOfBasicHealIsNotNull_TRUE() {
		assertTrue(AttackPool.getInstanceOf().getBasicHeal() != null);
	}
	
	@Test
	void getbasicAttack_returnOfBasicHealIsInstanceOfBasicAttack_TRUE() {
		assertTrue(AttackPool.getInstanceOf().getBasicHeal() instanceof BasicHeal);
	}
	
	@Test
	void getSpecialAbility_throwsIllegalArgumentExceptionWhenPassedNull_TRUE()
	{
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
		{
			AttackPool.getInstanceOf().getSpecialAbility(null);
		});
		assertEquals("Abilities type was null", exception.getMessage());
	}
	
	@Test
	void getWeapon_throwsIllegalArgumentExceptionWhenPassedNull_TRUE()
	{
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
		{
			AttackPool.getInstanceOf().getWeapon(null);
		});
		assertEquals("Weapons type was null", exception.getMessage());
	}
	
	@Test
	void getItem_throwsIllegalArgumentExceptionWhenPassedNull_TRUE()
	{
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
		{
			AttackPool.getInstanceOf().getItem(null);
		});
		assertEquals("Items type was null", exception.getMessage());
	}
	
	
}
