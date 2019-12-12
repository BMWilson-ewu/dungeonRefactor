package tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Weapons;
import weapons.GreatSword;
import weapons.Weapon;

class GreatSwordTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new GreatSword();
		assertEquals(sut.attackDesc(), "swings a mighty greatsword at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new GreatSword();
		assertEquals(sut.getKeyword(), Weapons.GreatSword);
	}

}
