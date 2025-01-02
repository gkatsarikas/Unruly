package unruly;

public class Validator {
    public boolean isValid(Board board, int row, int col, char color) {
        board.tiles[row][col] = color;

        // Validate row
        if (!validateLine(board.tiles[row])) {
            board.tiles[row][col] = '.';
            return false;
        }

        // Validate column
        char[] colArray = new char[board.rows];
        for (int i = 0; i < board.rows; i++) {
            colArray[i] = board.tiles[i][col];
        }
        if (!validateLine(colArray)) {
            board.tiles[row][col] = '.';
            return false;
        }

        board.tiles[row][col] = '.';
        return true;
    }

    private boolean validateLine(char[] line) {
        int countB = 0;
        int countW = 0;
        int consecutive = 0;
        char prev = '.';

        for (char ch : line) {
            if (ch == 'B') countB++;
            if (ch == 'W') countW++;

            if (ch == prev && (ch == 'B' || ch == 'W')) {
                consecutive++;
                if (consecutive > 2) return false;
            } else {
                consecutive = 1;
            }

            prev = ch;
        }

        int n = line.length / 2;
        return countB <= n && countW <= n;
    }
}
