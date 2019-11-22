public class CrushingBlow implements SpecialAbility {
	public void special(DungeonCharacter source, DungeonCharacter enemy) {
		if (Math.random() <= .4)
		{
			int damage = (int)(Math.random() * 76) + 100;
			System.out.println(source.getName() + " lands a CRUSHING BLOW for " + damage
								+ " damage!");
			enemy.subtractHitPoints(damage);
		}//end blow succeeded
		else
		{
			System.out.println(source.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed
	}
	
	public String specialDesc() {
		return "Crushing Blow";
	}
}
