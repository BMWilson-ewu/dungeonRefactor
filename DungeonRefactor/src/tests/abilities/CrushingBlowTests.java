package tests.abilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import abilities.AttackPool;
import entities.HeroFactory;
import enums.Heros;

class CrushingBlowTests {

	@Test
	void special_throwsIllegalArgumentExceptionWhenPassedNullAttacker_TRUE()
	{
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
		{
			HeroFactory generateHero = new HeroFactory();
			AttackPool.getInstanceOf().getbasicAttack().attack(null, generateHero.createHero(Heros.Warrior));
		});
		assertEquals("Atacker passed was null.", exception.getMessage());
	}
	
	@Test
	void special_throwsIllegalArgumentExceptionWhenPassedNullDefender_TRUE()
	{
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
		{
			HeroFactory generateHero = new HeroFactory();
			AttackPool.getInstanceOf().getbasicAttack().attack(generateHero.createHero(Heros.Warrior), null);
		});
		assertEquals("Defender passed was null.", exception.getMessage());
	}

}
