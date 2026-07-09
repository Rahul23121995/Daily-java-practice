package day09;
import java.util.ArrayList;
import java.util.List;
public class Hard_NQueens {
    private static int size;
    private static List<List<String>> solutions;
    public static List<List<String>> solveNQueens(int n) {
        size = n; solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) board[i][j] = '.';
        backtrack(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], board);
        return solutions;
    }
    private static void backtrack(int row, boolean[] cols, boolean[] diagonals, boolean[] antiDiagonals, char[][] board) {
        if (row == size) { solutions.add(createBoard(board)); return; }
        for (int col = 0; col < size; col++) {
            int currDiag = row - col + size, currAntiDiag = row + col;
            if (cols[col] || diagonals[currDiag] || antiDiagonals[currAntiDiag]) continue;
            board[row][col] = 'Q'; cols[col] = true; diagonals[currDiag] = true; antiDiagonals[currAntiDiag] = true;
            backtrack(row + 1, cols, diagonals, antiDiagonals, board);
            board[row][col] = '.'; cols[col] = false; diagonals[currDiag] = false; antiDiagonals[currAntiDiag] = false;
        }
    }
    private static List<String> createBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < size; i++) res.add(new String(board[i]));
        return res;
    }
    public static void main(String[] args) {
        assert solveNQueens(4).size() == 2;
        System.out.println("N-Queens passed!");
    }
}