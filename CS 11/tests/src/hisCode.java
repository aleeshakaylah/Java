import java.util.Scanner;

/**
 * All Java objects are stored on the heap. All values of complex type (i.e., not primitive, not
 * byte/short/int/long/float/double/boolean) are represented as *references* to objects. Multiple
 * references to the same object are common. Objects with no remaining references become "orphans",
 * and are "reaped" by the JVM's "garbage collector".
 * 
 * @author Jeffrey Bergamini for CMPS 11, jbergami@ucsc.edu
 */
public class hisCode {

  /**
   * Uses one of three different methods to mirror stdin to stdout, with randomized case for each
   * input character.
   * 
   * @param options options[0] is assumed to be either "1", "2", or "3"
   */
  public static void main(String[] options) {
    // Value of "choice": A 32-bit integer on the stack
    int choice = Integer.parseInt(options[0]);
    // Value of "stdin": A reference to a Scanner object (reference on stack; object on heap)
    Scanner stdin = new Scanner(System.in);
    while (stdin.hasNextLine()) {
      // Value of "line": A reference to a String object (reference on stack; object on heap)
      String line = stdin.nextLine();
      if (choice == 1)
        printEachCharacter(line);
      else if (choice == 2)
        concatenateAndPrint(line);
      else if (choice == 3)
        buildStringAndPrint(line);
      // "line" passes out of scope; orphaned String object will be reaped by garbage collector
    }
  }

  /**
   * Prints each character in a string to stdout, randomizing its case.
   * 
   * @param input a reference to the String object to be printed
   */
  static void printEachCharacter(String input) {
    for (int i = 0; i < input.length(); ++i)
      System.out.print(Math.random() < .5 ? Character.toUpperCase(input.charAt(i))
          : Character.toLowerCase(input.charAt(i)));
    System.out.println();
    // "input" passes out of scope; one fewer reference to that String object
  }

  /**
   * Assembles a duplicate of a string via concatenation, with each character's case randomized,
   * then prints the assembled string.
   * 
   * @param input a reference to the String object to be printed
   */
  static void concatenateAndPrint(String input) {
    String output = "";
    for (int i = 0; i < input.length(); ++i)
      // Concatenation creates a new string object; previous object is orphaned
      output += Math.random() < .5 ? Character.toUpperCase(input.charAt(i))
          : Character.toLowerCase(input.charAt(i));
    System.out.println(output);
    // "output" passes out of scope; orphaned String object will be reaped by garbage collector
    // "input" passes out of scope; one fewer reference to that String object
  }

  /**
   * Assembles a duplicate of a string via a StringBuilder, with each character's case randomized,
   * then prints the assembled string.
   * 
   * @param input a reference to the String object to be printed
   */
  static void buildStringAndPrint(String input) {
    StringBuilder output = new StringBuilder(input.length());
    for (int i = 0; i < input.length(); ++i)
      output.append(Math.random() < .5 ? Character.toUpperCase(input.charAt(i))
          : Character.toLowerCase(input.charAt(i)));
    System.out.println(output);
    // "output" passes out of scope; orphaned StringBuilder will be reaped by garbage collector
    // "input" passes out of scope; one fewer reference to that String object
  }

}

