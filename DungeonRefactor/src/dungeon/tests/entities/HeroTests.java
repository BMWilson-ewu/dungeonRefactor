package dungeon.tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.entities.Hero;
import dungeon.entities.HeroFactory;
import dungeon.enums.Heros;
import dungeon.enums.Items;

class HeroTests {

	@Test
	void getChanceToBlock_returnsCorrectValueForWarrior_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.2, sut.getChanceToBlock());
	}

	@Test
	void getChanceToBlock_returnsCorrectValueForSorceress_TRUE() {
		Heros sutKey = Heros.Sorceress;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.3, sut.getChanceToBlock());
	}

	@Test
	void getChanceToBlock_returnsCorrectValueForThief_TRUE() {
		Heros sutKey = Heros.Thief;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.5, sut.getChanceToBlock());
	}

	@Test
	void getChanceToBlock_returnsCorrectValueForPaladin_TRUE() {
		Heros sutKey = Heros.Paladin;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.2, sut.getChanceToBlock());
	}

	@Test
	void getChanceToBlock_returnsCorrectValueForRanger_TRUE() {
		Heros sutKey = Heros.Ranger;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(.4, sut.getChanceToBlock());
	}

	@Test
	void getChanceToBlock_returnsCorrectValueForFloridaman_TRUE() {
		Heros sutKey = Heros.Floridaman;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertEquals(1, sut.getChanceToBlock());
	}

	@Test
	void getNumPillars_returnsCorrectNumberOfPlliars_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		sut.addItem(Items.PillarOfAbstraction);
		sut.addItem(Items.PillarOfEncapsulation);
		assertEquals(2, sut.getNumPillars());
	}

	@Test
	void addItem_throwsIllegalArgumentExceptionWhenPassedNull_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Heros sutKey = Heros.Warrior;
			HeroFactory generateHero = new HeroFactory();
			Hero sut = generateHero.createHero(sutKey);
			sut.addItem(null);
		});
		assertEquals("Item passed was null.", exception.getMessage());
	}

	@Test
	void consumeHeal_increasesHerosHitPoints_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		sut.addItem(Items.HealingPotion);
		int hitPointsBefore = sut.getHitPoints();
		sut.consumeHeal();
		int hitPointsAfter = sut.getHitPoints();
		assertTrue(hitPointsBefore < hitPointsAfter);
	}

	@Test
	void setCharacter_setsNewHero_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(Heros.Paladin);
		Hero replace = generateHero.createHero(sutKey);
		replace.addItem(Items.PillarOfAbstraction);
		replace.addItem(Items.PillarOfEncapsulation);
		sut.setCharacter(replace);
		assertTrue(sut.getNumPillars() == 2);
	}

	@Test
	void setgetX_setsAndGetsValueCorrectly_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		sut.setX(6);
		assertEquals(6, sut.getX());
	}

	@Test
	void setgetY_setsAndGetsValueCorrectly_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		sut.setY(4);
		assertEquals(4, sut.getY());
	}

	@Test
	void takeDamage_heroTakesDamage_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		int hitPointsBefore = sut.getHitPoints();
		int damage = 50;
		sut.takeDamage(damage);
		int hitPointsAfter = sut.getHitPoints();
		assertTrue(hitPointsBefore == hitPointsAfter + damage);
	}

	@Test
	void toString_returnsAString_TRUE() {
		Heros sutKey = Heros.Warrior;
		HeroFactory generateHero = new HeroFactory();
		Hero sut = generateHero.createHero(sutKey);
		assertTrue(sut.toString() instanceof String);
	}

}
