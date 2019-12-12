package tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Weapons;
import weapons.Dagger;
import weapons.Weapon;

class DaggerTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new Dagger();
		assertEquals(sut.attackDesc(), "thrusts a dagger at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new Dagger();
		assertEquals(sut.getKeyword(), Weapons.Dagger);
	}

}
