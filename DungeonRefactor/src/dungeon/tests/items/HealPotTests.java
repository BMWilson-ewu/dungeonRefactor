package dungeon.tests.items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.enums.Items;
import dungeon.items.Exit;
import dungeon.items.HealPot;
import dungeon.items.Item;

class HealPotTests {

	@Test
	void trigger_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Item sut = new HealPot();
			sut.trigger(null);
		});
		assertEquals("Passed hero was null.", exception.getMessage());
	}

	@Test
	void interact_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Item sut = new HealPot();
			sut.interact(null);
		});
		assertEquals("Passed hero was null.", exception.getMessage());
	}

	@Test
	void getAbbreviation_returnCorrectAbbreviation_TRUE() {
		Item sut = new HealPot();
		assertEquals("H", sut.getAbbreviation());
	}

	@Test
	void getKey_returnsCorrectItemsType_TRUE() {
		Item sut = new HealPot();
		assertTrue(sut.getKey() == Items.HealingPotion);
	}

}
