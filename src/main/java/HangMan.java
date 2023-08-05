import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangMan {

    public static String[][] hangman = {
            {
                    "+----------+",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|          |",
                    "|          |",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|         /|",
                    "|        | |",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|         /|\\",
                    "|        | | |",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|         /|\\",
                    "|        | | |",
                    "|         /",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|        /",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|        /   \\",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|        /   \\",
                    "|        '",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|         (.)",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|        /   \\",
                    "|        '   '",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|                         +----+",
                    "|                              |",
                    "+------------------------------+",
            }
    };

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("Welcome to Hangman - By Jericho Crosby\n");
        showHangMan();
        System.out.println("One player or two players? (1 or 2)");
        System.out.println("======================================");

        StringBuilder word;
        Scanner keyboard = new Scanner(System.in);
        String player = keyboard.nextLine();

        if (player.equals("1")) {

            InputStream resource = HangMan.class.getClassLoader().getResourceAsStream("words.txt");
            assert resource != null;
            Scanner scanner = new Scanner(resource);

            List<String> words = new ArrayList<>();
            while (scanner.hasNext()) {
                String word_from_file = scanner.nextLine();
                if (word_from_file.length() > 4) {
                    words.add(word_from_file);
                }
            }
            word = new StringBuilder(words.get(new Random().nextInt(words.size())));
        } else {
            System.out.println("Player 1, please enter your word:");
            word = new StringBuilder(keyboard.nextLine());

            // just in case the player doesn't enter a word:
            if (word.isEmpty()) {
                String[] letters = "abcdefghijklmnopqrstuvwxyz".split("");
                word = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    word.append(letters[new Random().nextInt(letters.length)]);
                }
            }
        }

        String new_line = "\n";
        System.out.println(new_line.repeat(100));
        //System.out.println(word); // debug: print the word

        int word_length = word.length();

        List<Character> playerGuesses = new ArrayList<>();
        int wrongCount = 0;

        System.out.println("Guess a letter or the word: (" + word_length + " characters)");
        printHangedMan(wrongCount);
        printWordState(word.toString(), playerGuesses);

        while (true) {

            String input = keyboard.nextLine();

            if (wrongCount >= hangman.length - 1) {
                System.out.println("YOU LOSE! THE WORD WAS \"" + word + "\"");
                showHangMan();
                break;
            } else if (input.length() > 1) {
                if (input.contentEquals(word)) {
                    System.out.println("YOU WIN!");
                    break;
                } else {
                    System.out.println("(" + input + ") IS INCORRECT!");
                    wrongCount++;
                }
            } else if (!getPlayerGuess(input, word.toString(), playerGuesses)) {
                System.out.println("(" + input + ") IS INCORRECT!");
                wrongCount++;
            }

            printHangedMan(wrongCount);
            System.out.println("Guess a letter or the word: (" + word_length + " characters)");
            boolean word_state = printWordState(word.toString(), playerGuesses);
            if (word_state) {
                System.out.println("YOU WIN!");
                break;
            }
        }
    }

    private static void printHangedMan(int wrongCount) {
        for (String line : hangman[wrongCount]) {
            System.out.println(line);
        }
    }

    private static boolean getPlayerGuess(String input, String word, List<Character> playerGuesses) {
        char guess = input.charAt(0); // get first character of the word
        playerGuesses.add(guess);

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

    private static void showHangMan() {
        for (String line : hangman[hangman.length - 1]) {
            System.out.println(line);
        }
    }
}
