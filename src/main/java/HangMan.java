import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangMan {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Hangman\n");
        System.out.println(" ________");
        System.out.println(" |      |");
        System.out.println(" O      |");
        System.out.println("\\ /     |");
        System.out.println(" |      |");
        System.out.println("/ \\     |");
        System.out.println("       ===\n");
        System.out.println("One player or two players? (1 or 2)");

        String word;
        Scanner keyboard = new Scanner(System.in);
        String player = keyboard.nextLine();

        if (player.equals("1")) {
            Scanner scanner = new Scanner(new File("words.txt"));
            List<String> words = new ArrayList<>();
            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            word = words.get(new Random().nextInt(words.size()));
        } else {

            System.out.println("Player 1, please enter your word:");
            word = keyboard.nextLine();

            String new_line = "\n";
            System.out.println(new_line.repeat(100));
        }

        //System.out.println(word); // debug: print the word

        int word_length = word.length();

        List<Character> playerGuesses = new ArrayList<>();
        int wrongCount = 0;

        System.out.println("Guess a letter or the word: (" + word_length + " characters)");
        printHangedMan(wrongCount);
        printWordState(word, playerGuesses);

        while (true) {

            String input = keyboard.nextLine();
            System.out.println("wrongCount: " + wrongCount);
            if (wrongCount >= 7) {
                System.out.println("\u001B[31m" + "YOU LOSE! THE WORD WAS " + word + ". \u001B[0m");
                break;
            } else if (input.length() > 1) {
                if (input.equals(word)) {
                    System.out.println("\u001B[32m" + "YOU WIN!" + "\u001B[0m");
                    break;
                } else {
                    System.out.println("\u001B[31m" + "INCORRECT!" + "\u001B[0m");
                    wrongCount++;
                }
            } else if (!getPlayerGuess(input, word, playerGuesses)) {
                System.out.println("\u001B[31m" + "INCORRECT!" + "\u001B[0m");
                wrongCount++;
            }

            printHangedMan(wrongCount);
            System.out.println("Guess a letter or the word: (" + word_length + " characters)");
            boolean word_state = printWordState(word, playerGuesses);
            if (word_state) {
                System.out.println("\u001B[32m" + "YOU WIN!" + "\u001B[0m");
                break;
            }
        }
    }

    private static void printHangedMan(int wrongCount) {

        String top = " ________";
        String noose = "        |";
        String head = "        |";
        String arms = "        |";
        String torso = "        |";
        String legs = "        |";
        String bottom = "       ===";

        /*
            ________          TOP
            |      |          NOOSE
            O      |          HEAD
           \ /     |          ARMS
            |      |          TORSO
           / \     |          LEGS
                  ===         BOTTOM
         */

        if (wrongCount >= 1) {
            noose = " |      |";
        }
        if (wrongCount >= 2) {
            head = " O      |";
        }
        if (wrongCount >= 3) {
            arms = "\\       |";
            if (wrongCount >= 4) {
                arms = "\\ /     |";
            }
        }
        if (wrongCount >= 5) {
            torso = " |      |";
        }
        if (wrongCount >= 6) {
            legs = "/       |";
            if (wrongCount >= 7) {
                legs = "/ \\     |";
            }
        }

        System.out.println(top);
        System.out.println(noose);
        System.out.println(head);
        System.out.println(arms);
        System.out.println(torso);
        System.out.println(legs);
        System.out.println(bottom);
    }

    private static boolean getPlayerGuess(String input, String word, List<Character> playerGuesses) {
        playerGuesses.add(input.charAt(0)); // get first character of the word

        return word.contains(input);
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        System.out.println();
        for (int i = 0; i < word.length(); i++) {

            char guess = word.charAt(i);
            if (playerGuesses.contains(guess)) {
                System.out.print(guess);
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }
}
