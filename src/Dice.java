//import java.util.Scanner;

//You roll the dice to play the game
public class Dice {
	
	// variables
	//Scanner scan = new Scanner(System.in);
	private int diceRoll = 0; // if the game says 0, that indicates an error
	
	// methods
	
	// roll the dice
	public void rollDice() {
		/*
		System.out.println("\nRoll dice? \n(hit enter)");
		scan.nextLine();
		*/
		diceRoll = (int) (Math.random() * 6) + 1;
	}
	
	// getters and setters
	public int getDiceRoll() {
		return diceRoll;
	}

	public void setDiceRoll(int diceRoll) {
		this.diceRoll = diceRoll;
	}

}
