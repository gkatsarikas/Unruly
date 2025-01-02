package unruly;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    private final int maxNodes;
    private int nodesExpanded;

    public Solver(int maxNodes) {
        this.maxNodes = maxNodes;
        this.nodesExpanded = 0;
    }

    public String solve(Board board) {
        List<int[]> emptyPositions = getEmptyPositions(board);
        return backtrack(board, emptyPositions, 0) ? Encoder.encode(board) : null;
    }

    private boolean backtrack(Board board, List<int[]> emptyPositions, int index) {
        if (index == emptyPositions.size()) return true;
        if (nodesExpanded >= maxNodes) return false;

        int[] pos = emptyPositions.get(index);
        int row = pos[0], col = pos[1];

        for (char color : new char[]{'B', 'W'}) {
            if (new Validator().isValid(board, row, col, color)) {
                board.tiles[row][col] = color;
                nodesExpanded++;

                if (backtrack(board, emptyPositions, index + 1)) return true;

                board.tiles[row][col] = '.';
            }
        }

        return false;
    }

    private List<int[]> getEmptyPositions(Board board) {
        List<int[]> emptyPositions = new ArrayList<>();
        for (int i = 0; i < board.rows; i++) {
            for (int j = 0; j < board.cols; j++) {
                if (board.tiles[i][j] == '.') {
                    emptyPositions.add(new int[]{i, j});
                }
            }
        }
        return emptyPositions;
    }
}
