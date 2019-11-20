package monsters;

/**
 * Title: Description: Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster {

	public Skeleton(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin,
			int damageMax, int minHeal, int maxHeal, MonsterType type) {
		super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, damageMin, damageMax,
				type);

	}// end constructor

}// end class Skeleton