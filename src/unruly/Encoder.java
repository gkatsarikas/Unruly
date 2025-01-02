package unruly;

public class Encoder {
    public static String encode(Board board) {
        StringBuilder sb = new StringBuilder();
        sb.append(board.rows).append("x").append(board.cols).append(": ");

        for (char[] row : board.tiles) {
            for (char ch : row) {
                sb.append(ch == 'W' ? 'a' : 'A');
            }
        }

        return sb.toString();
    }
}
