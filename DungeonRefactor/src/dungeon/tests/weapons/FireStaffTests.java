package dungeon.tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.enums.Weapons;
import dungeon.weapons.FireStaff;
import dungeon.weapons.Weapon;

class FireStaffTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new FireStaff();
		assertEquals(sut.attackDesc(), "launches a fireball at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new FireStaff();
		assertEquals(sut.getKeyword(), Weapons.FireStaff);
	}
}
