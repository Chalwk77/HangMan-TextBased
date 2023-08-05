import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangMan {

    public static String[][] hangman = {
            {
                    " ",
                    " ",
                    " ",
                    " ",
                    " ",
                    " ",
                    " ",
                    " ",
                    " ",
                    " ",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 13    +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    " ",
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
                    "|  TRIES REMAINING: 12    +----+",
                    "|                              |",
                    "+------------------------------+",
            },
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
                    "|  TRIES REMAINING: 11    +----+",
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
                    "|  TRIES REMAINING: 10    +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|        (0_0)",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 9     +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |      - (HELP!)",
                    "|          |    -",
                    "|        (0_0) -",
                    "|          |",
                    "|          |",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 8     +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |      - (HELP!)",
                    "|          |    -",
                    "|        (0_0) -",
                    "|         /|",
                    "|        | |",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 7     +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |      - (SERIOUSLY HELP!)",
                    "|          |    -",
                    "|        (0_o) -",
                    "|         /|\\",
                    "|        | | |",
                    "|",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 6     +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |      - (I'M BEGGING YOU!)",
                    "|          |    -",
                    "|        (0_o) -",
                    "|         /|\\",
                    "|        | | |",
                    "|         /",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 5     +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |      - (URGH! EEEH EUH UEEH!)",
                    "|          |    -",
                    "|        (0_o) -",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 4     +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |      - (KRKRRKRRKRRKRRK!)",
                    "|          |    -",
                    "|        (0_o) -",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|        /",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 3     +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |      - (LURGH, CCCCKKK, HUUUURGH!)",
                    "|          |    -",
                    "|        (0_-) -",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|        /   \\",
                    "|",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 2     +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |      - (URGHHHH!!)",
                    "|          |    -",
                    "|        (*_o) -",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|        /   \\",
                    "|        '",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|  TRIES REMAINING: 1     +----+",
                    "|                              |",
                    "+------------------------------+",
            },
            {
                    "+----------+",
                    "|          |",
                    "|          |",
                    "|        (*_*)",
                    "|         /|\\",
                    "|        | | |",
                    "|         / \\",
                    "|        /   \\",
                    "|        '   '",
                    "|",
                    "+------+------------------+",
                    "|                         |",
                    "|     R. I. P             +----+",
                    "|                              |",
                    "+------------------------------+",
            }
    };
    private static StringBuilder word;
    private static Scanner keyboard;
    private static List<Character> playerGuesses;
    private static int game_over;
    private static int tries;
    private static int word_length;


    public static void Init() {

        game_over = 0;
        showLogo();

        keyboard = new Scanner(System.in);
        if (keyboard.nextLine().equals("1")) {

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

        System.out.println("\n".repeat(100));
        //System.out.println("THE WORD IS (" + word + ")"); // debug: print the word
        //System.out.println();

        word_length = word.length();
        System.out.println("Guess a letter or the word: (" + word_length + " characters)");

        playerGuesses = new ArrayList<>();
        tries = 0;

        printHangedMan();
        printWordState(word.toString(), playerGuesses);
    }

    public static void main(String[] args) {

        Init();

        while (true) {

            String input = keyboard.nextLine();

            // No more tries:
            if (tries >= hangman.length - 1) {
                System.out.println("YOU LOSE! THE WORD WAS \"" + word + "\"");
                showDeadHangMan();
                game_over = game_over == 0 ? 1 : game_over;

                // more than one character entered:
            } else if (input.length() > 1) {
                if (input.contentEquals(word)) {
                    System.out.println("YOU WIN!");
                    game_over = game_over == 0 ? 1 : game_over;

                    // incorrect word:
                } else {
                    System.out.println("(" + input + ") IS INCORRECT!");
                    tries++;
                }

                // single character entered:
            } else if (!getPlayerGuess(input, String.valueOf(word), playerGuesses)) {
                System.out.println("(" + input + ") IS INCORRECT!");
                tries++;
            }

            printHangedMan();

            // Check if all characters have been guessed:
            System.out.println("Guess a letter or the word: (" + word_length + " characters)");
            boolean word_state = printWordState(String.valueOf(word), playerGuesses);
            if (word_state) {
                System.out.println("YOU WIN!");
                game_over = game_over == 0 ? 1 : game_over;
            }

            if (gameOver(input)) {
                break;
            }
        }
    }

    public static boolean restart(String input) {
        return input.equals("y");
    }

    public static boolean gameOver(String input) {
        if (game_over == 1) {
            game_over = 2;
            System.out.println("Would you like to play again? (y/n)");
            return false;
        } else if (game_over == 2 && restart(input)) {
            Init();
            return true;
        }
        return false;
    }

    private static void printHangedMan() {
        for (String line : hangman[tries]) {
            System.out.println(line);
        }
    }

    private static boolean getPlayerGuess(String input, String word, List<Character> guesses) {
        char guess = input.charAt(0); // get first character of the word
        guesses.add(guess);

        return word.contains(input);
    }

    private static boolean printWordState(String word, List<Character> guesses) {
        int correctCount = 0;

        System.out.println();
        for (int i = 0; i < word.length(); i++) {

            char guess = word.charAt(i);
            if (guesses.contains(guess)) {
                System.out.print(guess);
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }

    private static void showDeadHangMan() {
        for (String line : hangman[hangman.length - 1]) {
            System.out.println(line);
        }
    }

    private static void showLogo() {
        System.out.println("======================================");
        System.out.println("Welcome to Hangman\n");
        showDeadHangMan();
        System.out.println("One player or two players? (1 or 2)");
        System.out.println("======================================");
    }
}
