package com.chalwk;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.fusesource.jansi.AnsiConsole;
import org.json.JSONArray;
import org.json.JSONObject;

import static com.chalwk.FileIO.readJSONObject;
import static org.fusesource.jansi.Ansi.ansi;

public class HangMan {

    static JSONObject hangmanJson;
    private static StringBuilder word;
    private static Scanner keyboard;
    private static List<Character> playerGuesses;
    private static int game_over;
    private static int state;
    private static int word_length;
    private static boolean design_chosen;

    static {
        try {
            hangmanJson = readJSONObject("hangman.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Init(Scanner keyboard) {

        keyboard = (keyboard == null) ? new Scanner(System.in) : keyboard;

        AnsiConsole.systemInstall();
        state = hangmanJson.length();
        game_over = 0;
        showLogo();

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

        Scanner keyboard = new Scanner(System.in);

        while (!design_chosen) {

            sendMessage("green", "Choose the Hangman design (1- " + hangmanJson.length() + "): ");
            String input = keyboard.nextLine();
            if (input.isEmpty() || !hangmanJson.has(input)) {
                sendMessage("red", "Invalid input!");
            } else {
                design_chosen = false;
                hangmanJson = (JSONObject) hangmanJson.get(input);
                Init(keyboard);
                break;
            }
        }

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
                        state--;
                    }
                } else if (!getPlayerGuess(input, word, playerGuesses)) {
                    sendMessage("red", "(" + input + ") IS INCORRECT!");
                    state--;
                }

                if (state <= 1) {
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
                Init(keyboard);
            } else if (input.equalsIgnoreCase("n")) {
                sendMessage("green", "Thanks for playing!");
                System.exit(0);
            } else {
                sendMessage("red", "Invalid Input");
            }
        }
    }

    private static void printHangedMan() {
        JSONArray t = (JSONArray) hangmanJson.get(String.valueOf(state));
        for (int i = 0; i < t.length(); i++) {
            System.out.println(t.get(Integer.parseInt(String.valueOf(i))));
        }
    }

    private static boolean getPlayerGuess(String input, StringBuilder word, List<Character> guesses) {
        char guess = input.charAt(0);
        guesses.add(guess);
        return word.toString().contains(input);
    }

    private static boolean printWordState(StringBuilder word, List<Character> guesses) {

        // TODO: Print letters that we've already used.

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
        JSONArray t = (JSONArray) hangmanJson.get("1");
        for (int i = 0; i < t.length(); i++) {
            System.out.println(t.get(Integer.parseInt(String.valueOf(i))));
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