// this holds the player information
public class Player {
	int stamina = 10; // starts at 10, it it reaches 0 the user dies
	int panic = 10; // starts at 10, if it reaches 20 the user dies
	
	
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
		//System.out.println("Player stamina: " + stamina); // test
		this.stamina = stamina;
		
	}
	
	public int getPanic() {
		return panic;
	}
	
	public void setPanic(int panic) {
		this.panic = panic;
	}
}
