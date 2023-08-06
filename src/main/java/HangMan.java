import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

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
                    "|         0|0",
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
                    "|        /0|0",
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
                    "|        /0|0\\",
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
                    "|        /0|0\\",
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
                    "|        /0|0\\",
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
                    "|        /0|0\\",
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
                    "|        /0|0\\",
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
                    "|        /0|0\\",
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
                    "|        /0|0\\",
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

        AnsiConsole.systemInstall();
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

            sendMessage("green", "Player 1, please enter your word: ");
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
        sendMessage("white", "Guess a letter or the word: (" + word_length + " characters)");

        playerGuesses = new ArrayList<>();

        printWordState(word, playerGuesses);
    }

    public static void main(String[] args) {

        Init();

        while (true) {

            String input = keyboard.nextLine();
            if (game_over == 0) {

                if (input.isEmpty()) {
                    sendMessage("red", "Invalid input!");
                    continue;
                } else if (input.length() > 1) {
                    if (input.contentEquals(word)) {
                        game_over = game_over == 0 ? 1 : game_over;
                        sendMessage("green", "YOU WIN");
                    } else {
                        tries++;
                    }
                } else if (!getPlayerGuess(input, word, playerGuesses)) {
                    sendMessage("red", "(" + input + ") IS INCORRECT!");
                    tries++;
                }

                if (tries >= hangman.length - 1) {
                    game_over = game_over == 0 ? 1 : game_over;
                    printHangedMan();
                } else {
                    sendMessage("white", "Guess a letter or the word: (" + word_length + " characters)");
                    if (printWordState(word, playerGuesses)) {
                        sendMessage("green", "YOU WIN!");
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
            sendMessage("white", "Play Again? (Y/N)");
        } else if (game_over > 1) {
            if (input.equalsIgnoreCase("y")) {
                Init();
            } else if (input.equalsIgnoreCase("n")) {
                sendMessage("green", "Thanks for playing!");
                System.exit(0);
            } else {
                sendMessage("red", "Invalid Input");
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
        sendMessage("white", "======================================");
        sendMessage("white", "Welcome to Hangman\n");
        showDeadHangMan();
        sendMessage("white", "One player or two players? (1 or 2)");
        sendMessage("white", "======================================");
    }

    public static void sendMessage(String color, String message) {
        System.out.println(ansi().render("@|" + color + " " + message + "|@ "));
    }

}