import java.util.Random;//imports random math function

public class RandomDice1 {

	public static void main(String[] args) {
		int number;

		Random dice = new Random();// random function

		number = 1 + dice.nextInt(6);// function which only lets you print the numbers between 1 to 6

		RandomRollDice(number);//function that gives a random number when a dice is rolled.

	}

	public static void RandomRollDice(int RandomRollDice) {

		System.out.println("the random for the roll dice number is = " + RandomRollDice);// prints out the random number when the dice is rolled.

	}

}
