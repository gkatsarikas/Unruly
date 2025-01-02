package unruly;

import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void printBoard(Board board) {
        for (char[] row : board.tiles) {
            for (char ch : row) {
                System.out.print(ch == '.' ? "." : ch);
            }
            System.out.println();
        }
    }

    public static void writeToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}
