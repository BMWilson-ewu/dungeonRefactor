package tests.weapons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Weapons;
import weapons.Club;
import weapons.Weapon;

class ClubTests {

	@Test
	void attackDesc_returnsCorrectString_TRUE() {
		Weapon sut = new Club();
		assertEquals(sut.attackDesc(), "swings a gnarled club at");
	}

	@Test
	void getKeyword_returnsCorrectKey_TRUE() {
		Weapon sut = new Club();
		assertEquals(sut.getKeyword(), Weapons.Club);
	}

}
