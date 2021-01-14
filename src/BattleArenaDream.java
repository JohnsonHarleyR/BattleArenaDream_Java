import java.util.Scanner;

public class BattleArenaDream {

	public static void main(String[] args) {
		
		// variables
		Scanner scan = new Scanner(System.in);
		GameMethods methods = new GameMethods();
		
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
			String death = "\nYou ran out of stamina."; // this is the default unless panic increases to 20
			
			System.out.println("You are trapped in a dream!");
			
			
			// this loop will go as long as user has not died and they are not out of turns
			while (player.isAlive() == true) {
				methods.showStats(player, enemy, turns); // show player stats
				
				// see if enemy has been defeated, replace it with a new one if it's dead
				// putting it here so that the player can see the enemy HP go to 0
				if (!enemy.isAlive()) {
					System.out.println("\nThe enemy is defeated!\nAnother one takes its place." +
							"\n...Will it ever end?");
					enemy = new Enemy();
				}
				
				// put a pause so the player can read what's happening
				System.out.println("\n(Hit enter to roll the dice.)");
				scan.nextLine();
				
				// roll the dice
				dice.rollDice();
				
				// check the outcome
				methods.getOutcome(player, enemy, dice, scan);
				
				// subtract from turns
				turns --;
				
				// check if they ran out of turns, if so set the panic to 20
				if (turns <= 0) {
					player.setPanic(20);
					System.out.println("\nYou are out of turns, so your panic increases to 20!");
					death = "\nYour panic level is too high.";
				}
				
				
			}
			
			methods.showStats(player, enemy, turns); // show player stats
			
			// once the user has died, tell the player they have died and to start everything over
			System.out.println(death); // tells them the cause of death
			System.out.println("You have died! The dream is starting all over again.");
			System.out.println("Will it ever end...?\n");
			
			System.out.println("\n(Hit enter to continue.)");
			scan.nextLine();
			
			//scan.close();
			
		}

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
