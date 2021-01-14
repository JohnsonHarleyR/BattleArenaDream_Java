
public class Enemy {
	// variables
	private int hp = 10; // the enemy starts with 10 hp, if it reaches 0 it dies
	
	
	// methods
	public boolean isAlive() {
		if (hp <= 0) { // it probably won't be less than 0 after changing the "setHP" method, but I'll leave it this way
			return false;
		} else {
			return true;
		}
	}
	
	// getters and setters
	
	// get the hp
	public int getHp() {
		return hp;
	}
	// set the hp
	public void setHp(int hp) {
		// if it's less than 0, set it to 0
		// otherwise leave it as it is
		if (hp < 0) {
			this.hp = 0;
		} else {
			this.hp = hp;
		}
		
	}
	
}
