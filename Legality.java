import java.io.FileNotFoundException;
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
Class Legality is in charge of checking whether or not the word played is legal, as well as any attached words, ie a play is legal.
 */

public class Legality {
    // Legality is expected to receive a String and return a boolean. True if the
    // word is legal, false if it is not.

    private String word;
    private HashSet<String> legal_words = new HashSet<String>();
    private String file_path = "Words/english_words.txt";

    public Legality(String word) {
        this.word = word;
    }

    private boolean check_word_legality(String word) {
        // check if the word is in the dictionary
        if (legal_words.contains(word)) {
            return true;
        } else {
            return false;
        }
    }

    private void create_word_list(String file_path) {
        // create a list of all legal words
        // this will be done by reading a file

        // read file Words/english_words.txt
        // add each word to legal_words
        try {
            File word_file = new File(file_path);
            Scanner word_scanner = new Scanner(word_file);
            while (word_scanner.hasNextLine()) {
                String word = word_scanner.nextLine();
                legal_words.add(word);
            }
            word_scanner.close();
            System.out.println("Successfully read from file. \n" + legal_words.size()
                    + " Legal words have been added to the list.");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    // needed for Score
    private boolean check_position_legality(String input) {
        // TODO: unsure how to check as board is incomp.
        return false;
    }

    private boolean check_final_legality(String input) {
        // only true if check_word_legality and check_position_legality are both true
        if (check_word_legality(input) && check_position_legality(input)) {
            return true;
        } else {
            return false;
        }
    }

    // public static void main(String[] args) {
    // // test reading from file
    // String file_path = "Words/english_words.txt";
    // Legality legality = new Legality("test");
    // legality.create_word_list(file_path);
    // // test checkWord
    // String word = "test";
    // System.out.println("Is " + word + " a legal word? " +
    // legality.checkWord(word));

    // }
}
