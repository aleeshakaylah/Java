import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DnaSequence {

  /** We store the DNA as a simple char array. */
  private char[] dna;

  public DnaSequence(String sdna) {
     sdna=sdna.replaceAll("[^ATCG]", "");
     this.dna=sdna.toCharArray();
  }

  public DnaSequence(char[] cdna) {
    String sdna=new String(cdna);
    sdna=sdna.replaceAll("[^ATCG]", "");
    this.dna=sdna.toCharArray();
  }

  public DnaSequence(Path path) throws IOException {
    // TODO
    BufferedReader lenReader = Files.newBufferedReader(path, StandardCharsets.US_ASCII);
    String chars="";
    int c=lenReader.read();
    while (c != -1){
        chars=chars+((char)c);
        c=lenReader.read();
    }
    chars=chars.replaceAll("[^ATCG]", "");
    this.dna=chars.toCharArray();
  }

  public int length() {
      return dna.length;
  }

  /**
   * Returns a string representation of this sequence (for example, <code>"ATCCGTGGACT"</code>).
   * 
   * @return a <code>String</code> containing all nucleotides in this sequence, in order
   */
  public String toString() {
	String sequence = new String(this.dna);
    return sequence;
  }

  /**
   * Compares this sequence to another. The result is <code>true</code> if and only if this sequence
   * represents the same sequence of nucleotides as the other.
   * 
   * @param that the other sequence
   * @return whether this sequence represents the same sequence of nucleotides as the other
   */
  public char[] dnaTwo() {
	  return dna;
  }
  
  public boolean equals(DnaSequence that) {
	  if (this.dna.length == that.dnaTwo().length) {
	      for (int i = 0; i < this.dna.length; i++) {
	        if (this.dna[i] != that.dnaTwo()[i]) {
	          return false;
	        }
	      }
	      return true;
	    } else {
	      return false;
	    }
	  }

  /**
   * Returns the nucleotide base char value at the specified index. An index ranges from 0 to
   * length() - 1. The first base value of the sequence is at index 0, the next at index 1, and so
   * on, as for array indexing.
   * 
   * @param index the index of the base value
   * @return the base value at the specified index of this sequence. The first base value is at
   *         index 0.
   */
  public char baseAt(int index) {
	  if (index >= 0 && index <=(length()-1)){
		  return this.dna[index];
	  }
  }

  /**
   * Calculates and returns the number of times each type of nucleotide occurs in this DNA sequence.
   * 
   * @return an int array of length 4, where indices 0, 1, 2 and 3 contain the number of 'A', 'C',
   *         'G' and 'T' characters (respectively) in this sequence
   */
  public int[] nucleotideCounts() {
	  int numOfAs = 0;
	  int numOfCs = 0;
	  int numOfGs = 0;
	  int numOfTs = 0;
	  
	  for (int i = 0; i < this.dna.length; i++) {
		  if (this.dna[i] == 'A') {
	        numOfAs++;
	      } else if (this.dna[i] == 'C') {
	        numOfCs++;
	      } else if (this.dna[i] == 'G') {
	        numOfGs++;
	      } else {
	        numOfTs++;
	      }
	    }
	  
	  int [] numOfNucleotides = {numOfAs, numOfCs, numOfGs, numOfTs};
      
    return numOfNucleotides;
  }

  /**
   * Calculates and returns the reverse complement of this DNA sequence as a new DnaSequence. In DNA
   * sequences, 'A' and 'T' are complements of each other, as are 'C' and 'G'. The reverse
   * complement is formed by reversing the symbols of a sequence, then taking the complement of each
   * symbol (e.g., the reverse complement of "GTCA" is "TGAC").
   * 
   * @return a new DnaSequence representing the reverse complement of this sequence
   */
  public DnaSequence reverseComplement() {
	  char [] temp = new char[dna.length];
	  String complement = new String(temp);
	  String reverse = "";
	  int length = complement.length();
		for (int i = length - 1; i >= 0; i--) {
			reverse = reverse + complement.charAt(i);
		}
    return null; // TODO
  }

  /**
   * Calculates and returns the GC-content of this DNA sequence. The GC-content of a DNA sequence is
   * given by the percentage of symbols in the string that are 'C' or 'G'. For example, the
   * GC-content of "AGCTATAG" is .375 (37.5%).
   * 
   * @return the GC-content of this sequence, to double precision
   */
  public double gcContent() {
    return 0; // TODO
  }

  /**
   * Calculates and returns the Hamming distance between this DNA sequence and another. The Hamming
   * distance between two sequences is the number of points in the sequences where the corresponding
   * symbols differ. For example, the Hamming distance between <code>"ATTATGC"</code> and
   * <code>"ATGATCC"</code> is 2.
   * 
   * @param that the other sequence
   * @return the Hamming distance between this sequence and the other, or -1 if the two sequences
   *         are of unequal length
   */
  public int hammingDistance(DnaSequence that) {
    return 0; // TODO
  }

  /**
   * Calculates and returns where two DNA sequences of equal lengths differ. For example, given
   * sequences "ATGT" and "GTGA", the result should be array
   * <code>{ true, false, false, true }</code>.
   * 
   * @param that the other sequence
   * @return an array of <code>boolean</code> values, of length equivalent to both sequences'
   *         lengths, containing <code>true</code> in each index where the two sequences differ, and
   *         false where they do not differ. If the two sequences are of unequal length, this method
   *         returns <code>null</code>.
   */
  public boolean[] mutationPoints(DnaSequence that) {
    return null; // TODO
  }

  /**
   * Mutator method that flips one base of this sequence to its complement. In DNA sequences, 'A'
   * and 'T' are complements of each other, as are 'C' and 'G'. For example, if <code>feline</code>
   * is a reference to a <code>DnaSequence</code> object representing the sequence
   * <code>"GATCAT"</code>, then subsequent to invocation <code>feline.complement(0)</code>, the
   * represented sequence shall be <code>"CATCAT"</code>.
   * 
   * @param index the index at which to perform the complement
   */
  public void complement(int index) {
	  char c = this.dna[index];
	    if (c == 'A') {
	      this.dna[index] = 'T';
	    } else if (c == 'C') {
	      this.dna[index] = 'G';
	    } else if (c == 'T') {
	      this.dna[index] = 'A';
	    } else if (c == 'G') {
	      this.dna[index] = 'C';
	    }
  }
}
