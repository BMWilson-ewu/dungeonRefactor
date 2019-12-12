package tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Weapons;
import weapons.ShortBow;
import weapons.Weapon;

class ShortBowTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new ShortBow();
		assertEquals(sut.attackDesc(), "shoots the shortbow at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new ShortBow();
		assertEquals(sut.getKeyword(), Weapons.ShortBow);
	}

}
