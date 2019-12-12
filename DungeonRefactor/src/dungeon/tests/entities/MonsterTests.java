package dungeon.tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.entities.Monster;
import dungeon.entities.MonsterFactory;
import dungeon.enums.Monsters;

class MonsterTests {

	@Test
	void getChanceToHeal_returnsCorrectValueForOgre_TRUE() {
		Monsters sutKey = Monsters.Ogre;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(.1, sut.getChanceToHeal());
	}
	
	@Test
	void getMinHeal_returnsCorrectValueForOgre_TRUE() {
		Monsters sutKey = Monsters.Ogre;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(30, sut.getMinHeal());
	}
	
	@Test
	void getMaxHeal_returnsCorrectValueForOgre_TRUE() {
		Monsters sutKey = Monsters.Ogre;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(50, sut.getMaxHeal());
	}
	
	@Test
	void getChanceToHeal_returnsCorrectValueForSkeleton_TRUE() {
		Monsters sutKey = Monsters.Skeleton;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(.3, sut.getChanceToHeal());
	}
	
	@Test
	void getMinHeal_returnsCorrectValueForSkeleton_TRUE() {
		Monsters sutKey = Monsters.Skeleton;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(30, sut.getMinHeal());
	}
	
	@Test
	void getMaxHeal_returnsCorrectValueForSkeleton_TRUE() {
		Monsters sutKey = Monsters.Skeleton;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(50, sut.getMaxHeal());
	}
	
	@Test
	void getChanceToHeal_returnsCorrectValueForGremlin_TRUE() {
		Monsters sutKey = Monsters.Gremlin;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(.4, sut.getChanceToHeal());
	}
	
	@Test
	void getMinHeal_returnsCorrectValueForGremlin_TRUE() {
		Monsters sutKey = Monsters.Gremlin;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(20, sut.getMinHeal());
	}
	
	@Test
	void getMaxHeal_returnsCorrectValueForGremlin_TRUE() {
		Monsters sutKey = Monsters.Gremlin;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(40, sut.getMaxHeal());
	}
	
	@Test
	void getChanceToHeal_returnsCorrectValueForMinotuar_TRUE() {
		Monsters sutKey = Monsters.Minotuar;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(.2, sut.getChanceToHeal());
	}
	
	@Test
	void getMinHeal_returnsCorrectValueForMinotuar_TRUE() {
		Monsters sutKey = Monsters.Minotuar;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(20, sut.getMinHeal());
	}
	
	@Test
	void getMaxHeal_returnsCorrectValueForMinotuar_TRUE() {
		Monsters sutKey = Monsters.Minotuar;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(40, sut.getMaxHeal());
	}
	
	@Test
	void getChanceToHeal_returnsCorrectValueForBugbear_TRUE() {
		Monsters sutKey = Monsters.Bugbear;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(.4, sut.getChanceToHeal());
	}
	
	@Test
	void getMinHeal_returnsCorrectValueForBugbear_TRUE() {
		Monsters sutKey = Monsters.Bugbear;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(25, sut.getMinHeal());
	}
	
	@Test
	void getMaxHeal_returnsCorrectValueForBugbear_TRUE() {
		Monsters sutKey = Monsters.Bugbear;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertEquals(45, sut.getMaxHeal());
	}
	
}
