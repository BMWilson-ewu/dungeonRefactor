package dungeon.tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.enums.Weapons;
import dungeon.weapons.Kris;
import dungeon.weapons.Weapon;

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
