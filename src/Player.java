// this holds the player information
public class Player {
	
	private int stamina = 10; // starts at 10, it it reaches 0 the user dies
	private int panic = 10; // starts at 10, if it reaches 20 the user dies
	
	
	// regular methods
	
	// check if the user is alive
	public boolean isAlive() {
		if (stamina > 0 && panic < 20) {
			return true;
		} else {
			return false;
		}
	}
	
	// get and set methods
	public int getStamina() {
		return stamina;
	}
	
	public void setStamina(int stamina) {
		// if it's less than 0, set it to 0
		// otherwise leave it as it is
		if (stamina < 0) {
			this.stamina = 0;
		} else {
			this.stamina = stamina;
		}
		
	}
	
	public int getPanic() {
		return panic;
	}
	
	public void setPanic(int panic) {
		// if it's greater than 20, set it to 20 - (not necessary, actually)
		// or if it's less than 0, set it to 0
		// otherwise leave it as it is
		/*if (panic > 20) {
			this.panic = 20;
		} else */ 
		if (panic < 0) {
			this.panic = 0;
		} else {
			this.panic = panic;
		}
	}
}
