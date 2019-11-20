package common;

public class AttackResult {
	
	private int damageDone;
	private boolean couldAttack;
//	private boolean wasCriticalHit;
	
	public AttackResult(int damageDone, boolean couldAttack) {
		this.damageDone = damageDone;
		this.couldAttack = couldAttack;
//		this.wasCriticalHit = wasCriticalHit;
	}
	
	public int getDamageDone() {
		return this.damageDone;
	}
	
	public boolean getCouldAttack() {
		return this.couldAttack;
	}

}
