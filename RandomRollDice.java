import java.util.Random;//imports random
import java.util.Scanner;//imports scanner

public class RandomRollDice {

	private static Scanner input;

	public static void main(String args[]) {

		input = new Scanner(System.in);
		Random r = new Random();

		int[] frequency = new int[12];// Array that holds the number times that
										// a dice is rolled

		int TimesDiceRolled;
		int temp;//swapping the elements

		System.out.println("How many times would you like to roll the dice?");
		TimesDiceRolled = input.nextInt();//asks the user how many times do their dices to be rolled

		for (int i = 0; i < TimesDiceRolled; i++) {
			temp = r.nextInt(12);
			frequency[temp]++;
		}

		System.out.println("Roll Dice " + "Sum " + "Frequencies");
		// Loop that iterates through the numbers of times that a dice can be
		// rolled
		for (int i = 0; i < 12; i++) {
			System.out.println(i + 1 + "\t" + frequency[i]);// prints the dice frequency.
		}
	}
}
