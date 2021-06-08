import java.util.Scanner;
/**
*Assignment Two: Letter Bigrams
*
*@author Aleesha Nageer for CMPS 11, anageer@ucsc.edu
*
*/

public class testProgram {
  /**
  *This program is designed to divide user inputted strings
  *into bigrams and prints out those bigrams on individual
  *lines. It also prints out how many times those bigrams
  *occur as well as the probability of the bigram occurring.
  */
  public static void main(String[] args) {
    int[][] tallies = new int[8192][8192];
    int bigramCounter = 0;
    Scanner input = new Scanner(System.in);
    while (input.hasNext()) {
      String token = input.next().toLowerCase();
      String[] tally = token.split(" ");
      /**
      *This function splits each word in the user inputted
      *strings into individual strings and places them into
      *an array.
      */
      for (String word : tally) {
        char [] letters = word.toCharArray();
        for (int i = 0; i < letters.length - 1; i++) {
          char first = letters[i];
          char second = letters[i + 1];
          if (Character.isLetter(first) && Character.isLetter(second)) {
            tallies [(int)first][(int)second]++;
            bigramCounter++;
          }
        }
        /**
         *This for loop goes through each letter of the string
         *and places it into a character array. Then, it looks at
         *the first and second letters, places them in the 2D
         *array called tallies. Lastly, it counts how many bigrams
         *total there are as well as how many of each bigram.
         */
      }
    }
    for (int i = 0; i < 8192; i++) {
      for (int j = 0; j < 8192; j++) {
        int numOfOcc = tallies[i][j];
        if (numOfOcc > 0) {
          String convertI = Character.toString((char)i);
          String convertJ = Character.toString((char)j);
          System.out.printf(convertI + convertJ +  "\t");
          System.out.printf(numOfOcc + "\t");
          double probability = (double)numOfOcc / bigramCounter;
          System.out.printf("%.10f\n", probability);
        }
      }
    }
  }
}
