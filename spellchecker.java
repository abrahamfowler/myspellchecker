
/* The spell checker takes around 25 seconds to find the spelling errors inside the input so please be be patient*/
import java.io.*;
import java.util.Scanner; //imports scanner
import java.io.IOException;//imports IOException 
import java.util.ArrayList;//Imports array list for the Dictionary

public class spellchecker {
	public static void main(String[] args) throws IOException {

		int wordsInsideDictionary = 0;// Initializes the integer variable for
										// the number of words inside the
										// Dictionary File.

		Scanner user = new Scanner(System.in);// Creates scanner object for the
												// users to input.

		System.out.print("Please Enter the input file name:");// Prompts the
																// user to input
																// their file
																// name.

		String FileName = user.next().trim();// Initializes String variable and
												// assigns for the fileName
		System.out.println("Loading.. please be patient ");// since my program
															// takes a long time
															// to
		// output i don't want the user to think
		// its not printing.
		String dictionaryFileName = "dictionary.txt";// Initializes String
														// variable and assign
														// for the
														// dictionaryFileName
		Scanner dictionaryFile = new Scanner(new File(dictionaryFileName));// Creates
																			// a
																			// new
																			// Scanner
																			// object
																			// to
																			// scan
																			// the
																			// dictionary
																			// file
		Scanner inputFile = new Scanner(new File(FileName));// Creates a new
															// scanner object
															// and scans for the
															// input file
		String nextWordsDictionary;// Initializes the variable for
									// nextWordsDictionary

		ArrayList<String> dictionary = new ArrayList<String>();// initializes
																// the array
																// list for the
																// Dictionary
		File outputFile = new File("output.txt");// creates a new file object
													// with the filename
													// output.txt where once the
													// input process through the
													// dictionary it dumps the
													// correct version there.
		PrintWriter printToOutput = new PrintWriter(new FileOutputStream(outputFile, true));// creates
																							// new
																							// PrintWriter
																							// object
																							// to
																							// print
																							// to
																							// the
																							// output
																							// file
		PrintWriter printToDictionary = new PrintWriter(new FileOutputStream(dictionaryFileName, true));// create
																										// a
																										// new
																										// PrintWriter
																										// object
																										// to
																										// print
																										// to
																										// the
																										// dictionary
		while (dictionaryFile.hasNextLine()) {// while the dictionary has
												// another line
			// nextwordsDictionary is assigned to the word on the current line
			nextWordsDictionary = dictionaryFile.nextLine();
			// increases the wordsInsideDictionary variable by 1
			wordsInsideDictionary++;

			dictionary.add(nextWordsDictionary);// Adds next word inside the
												// Dictionary to the Dictionary
												// array list
		}
		while (inputFile.hasNext()) { // Initializes the String and assigns the
										// Word to be the next word that the
										// Scanner reads.

			String Word = inputFile.next();

			String CutWord = Word.replaceAll("\\w", "");// cuts the word of all
														// the punctuation
														// inside the input file
														// and adds it to the
														// text inside the
														// output file
			String Wordv2 = Word.replaceAll("\\W", "");
			String a;
			a = soundExProgoram(Wordv2);

			scanDictionaryLoop: for (int i = 0; i < wordsInsideDictionary; i++) {// this
																					// function
																					// labels
																					// the
																					// name
																					// to
																					// break
																					// out
																					// from
																					// the
																					// switch
																					// statement
																					// and
																					// for
																					// loop
				String b;
				b = soundExProgoram(dictionary.get(i));
				if (dictionary.contains(Wordv2.toLowerCase())) {
					printToOutput.print(Word + " ");
					break;
				}

				if (!Wordv2.toLowerCase().equalsIgnoreCase(dictionary.get(i)) && a.equals(b)) {
					System.out.print("For " + Wordv2 + " did you mean " + dictionary.get(i) + "?");
					switch (user.next()) {
					case "y":
						printToOutput.print(dictionary.get(i) + CutWord + " ");
						break scanDictionaryLoop;
					case "n":
						break;

					case "add":
						printToDictionary.print(Wordv2.toLowerCase() + "\n");
						printToOutput.print(Word + CutWord + " ");
						break scanDictionaryLoop;
					default:
						i--;
					}
				}

			}
			// scans for the next word
		}
		printToOutput.close();
		printToDictionary.close();
		System.out.println("The program has now finished, please check your output file "); /*
																							 * lets
																							 * the
																							 * user
																							 * know
																							 * that
																							 * the
																							 * program
																							 * has
																							 * now
																							 * finished
																							 */
	}

	public static String soundExProgoram(String input) {// Initializes an array
														// consisting of upper
														// case letters of the
														// input

		char[] code = input.toUpperCase().toCharArray();
		/*
		 * Initializes character variable firstLetter and assign it to the first
		 * character in the character array of the input string
		 */
		char firstLetter = code[0];
		// Initializes string variable output and assign the first character
		// from
		// the input to the output
		String output = "" + firstLetter;
		// for loop to iterate through the code array
		for (int i = 0; i < code.length; i++) {
			switch (code[i]) {

			case 'B':
			case 'F':
			case 'P':
			case 'V':
				code[i] = '1';
				break;

			case 'C':
			case 'G':
			case 'J':
			case 'K':
			case 'Q':
			case 'S':
			case 'X':
			case 'Z':
				code[i] = '2';
				break;

			case 'D':
			case 'T':
				code[i] = '3';
				break;

			case 'L':
				code[i] = '4';
				break;

			case 'M':
			case 'N':
				code[i] = '5';
				break;

			case 'R':
				code[i] = '6';
				break;

			default:
				code[i] = '0';
				break;
			}
		}
		/*
		 * If contents at position i of code does not equal the contents at
		 * position i-1 and its not a 0 then add the number to the output string
		 * This is to avoid duplicates
		 */
		for (int i = 1; i < code.length; i++) {
			if (code[i] != code[i - 1] && code[i] != '0') {
				output += code[i];
			}
		}
		/*
		 * if the output string is less than four characters long and the for
		 * loop has reached the end of array then attach 4four 0's to the output
		 * string
		 */
		output += "0000";

		// Returns the output string
		return output.substring(0, 4);
	}

}