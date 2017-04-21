public class SoundEX { 
    public static String SoundEx(String s) { 
        char[] x = s.toUpperCase().toCharArray();
        char firstLetter = x[0];

        // converts all letters to numeric code
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {

                case 'B': case 'F': case 'P': case 'V':
                    x[i] = '1';
                    break;

                case 'C': case 'G': case 'J': case 'K': case 'Q': case 'S': case 'X': case 'Z':
                    x[i] = '2';
                    break;

                case 'D': case 'T':
                    x[i] = '3';
                    break;

                case 'L':
                    x[i] = '4';
                    break;

                case 'M': case 'N':
                    x[i] = '5';
                    break;

                case 'R':
                    x[i] = '6';
                    break;

                default:
                    x[i] = '0';
                    break;
            }
        }

        // This is to avoid duplicates
        String output = "" + firstLetter;
        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i-1] && x[i] != '0')
                output += x[i];

     /* if the output string is less than 4 characters long and if the for loop 
      has reached it's end of  array then adds on 0's to the output string*/
        output = output + "0000";
        return output.substring(0, 4);
    }
 /*class for the SoundEx to print which prints out the all the letters in to numeric numbers/code */
    	public static void main(String[] args) {
            String Name1 = "Niranjan"; // strings which i have written a letter which eventually prints it out in to numeric code
            String Name2 = "Leklapoodi";// strings which i have written a letter which eventually prints it out in to numeric code
            String Name3 = "Mohamed";// strings which i have written a letter which eventually prints it out in to numeric code
            String Name4 = "Abraham";// strings which i have written a letter which eventually prints it out in to numeric code
            String Name5 = "Adonay";// strings which i have written a letter which eventually prints it out in to numeric code
            String Name6 = "Kane";// strings which i have written a letter which eventually prints it out in to numeric code
            String Name7 = "Armaan";// strings which i have written a letter which eventually prints it out in to numeric code
            String code1 = SoundEx(Name1);
            String code2 = SoundEx(Name2);
            System.out.println(code1 + ": " + Name1);
            System.out.println(code2 + ": " + Name2);
            System.out.println(code1 + ": " + Name3);
            System.out.println(code2 + ": " + Name4);
            System.out.println(code1 + ": " + Name5);
            System.out.println(code2 + ": " + Name6);
            System.out.println(code2 + ": " + Name7);
        }

    }