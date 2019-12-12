package dungeon.tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.entities.Monster;
import dungeon.entities.MonsterFactory;
import dungeon.enums.Monsters;

class MonsterFactoryTests {

	@Test
	void createMonster_throwsIllegalArgumentExceptionWhenPassedNullHeroType_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			MonsterFactory generateHero = new MonsterFactory();
			@SuppressWarnings("unused")
			Monster holder = generateHero.createMonster(null);
		});
		assertEquals("Monster type was null", exception.getMessage());
	}
	
	@Test
	void createHero_createdPassedMonsterTypeOgreIsNotNull_TRUE() {
		Monsters sutKey = Monsters.Ogre;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedMonsterTypeOgre_TRUE() {
		Monsters sutKey = Monsters.Ogre;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut instanceof Monster);
	}
	
	@Test
	void createHero_createdPassedMonsterTypeSkeletonIsNotNull_TRUE() {
		Monsters sutKey = Monsters.Skeleton;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedMonsterTypeSkeleton_TRUE() {
		Monsters sutKey = Monsters.Skeleton;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut instanceof Monster);
	}
	
	@Test
	void createHero_createdPassedMonsterTypeGremlinIsNotNull_TRUE() {
		Monsters sutKey = Monsters.Gremlin;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedMonsterTypeGremlin_TRUE() {
		Monsters sutKey = Monsters.Gremlin;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut instanceof Monster);
	}
	
	@Test
	void createHero_createdPassedMonsterTypeMinotuarIsNotNull_TRUE() {
		Monsters sutKey = Monsters.Minotuar;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedMonsterTypeMinotuar_TRUE() {
		Monsters sutKey = Monsters.Minotuar;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut instanceof Monster);
	}
	
	@Test
	void createHero_createdPassedMonsterTypeBugbearIsNotNull_TRUE() {
		Monsters sutKey = Monsters.Bugbear;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedMonsterTypeBugbear_TRUE() {
		Monsters sutKey = Monsters.Bugbear;
		MonsterFactory generateHero = new MonsterFactory();
		Monster sut = generateHero.createMonster(sutKey);
		assertTrue(sut instanceof Monster);
	}

}
