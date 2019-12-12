package dungeon.tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.enums.Weapons;
import dungeon.weapons.RustyBlade;
import dungeon.weapons.Weapon;

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
