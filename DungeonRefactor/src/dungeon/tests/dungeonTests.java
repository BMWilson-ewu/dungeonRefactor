package dungeon.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.Dungeon;
import entities.Hero;
import entities.HeroFactory;
import enums.Heros;

class dungeonTests {
	
	private final Dungeon dungeon = new Dungeon(5, 5, 5);
	
	
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	
	@Test
    void moveHero_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            dungeon.moveHero(null, "");
        });
        assertEquals("Hero passed in was null", exception.getMessage());
    }
	
	@Test
    void moveHero_throwsIllegalArgumentExceptionWhenPassedNullString_TRUE() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	Heros sutKey = Heros.Warrior;
            HeroFactory generateHero = new HeroFactory();
            Hero sut = generateHero.createHero(sutKey);
            dungeon.moveHero(sut, null);
        });
        assertEquals("String passed in was null", exception.getMessage());
    }
	
	@Test
	void manageEntrance_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            dungeon.manageEntrance(null);
        });
        assertEquals("Hero passed in was null", exception.getMessage());
    }
	
	@Test
	void displayVision_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            dungeon.displayVision(null);
        });
        assertEquals("Hero passed in was null", exception.getMessage());
    }
	
	@Test
	void setDungeon_throwsIllegalArgumentExceptionWhenPassedNullHero_TRUE() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            dungeon.setDungeon(null);
        });
        assertEquals("Dungeon passed in was null", exception.getMessage());
    }
}
