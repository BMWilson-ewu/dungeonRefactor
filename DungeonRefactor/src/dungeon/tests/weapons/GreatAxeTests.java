package dungeon.tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.enums.Weapons;
import dungeon.weapons.GreatAxe;
import dungeon.weapons.Weapon;

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
