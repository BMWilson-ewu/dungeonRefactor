package tests.abilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import abilities.AttackPool;
import entities.HeroFactory;
import enums.Heros;

class BasicAttackTests {

	@Test
	void attack_throwsIllegalArgumentExceptionWhenPassedNullAttacker_TRUE()
	{
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
		{
			HeroFactory generateHero = new HeroFactory();
			AttackPool.getInstanceOf().getBasicAttack().attack(null, generateHero.createHero(Heros.Warrior));
		});
		assertEquals("Atacker passed was null.", exception.getMessage());
	}
	
	@Test
	void attack_throwsIllegalArgumentExceptionWhenPassedNullDefender_TRUE()
	{
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
		{
			HeroFactory generateHero = new HeroFactory();
			AttackPool.getInstanceOf().getBasicAttack().attack(generateHero.createHero(Heros.Warrior), null);
		});
		assertEquals("Defender passed was null.", exception.getMessage());
	}
	
	// Inside method logic refactor for testing reasons

}
