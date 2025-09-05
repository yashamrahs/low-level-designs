import controller.SnakeFoodGame;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] foodPositions = {
                {0, 1},
                {10, 8},
                {3, 12},
                {8, 17},
                {12, 3}
        };

        SnakeFoodGame game = new SnakeFoodGame(20, 15, foodPositions);

        // Game instructions
        System.out.println("===== SNAKE GAME =====");
        System.out.println(
                "Controls: W (Up), S (Down), A (Left), D (Right), Q (Quit)");
        System.out.println("Eat food to grow your snake and increase your score.");
        System.out.println("Don't hit the walls or bite yourself!");
        System.out.println("=======================");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int score = 0;

        // Main game
        while (running) {
            displayGameState(game);

            System.out.print("Enter move (W/A/S/D) or Q to quit: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("Game ended by player. Final score: " + score);
                running = false;
                continue;
            }

            String direction = convertInput(input);
            if (direction.isEmpty()) {
                System.out.println("Invalid input! Use W/A/S/D to move or Q to quit.");
                continue;
            }

            score = game.move(direction);
            if (score == -1) {
                System.out.println("GAME OVER! You hit a wall or bit yourself.");
                System.out.println("Final score: " + (game.getSnake().size() - 1));
                running = false;
            } else {
                System.out.println("Score: " + score);
            }
        }

        scanner.close();
        System.out.println("Thanks for playing");
    }

    private static String convertInput(String input) {
        switch (input) {
            case "W":
                return "U";
            case "S":
                return "D";
            case "A":
                return "L";
            case "D":
                return "R";
            default:
                return "";
        }
    }

    private static void displayGameState(SnakeFoodGame game) {
        System.out.println("nCurrent snake length: " + game.getSnake().size());
    }
}
