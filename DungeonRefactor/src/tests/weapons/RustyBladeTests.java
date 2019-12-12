package tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Weapons;
import weapons.RustyBlade;
import weapons.Weapon;

class RustyBladeTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new RustyBlade();
		assertEquals(sut.attackDesc(), "swings a rusty blade at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new RustyBlade();
		assertEquals(sut.getKeyword(), Weapons.RustyBlade);
	}

}
