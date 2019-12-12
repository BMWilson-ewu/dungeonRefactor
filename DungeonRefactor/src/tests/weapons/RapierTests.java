package tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Weapons;
import weapons.Rapier;
import weapons.Weapon;

class RapierTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new Rapier();
		assertEquals(sut.attackDesc(), "lunges with the rapier at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new Rapier();
		assertEquals(sut.getKeyword(), Weapons.Rapier);
	}

}
