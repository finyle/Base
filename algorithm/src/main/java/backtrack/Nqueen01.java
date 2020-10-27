package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Nqueen01 {

    private static List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(res, chess, 0);
        return res;
    }

    private static void backtrack(List<List<String>> res, char[][] chess, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (isValid(chess, row, col)) {
                chess[row][col] = 'Q';
                backtrack(res, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    private static boolean isValid(char[][] chess, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (chess[i][j] == 'Q') return false;
        }
        return true;
    }

    private static List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

}
