package dungeon.tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.entities.Hero;
import dungeon.entities.HeroFactory;
import dungeon.enums.Heros;

class HeroFactoryTests {
	
	@Test
	void createHero_throwsIllegalArgumentExceptionWhenPassedNullHeroType_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			HeroFactory generateHero = new HeroFactory();
			@SuppressWarnings("unused")
			Hero holder = generateHero.createHero(null);
		});
		assertEquals("Hero type was null", exception.getMessage());
	}
	
	@Test
	void createHero_createdPassedHeroTypeWarriorIsNotNull_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedHeroTypeWarrior_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut instanceof Hero);
	}
	
	@Test
	void createHero_createdPassedHeroTypeSorceressIsNotNull_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedHeroTypeSorceress_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut instanceof Hero);
	}
	
	@Test
	void createHero_createdPassedHeroTypeThiefIsNotNull_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedHeroTypeThief_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut instanceof Hero);
	}
	
	@Test
	void createHero_createdPassedHeroTypePaladinIsNotNull_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedHeroTypePaladin_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut instanceof Hero);
	}
	
	@Test
	void createHero_createdPassedHeroTypeRangerIsNotNull_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedHeroTypeRanger_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut instanceof Hero);
	}
	
	@Test
	void createHero_createdPassedHeroTypeFloridamanIsNotNull_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut != null);
	}

	@Test
	void createHero_createsPassedHeroTypeFloridaman_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut instanceof Hero);
	}

}
