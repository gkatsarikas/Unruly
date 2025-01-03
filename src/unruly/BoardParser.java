package unruly;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BoardParser {

    public static Board parse(String path) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){

            String line = reader.readLine().trim();

            String parts[] = line.split(":");
            String size[] = parts[0].split("x");

            int rows = Integer.parseInt(size[0]);
            int cols = Integer.parseInt(size[1]);
            String encoding = parts[1];

            Board board = new Board(rows, cols);
            decode(board,encoding);
            return board;
        }

    }

    private static void decode(Board board, String encoding) {
        int pos = 0;
        int cols = board.cols;

        for (char ch : encoding.toCharArray()) {
            int step = Character.toLowerCase(ch) - 'a' + 1;
            pos += step;
            int row = pos / cols;
            int col = pos % cols;

            if (row < board.rows) {
                board.tiles[row][col] = Character.isUpperCase(ch) ? 'B' : 'W';
            }
        }
    }
    
}
