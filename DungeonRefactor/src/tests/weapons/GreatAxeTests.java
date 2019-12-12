package tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Weapons;
import weapons.GreatAxe;
import weapons.Weapon;

class GreatAxeTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new GreatAxe();
		assertEquals(sut.attackDesc(), "slashes with a greataxe at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new GreatAxe();
		assertEquals(sut.getKeyword(), Weapons.GreatAxe);
	}

}
