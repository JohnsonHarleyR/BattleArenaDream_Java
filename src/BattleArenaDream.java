import java.util.Scanner;

public class BattleArenaDream {

	public static void main(String[] args) {
		
		// variables
		Scanner scan = new Scanner(System.in);
		
		// Intro title
		System.out.println("***BATTLE ARENA DREAM***\n");
		
		// The dream runs an infinite loop so the user must close the app in order to exit.
		while (true) {
			
			// start a new round
			
			// set variables for this round
			int turns = 10; // round continues as long as there are turns left
			Player player = new Player(); // the user/player
			Enemy enemy = new Enemy(); // the enemy the user is fighting
			Dice dice = new Dice(); // the dice to roll
			
			System.out.println("You are trapped in a dream!");
			
			
			// this loop will go as long as user has not died and they are not out of turns
			while (turns > 0 && player.isAlive() == true) {
				showStats(player, enemy); // show player stats
				
				// put a pause so the player can read what's happening
				System.out.println("\n(Hit enter to roll the dice.)");
				scan.nextLine();
				
				// roll the dice
				dice.rollDice();
				
				// check the outcome
				getOutcome(player, enemy, dice, scan);
				
				// see if enemy has been defeated
				
			}
			
			// once the user has died, tell the player they have died and to start everything over
			System.out.println("You have died! The dream is starting all over again.");
			System.out.println("Will it ever end...?\n");
			
			
		}
		

	}
	
	// show player stats
	public static void showStats(Player player, Enemy enemy) {
		System.out.println("\n*Stats*");
		System.out.println("Stamina: " + player.getStamina());
		System.out.println("Panic level: " + player.getPanic());
		System.out.println("Enemy HP: " + enemy.getHp());
	}
	
	public static void getOutcome(Player player, Enemy enemy, Dice dice, Scanner scan) {
		// determine the outcome by what the player rolled
		int diceRoll = dice.getDiceRoll();
		switch (diceRoll) {
		case 1:
			System.out.println("You're hit!\nYour panic increases by 2.");
			player.setPanic(player.getPanic() + 2);
			break;
		case 2:
			System.out.println("You dodge the attack!\nStill, you hurt yourself so your stamina " +
					"decreases by 1.");
			player.setStamina(player.getStamina() - 1);
			break;
		case 3:
			System.out.println("You deflect the attack!\nNothing happens.");
			break;
		case 4:
			System.out.println("The enemy backs away!\nYour stamina increases by 1.");
			player.setStamina(player.getStamina() + 1);
			break;
		case 5:
			System.out.println("The enemy dodges, but you strike a glancing blow!" +
					"\nYour panic reduces by 1. The enemy loses 3 hit points.");
			player.setPanic(player.getPanic() - 1);
			enemy.setHp(enemy.getHp() - 3);
			break;
		case 6:
			System.out.println("*WHACK* The enemy takes significant damage!" +
					"\nYour panic reduces by 3. Your stamina increases by 2. The enemy loses 5 hit points.");
			player.setPanic(player.getPanic() - 3);
			player.setStamina(player.getStamina() + 2);
			enemy.setHp(enemy.getHp() - 5);
			break;
		default:
			System.out.println("ERROR - not a number 1 through 6");
		}
		/*
		System.out.println("\n(Hit enter to continue.)");
		scan.nextLine();
		*/
	}
	

}

/* Instructions
 * For this exercise, you are going to trap your user in a dream loop. The dream will repeat over and over. 
 * There is no way to escape it except to close the application

Set-Up

In the dream, the user finds themselves trapped in a battle arena. They have two stats that determine their survival
1. Stamina – starts at 10. If it reaches 0, the user dies
2. Panic Level – starts at 10. If it reaches 20, the user dies

In the arena, the user must battle enemies. The enemy starts with 10 hit points and dies when that reaches 0. 


Dice Roll
The user does battle by rolling a die each turn (int diceRoll = new Random().Next(1, 7);). 

The following list details the effect of each roll.


1 – The user gets hit, and their panic level increases by 2
2 – The user dodges the attack, but their stamina is reduced by 1
3 – The user deflects the attack. There is no stat change
4 – The enemy backs away; the user’s stamina increases by 1
5 – The enemy dodges, but the user strikes a glancing blow. The user’s panic is reduced by 1. The enemy loses 3 hit points. 
6 – The enemy takes significant damage. The user’s panic is reduced by 3. Their stamina is increased by 2. The enemy loses 5 hit points. 


The user has 10 rolls of the die to defeat the enemy. 


Battle Results

After every roll, if the enemy has not died, the user’s panic increases by 1. Their stamina is reduced by 1. 
If the enemy has died, another enemy enters the arena. The player’s panic and stamina stay where it is. 
If the player has run out of turns, their panic reaches the max level. 
If the player has died, the dream starts over from the beginning. 


Final Instructions

Coding is supposed to be fun, so get creative and have a good time with this. Share your GitHub link when your done so 
I can see what you came up with.
 */
