package dungeon.tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.entities.Hero;
import dungeon.entities.HeroFactory;
import dungeon.entities.Monster;
import dungeon.entities.MonsterFactory;
import dungeon.enums.Heros;
import dungeon.enums.Monsters;
import dungeon.enums.Weapons;

class DungeonCharacterTests {

	@Test
	void getName_returnsTheCorrectNameForWarrior_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals("Warrior", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForSorceress_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals("Sorceress", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForThief_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals("Thief", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForPaladin_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals("Paladin", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForRanger_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals("Ranger", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForFloridaman_TRUE() {
		Heros sutKey = Heros.Floridaman;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals("Florida man", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForOgre_TRUE() {
		Monsters sutKey = Monsters.Ogre;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals("Oscar the Ogre", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForSkeleton_TRUE() {
		Monsters sutKey = Monsters.Skeleton;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals("Sargath the Skeleton", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForGremlin_TRUE() {
		Monsters sutKey = Monsters.Gremlin;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals("Gnarltooth the Gremlin", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForMinotuar_TRUE() {
		Monsters sutKey = Monsters.Minotuar;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals("Varudak the Minotuar", sut.getName());
	}
	
	@Test
	void getName_returnsTheCorrectNameForBugbear_TRUE() {
		Monsters sutKey = Monsters.Bugbear;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals("Kesh the Bugbear", sut.getName());
	}
	
	@Test
	void setName_setsNameCorrectly_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		sut.setName("Hunter Rich");
		assertEquals("Hunter Rich", sut.getName());
	}
	
	@Test
	void getHitPoints_returnsCorrectValueForWarrior_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(125, sut.getHitPoints());
	}
	
	@Test
	void getHitPoints_returnsCorrectValueForSorceress_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(75, sut.getHitPoints());
	}
	
	@Test
	void getHitPoints_returnsCorrectValueForThief_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(75, sut.getHitPoints());
	}
	
	@Test
	void getHitPoints_returnsCorrectValueForPaladin_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(140, sut.getHitPoints());
	}
	
	@Test
	void getHitPoints_returnsCorrectValueForRanger_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(80, sut.getHitPoints());
	}
	
	@Test
	void getHitPoints_returnsCorrectValueForFloridaman_TRUE() {
		Heros sutKey = Heros.Floridaman;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(9999999, sut.getHitPoints());
	}
	
	@Test
	void getAttackSpeed_returnsCorrectValueForWarrior_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(4, sut.getAttackSpeed());
	}
	
	@Test
	void getAttackSpeed_returnsCorrectValueForSorceress_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(5, sut.getAttackSpeed());
	}
	
	@Test
	void getAttackSpeed_returnsCorrectValueForThief_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(6, sut.getAttackSpeed());
	}
	
	@Test
	void getAttackSpeed_returnsCorrectValueForPaladin_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(3, sut.getAttackSpeed());
	}
	
	@Test
	void getAttackSpeed_returnsCorrectValueForRanger_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(5, sut.getAttackSpeed());
	}
	
	@Test
	void getAttackSpeed_returnsCorrectValueForFloridaman_TRUE() {
		Heros sutKey = Heros.Floridaman;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(100, sut.getAttackSpeed());
	}
	
	@Test
	void getChanceToHit_returnsCorrectValueForWarrior_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.8, sut.getChanceToHit());
	}
	
	@Test
	void getChanceToHit_returnsCorrectValueForSorceress_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.7, sut.getChanceToHit());
	}
	
	@Test
	void getChanceToHit_returnsCorrectValueForThief_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.8, sut.getChanceToHit());
	}
	
	@Test
	void getChanceToHit_returnsCorrectValueForPaladin_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.6, sut.getChanceToHit());
	}
	
	@Test
	void getChanceToHit_returnsCorrectValueForRanger_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.8, sut.getChanceToHit());
	}
	
	@Test
	void getChanceToHit_returnsCorrectValueForFloridaman_TRUE() {
		Heros sutKey = Heros.Floridaman;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(1, sut.getChanceToHit());
	}
	
	@Test
	void getMinDamage_returnsCorrectValueForWarrior_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(35, sut.getMinDamage());
	}
	
	@Test
	void getMinDamage_returnsCorrectValueForSorceress_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(25, sut.getMinDamage());
	}
	
	@Test
	void getMinDamage_returnsCorrectValueForThief_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(20, sut.getMinDamage());
	}
	
	@Test
	void getMinDamage_returnsCorrectValueForPaladin_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(40, sut.getMinDamage());
	}
	
	@Test
	void getMinDamage_returnsCorrectValueForRanger_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(30, sut.getMinDamage());
	}
	
	
	@Test
	void getMinDamage_returnsCorrectValueForFloridaman_TRUE() {
		Heros sutKey = Heros.Floridaman;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(500, sut.getMinDamage());
	}
	
	@Test
	void getMaxDamage_returnsCorrectValueForWarrior_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(60, sut.getMaxDamage());
	}
	
	@Test
	void getMaxDamage_returnsCorrectValueForSorceress_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(50, sut.getMaxDamage());
	}
	
	@Test
	void getMaxDamage_returnsCorrectValueForThief_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(40, sut.getMaxDamage());
	}
	
	@Test
	void getMaxDamage_returnsCorrectValueForPaladin_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(60, sut.getMaxDamage());
	}
	
	@Test
	void getMaxDamage_returnsCorrectValueForRanger_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(55, sut.getMaxDamage());
	}
	
	@Test
	void getMaxDamage_returnsCorrectValueForFloridaman_TRUE() {
		Heros sutKey = Heros.Floridaman;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(1000, sut.getMaxDamage());
	}
	
	@Test
	void getTurns_returnsCorrectValue_TRUE() {
		Heros sutKey = Heros.Floridaman;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		sut.setTurns(25);
		assertEquals(25, sut.getTurns());
	}
	
	@Test
	void getWeapon_returnsCorrectValueForWarrior_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(Weapons.GreatSword, sut.getWeapon());
	}
	
	@Test
	void getWeapon_returnsCorrectValueForSorceress_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(Weapons.FireStaff, sut.getWeapon());
	}
	
	@Test
	void getWeapon_returnsCorrectValueForThief_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(Weapons.Dagger, sut.getWeapon());
	}
	
	@Test
	void getWeapon_returnsCorrectValueForPaladin_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(Weapons.Flail, sut.getWeapon());
	}
	
	@Test
	void getWeapon_returnsCorrectValueForRanger_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(Weapons.ShortBow, sut.getWeapon());
	}
	
	@Test
	void getWeapon_returnsCorrectValueForFloridaman_TRUE() {
		Heros sutKey = Heros.Floridaman;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(Weapons.RustyBlade, sut.getWeapon());
	}
	

}
