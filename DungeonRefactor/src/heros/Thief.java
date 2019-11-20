package heros;
import common.AttackResult;
import common.DungeonCharacter;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Thief extends Hero
{

    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5, HeroType.THIEF);



    }//end constructor

	@Override
	public AttackResult specialAttack(DungeonCharacter opponent) {
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								name + " gets an additional turn.");
			this.incrementTurnCount();
			return attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    return attack(opponent);
		return new AttackResult(0, false);
	}

}