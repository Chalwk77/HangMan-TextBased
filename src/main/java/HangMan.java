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
                    "|          |      - (I'M GOING TO HANG!)",
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
                    "|          |      - (SERIOUSLY HELP!!)",
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

        tries = 0;
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
            if (word.isEmpty()) {
                String[] letters = "abcdefghijklmnopqrstuvwxyz".split("");
                word = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    word.append(letters[new Random().nextInt(letters.length)]);
                }
            }
        }

        System.out.println("\n".repeat(100));

        word_length = word.length();
        System.out.println("Guess a letter or the word: (" + word_length + " characters)");

        playerGuesses = new ArrayList<>();

        printWordState(word, playerGuesses);
    }

    public static void main(String[] args) {

        Init();

        while (true) {

            String input = keyboard.nextLine();
            if (game_over == 0) {

                if (input.isEmpty()) {
                    System.out.println("Invalid input!");
                    continue;
                } else if (input.length() > 1) {
                    if (input.contentEquals(word)) {
                        game_over = game_over == 0 ? 1 : game_over;
                        System.out.println("YOU WIN!");
                    } else {
                        System.out.println("(" + input + ") IS INCORRECT!");
                        tries++;
                    }
                } else if (!getPlayerGuess(input, word, playerGuesses)) {
                    System.out.println("(" + input + ") IS INCORRECT!");
                    tries++;
                }

                if (tries >= hangman.length - 1) {
                    game_over = game_over == 0 ? 1 : game_over;
                    printHangedMan();
                } else {
                    System.out.println("Guess a letter or the word: (" + word_length + " characters)");
                    if (printWordState(word, playerGuesses)) {
                        System.out.println("YOU WIN!");
                        game_over = game_over == 0 ? 1 : game_over;
                    }
                }
            }

            checkGameOver(input);
        }
    }

    public static void checkGameOver(String input) {
        if (game_over == 1) {
            game_over++;
            System.out.println(" ");
            System.out.println("Play again? (Y/N)");
        } else if (game_over > 1) {
            if (input.equals("y")) {
                Init();
            } else if (input.equals("n")) {
                System.out.println("Thanks for playing!");
                System.exit(0);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printHangedMan() {
        for (String line : hangman[tries]) {
            System.out.println(line);
        }
    }

    private static boolean getPlayerGuess(String input, StringBuilder word, List<Character> guesses) {
        char guess = input.charAt(0);
        guesses.add(guess);
        return word.toString().contains(input);
    }

    private static boolean printWordState(StringBuilder word, List<Character> guesses) {

        printHangedMan();

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
