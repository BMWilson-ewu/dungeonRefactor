package dungeon.tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.enums.Weapons;
import dungeon.weapons.ShortBow;
import dungeon.weapons.Weapon;

class ShortBowTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new ShortBow();
		assertEquals(sut.attackDesc(), "shoots the shortbow at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new ShortBow();
		assertEquals(sut.getKeyword(), Weapons.ShortBow);
	}

}
