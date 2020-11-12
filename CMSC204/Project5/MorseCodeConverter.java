import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Yared Fikremariam
 *
 */

public class MorseCodeConverter {

	public static MorseCodeTree tree = new MorseCodeTree();

	public MorseCodeConverter() {

	}

	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘).
	 * Each word is delimited by a ‘/’.
	 * 
	 * @param string the morse code
	 * @return
	 */
	public static String convertToEnglish(String string) {
		String o = "";
		String[] word, letter;

		word = string.split(" / ");

		for (int i = 0; i < word.length; i++) {
			letter = word[i].split(" ");

			for (int j = 0; j < letter.length; j++) {
				o += tree.fetch(letter[j]);
			}

			o += " ";
		}

		return o.trim();
	}

	/**
	 * Returns a string with all the data in the tree in LNR order with an space in
	 * between them.
	 * 
	 * @return a string with all the data in the tree in LNR order with an space in
	 *         between them.
	 */
	public static String printTree() {

		ArrayList<String> t = new ArrayList<String>();
		String o = "";
		t = tree.toArrayList();

		for (int i = 0; i < t.size(); i++) {
			o += t.get(i) + " ";
		}

		return o;
	}

	/**
	 * Converts Morse code into English.
	 * 
	 * @param inputFile
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File inputFile) throws FileNotFoundException {
		String o = "";
		String[] word, letter;
		ArrayList<String> l = new ArrayList<String>();

		Scanner in = new Scanner(inputFile);

		while (in.hasNext()) {
			l.add(in.nextLine());
		}

		in.close();

		for (int k = 0; k < l.size(); k++) {

			word = l.get(k).split(" / ");

			for (int i = 0; i < word.length; i++) {
				letter = word[i].split(" ");

				for (int j = 0; j < letter.length; j++) {
					o += tree.fetch(letter[j]);
				}

				o += " ";
			}
		}

		return o.trim();
	}

}
