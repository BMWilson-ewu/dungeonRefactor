package tests.abilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import abilities.AttackPool;
import entities.DungeonCharacter;
import entities.Hero;
import entities.HeroFactory;
import enums.Abilities;
import enums.Heros;

class TwinStrikeTests {

	@Test
	void special_throwsIllegalArgumentExceptionWhenPassedNullAttacker_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Abilities sutKey = Abilities.TwinStrike;
			HeroFactory generateHero = new HeroFactory();
			Hero holder = generateHero.createHero(Heros.Warrior);
			AttackPool.getInstanceOf().getSpecialAbility(sutKey).special(null, holder);
		});
		assertEquals("Atacker passed was null.", exception.getMessage());
	}

	@Test
	void special_throwsIllegalArgumentExceptionWhenPassedNullDefender_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Abilities sutKey = Abilities.TwinStrike;
			HeroFactory generateHero = new HeroFactory();
			Hero holder = generateHero.createHero(Heros.Warrior);
			AttackPool.getInstanceOf().getSpecialAbility(sutKey).special(holder, null);
		});
		assertEquals("Defender passed was null.", exception.getMessage());
	}

	@Test
	void specialDesc_returnsCorrectString_TRUE() {
		Abilities sutKey = Abilities.TwinStrike;
		assertEquals("Twin Strike", AttackPool.getInstanceOf().getSpecialAbility(sutKey).specialDesc());
	}

	@Test
	void getKey_isEqualToEnumTypeTwinStrike_TRUE() {
		Abilities sutKey = Abilities.TwinStrike;
		Abilities sutTest = AttackPool.getInstanceOf().getSpecialAbility(sutKey).getKey();
		assertTrue(sutTest == sutKey);
	}

}
