package Simulation;


/* 348 - Design Tic Tac Toe */
public class DesignTicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int n;

    public DesignTicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player){
        int add = player == 1 ? 1 : -1;
        rows[row] += add;
        cols[col] += add;
        if(row == col) diagonal += add;
        if(row + col == n - 1) antiDiagonal += add;

        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n){
            return player;
        }

        return 0;

    }
}
