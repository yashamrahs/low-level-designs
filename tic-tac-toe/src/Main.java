import enums.Symbol;
import models.Player;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TicTacToeSystem system = TicTacToeSystem.getInstance();

        Player yash = new Player("Yash", Symbol.X);
        Player sharma = new Player("Sharma", Symbol.O);

        // --- GAME 1: yash wins ---
        System.out.println("--- GAME 1: yash (X) vs. sharma (O) ---");
        system.createGame(yash, sharma);
        system.printBoard();

        system.makeMove(yash, 0, 0);
        system.makeMove(sharma, 1, 0);
        system.makeMove(yash, 0, 1);
        system.makeMove(sharma, 1, 1);
        system.makeMove(yash, 0, 2); // yash wins, scoreboard is notified
        System.out.println("----------------------------------------\n");

        // --- GAME 2: sharma wins ---
        System.out.println("--- GAME 2: yash (X) vs. sharma (O) ---");
        system.createGame(yash, sharma); // A new game instance
        system.printBoard();

        system.makeMove(yash, 0, 0);
        system.makeMove(sharma, 1, 0);
        system.makeMove(yash, 0, 1);
        system.makeMove(sharma, 1, 1);
        system.makeMove(yash, 2, 2);
        system.makeMove(sharma, 1, 2); // sharma wins, scoreboard is notified
        System.out.println("----------------------------------------\n");

        // --- GAME 3: A Draw ---
        System.out.println("--- GAME 3: yash (X) vs. sharma (O) - Draw ---");
        system.createGame(yash, sharma);
        system.printBoard();

        system.makeMove(yash, 0, 0);
        system.makeMove(sharma, 0, 1);
        system.makeMove(yash, 0, 2);
        system.makeMove(sharma, 1, 1);
        system.makeMove(yash, 1, 0);
        system.makeMove(sharma, 1, 2);
        system.makeMove(yash, 2, 1);
        system.makeMove(sharma, 2, 0);
        system.makeMove(yash, 2, 2); // Draw, scoreboard is not notified of a winner
        System.out.println("----------------------------------------\n");

    }
}