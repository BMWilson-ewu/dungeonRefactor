package tests.items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Items;
import items.Item;
import items.PillarOfAbstraction;

class PillarOfAbstractionTests {

	@Test
	void trigger_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Item sut = new PillarOfAbstraction();
			sut.trigger(null);
		});
		assertEquals("Passed hero was null.", exception.getMessage());
	}

	@Test
	void interact_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Item sut = new PillarOfAbstraction();
			sut.interact(null);
		});
		assertEquals("Passed hero was null.", exception.getMessage());
	}

	@Test
	void getAbbreviation_returnCorrectAbbreviation_TRUE() {
		Item sut = new PillarOfAbstraction();
		assertEquals("P", sut.getAbbreviation());
	}

	@Test
	void getKey_returnsCorrectItemsType_TRUE() {
		Item sut = new PillarOfAbstraction();
		assertTrue(sut.getKey() == Items.PillarOfAbstraction);
	}

}
