package tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Weapons;
import weapons.Trident;
import weapons.Weapon;

class TridentTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new Trident();
		assertEquals(sut.attackDesc(), "stabs forward with a trident at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new Trident();
		assertEquals(sut.getKeyword(), Weapons.Trident);
	}

}
