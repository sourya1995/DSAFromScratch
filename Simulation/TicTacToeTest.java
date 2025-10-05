
package Simulation;

public class TicTacToeTest {
    public static void main(String[] args) {
        DesignTicTacToe ticTacToe = new DesignTicTacToe(3);
        System.out.println("Move at (0, 0) for player 1: " + ticTacToe.move(0, 0, 1));
        System.out.println("Move at (0, 2) for player 2: " + ticTacToe.move(0, 2, 2));
        System.out.println("Move at (2, 2) for player 1: " + ticTacToe.move(2, 2, 1));
        System.out.println("Move at (1, 1) for player 2: " + ticTacToe.move(1, 1, 2));
        System.out.println("Move at (2, 0) for player 1: " + ticTacToe.move(2, 0, 1));
        System.out.println("Move at (1, 0) for player 2: " + ticTacToe.move(1, 0, 2));
        System.out.println("Move at (2, 1) for player 1: " + ticTacToe.move(2, 1, 1));
    }
}
