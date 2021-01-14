import java.util.Scanner;

public class GameMethods {

	// show player stats
	public void showStats(Player player, Enemy enemy, int turns) {
		System.out.println("\n*Stats*");
		System.out.println("Stamina: " + player.getStamina());
		System.out.println("Panic level: " + player.getPanic());
		System.out.println("Enemy HP: " + enemy.getHp());
		System.out.println("Turns left: " + turns);
	}
	
	
	// get the outcome of a dice roll
	public void getOutcome(Player player, Enemy enemy, Dice dice, Scanner scan) {
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
			//player.setStamina(player.getStamina() - 15); // to test what happens when they run out of stamina
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
