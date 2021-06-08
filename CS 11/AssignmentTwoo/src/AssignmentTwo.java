import java.util.Scanner;

public class AssignmentTwo {
	public static void main(String[] args) {
		int[][] tallies = new int[8192][8192];
		int bigramCounter = 0;
		
		Scanner input = new Scanner(System.in);		
		while (input.hasNext()) {
			String token = input.next().toLowerCase();
			String[] tally = token.split(" ");
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
