package tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Weapons;
import weapons.Kris;
import weapons.Weapon;

class KrisTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new Kris();
		assertEquals(sut.attackDesc(), "jabs its kris at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new Kris();
		assertEquals(sut.getKeyword(), Weapons.Kris);
	}

}
