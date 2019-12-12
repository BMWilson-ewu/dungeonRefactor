package dungeon.tests.items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.abilities.AttackPool;
import dungeon.entities.Hero;
import dungeon.entities.HeroFactory;
import dungeon.enums.Abilities;
import dungeon.enums.Heros;
import dungeon.enums.Items;
import dungeon.items.Entrance;
import dungeon.items.Item;

class EntranceTests {

	@Test
	void trigger_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Item sut = new Entrance();
			sut.trigger(null);
		});
		assertEquals("Passed hero was null.", exception.getMessage());
	}

	@Test
	void interact_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Item sut = new Entrance();
			sut.interact(null);
		});
		assertEquals("Passed hero was null.", exception.getMessage());
	}

	@Test
	void getAbbreviation_returnCorrectAbbreviation_TRUE() {
		Item sut = new Entrance();
		assertEquals("I", sut.getAbbreviation());
	}

	@Test
	void getKey_returnsCorrectItemsType_TRUE() {
		Item sut = new Entrance();
		assertTrue(sut.getKey() == Items.Entrance);
	}

}
