package dungeon.tests.abilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.abilities.AttackPool;

class BasicHealTests {

	@Test
	void heal_throwsIllegalArgumentExceptionWhenPassedNullSource_TRUE()
	{
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
		{
			AttackPool.getInstanceOf().getBasicHeal().heal(null);
		});
		assertEquals("Source was null", exception.getMessage());
	}
	
	// Inside method logic refactor for testing reasons
}
