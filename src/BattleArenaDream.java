import java.util.Scanner;

public class BattleArenaDream {

	public static void main(String[] args) {
		
		// Variables
		Scanner scan = new Scanner(System.in);
		String[] diceFront = new String[] { // To get the circles lined perfectly, they would be too large.
				" _________ \n"				// This is good for now. (Java didn't want to accept an overline char.)
			  + "|         |\n"
			  + "|         |\n"
			  + "|    O    |\n"
			  + "|         |\n"
			  + "|_________|",
			  			" _________ \n"
					  + "|         |\n"
					  + "| O       |\n"
					  + "|         |\n"
					  + "|       O |\n"
					  + "|_________|",
					            " _________ \n"
							  + "|         |\n"
							  + "| O       |\n"
							  + "|    O    |\n"
							  + "|       O |\n"
							  + "|_________|",
							  			" _________ \n"
									  + "|         |\n"
									  + "| O     O |\n"
									  + "|         |\n"
									  + "| O     O |\n"
									  + "|_________|",
									  			" _________ \n"
											  + "|         |\n"
											  + "| O     O |\n"
											  + "|    O    |\n"
											  + "| O     O |\n"
											  + "|_________|",
											  			" _________ \n"
													  + "|         |\n"
													  + "| O     O |\n"
													  + "| O     O |\n"
													  + "| O     O |\n"
													  + "|_________|",
		};
		String[] endings = new String[] {"...Will this ever end?", "Is fighting your purpose in life?",
				"An existential crisis sets in as you wonder why this won't end.", 
				"Why does he bring you back to die again?\nYou're getting too deep so you shake yourself out of it.",
				"If this is a dream, it's more like a nightmare.", "Does he expect you to do this all on your own?",
				"If he has so much power, why are you the one fighting?",
				"You ask, \"Hey, could I get some help?\" The grim reaper shakes his head.", 
				"How many enemies must you defeat? How many lives must you live?",
				"You wonder if you'll get a prize at some point.",
				"You tell him that you're more of a philosopher than a fighter, but the grim reaper shrugs.",
				"\"What happens if I refuse to kill more?\", you ask."
				+ "\n\"You die,\" he replies. \"Oh...\" You let out a sigh."};
		
		// Intro title
		System.out.println(" __       ___ ___       ___          __   ___           \r\n" + 
				"|__)  /\\   |   |  |    |__      /\\  |__) |__  |\\ |  /\\  \r\n" + 
				"|__) /~~\\  |   |  |___ |___    /~~\\ |  \\ |___ | \\| /~~\\ \n");
		
		System.out.println("You open your eyes to see a sword in one hand and a shield in the other. You hear cheering.");
		System.out.println("How strange, you look around to see you are standing in an arena with no crowd.");
		System.out.println("\nIs this real life or a dream?");
		
		//System.out.println(diceFront[0]);// test
		
		// The dream runs an infinite loop so the user must close the app in order to exit.
		while (true) {
			
			
			// start a new round
			
			// set variables for this round
			int turns = 10; // round continues as long as there are turns left
			Player player = new Player(); // the user/player
			Enemy enemy = new Enemy(); // the enemy the user is fighting
			Dice dice = new Dice(); // the dice to roll
			String death = "\nYou have been killed!"; // this is the default unless panic increases to 20
			
			
			
			// this loop will go as long as user has not died and they are not out of turns
			while (player.isAlive() == true) {
				showStats(player, enemy, turns); // show player stats
				
				// see if enemy has been defeated, replace it with a new one if it's dead
				// putting it here so that the player can see the enemy HP go to 0
				if (!enemy.isAlive()) {
					System.out.println("\nThe enemy falls to its death!\nA gate rumbles opens to reveal another menacing goblin." +
							"\n...How many must you kill before this ends?");
					enemy = new Enemy();
				}
				
				// put a pause so the player can read what's happening
				if (turns == 10) { 
					// only show this on first turn
					System.out.println("\nAn angry goblin in armor stands before you.\n(Hit enter to roll for an attack.)"); 
				} else {
					System.out.println("\nYou have " + turns + " turns left.\n(Hit enter to roll for an attack.)");
				}
				scan.nextLine();
				
				// roll the dice
				dice.rollDice();
				// display the result
				System.out.println(diceFront[dice.getDiceRoll() - 1] + "\n");
				//System.out.println("You roll a " + dice.getDiceRoll() + "!\n");
				
				// check the outcome
				getOutcome(player, enemy, dice);
				
				// subtract from turns
				turns --;
				
				// check if they ran out of turns, if so set the panic to 20
				if (turns <= 0 && player.getStamina() != 0) {
					player.setPanic(20);
					System.out.println("\nThis has gone on too long! Your panic increases to 20!");
					death = "\nYou die of a heart attack! Where's the doctor?";
				}
				
				
			}
			
			showStats(player, enemy, turns); // show player stats
			
			// once the user has died, tell the player they have died and to start everything over
			System.out.println(death); // tells them the cause of death
			System.out.println("Suddenly, the grim reaper appears to bring you back to life.");
			System.out.println("\n" + endings[(int)(Math.random() * endings.length)]);
			//System.out.println("Will it ever end...?\n");
			
			System.out.println("\n(Hit enter to continue.)");
			scan.nextLine();
			
			System.out.println("You must fight!");
			
			
			//scan.close(); // still causes errors if I close the scanner during the loop
		}
		
	}
	
	
	// show player stats
	public static void showStats(Player player, Enemy enemy, int turns) {
		if (turns == 10) {
			System.out.println("\n*Your Stats*"); // only on first turn
		} else {
			System.out.println("\n*New Stats*");
		}
		System.out.println("Stamina: " + player.getStamina());
		System.out.println("Panic level: " + player.getPanic());
		System.out.println("Enemy HP: " + enemy.getHp());
		//System.out.println("\nYou have " + turns + " turns left.");
	}
		
		
	// get the outcome of a dice roll
	public static void getOutcome(Player player, Enemy enemy, Dice dice) {
		// determine the outcome by what the player rolled
		int diceRoll = dice.getDiceRoll();
		switch (diceRoll) {
		case 1:
			System.out.println("The enemy smirks as he taunts you. He seeks to intimidate."
					+ "\nIt works. Your panic increases by 2.");
			player.setPanic(player.getPanic() + 2);
			break;
		case 2:
			System.out.println("The enemy attacks! You dodge, but he strikes anyway!\nYour stamina " +
					"decreases by 1.");
			player.setStamina(player.getStamina() - 1);
			//player.setStamina(player.getStamina() - 15); // to test what happens when they run out of stamina
			break;
		case 3:
			System.out.println("The enemy strikes, but you block the attack!\nNothing else happens.");
			break;
		case 4:
			System.out.println("You let out a beastly growl. The enemy backs away!\nYour stamina increases by 1.");
			player.setStamina(player.getStamina() + 1);
			break;
		case 5:
			System.out.println("You swing your sword. The enemy dodges, but you strike anyway!" +
					"\nYour panic reduces by 1. The enemy loses 3 hit points.");
			player.setPanic(player.getPanic() - 1);
			enemy.setHp(enemy.getHp() - 3);
			break;
		case 6:
			System.out.println("*THWACK* You swing fast to strike a critical blow with your sword!" +
					"\nYour panic reduces by 3. Your stamina increases by 2. The enemy loses 5 hit points.");
			player.setPanic(player.getPanic() - 3);
			player.setStamina(player.getStamina() + 2);
			enemy.setHp(enemy.getHp() - 5);
			break;
		default:
			System.out.println("ERROR - not a number 1 through 6");
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
