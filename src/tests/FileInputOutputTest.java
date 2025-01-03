import org.junit.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

import unruly.*;

public class FileInputOutputTest {

    @Test
    public void testFileReading() throws IOException {
        // Test if a file can be read successfully
        String filePath = "input/example1.txt";
        File file = new File(filePath);
        assertTrue("Input file should exist.", file.exists());

        Board board = BoardParser.parse(filePath);
        assertNotNull("Parsed board should not be null.", board);
        assertEquals("Board should have 8 rows.", 8, board.getRows());
        assertEquals("Board should have 8 columns.", 8, board.getCols());
    }

    @Test
    public void testFileWriting() throws IOException {
        // Test if a board can be written to a file
        String outputPath = "output/test_output.txt";
        Board board = new Board(6, 6);
        board.setTile(0, 0, 'B');
        board.setTile(0, 1, 'W');

        String encodedBoard = Encoder.encode(board); // Encode the board into a string
        Utils.writeToFile(outputPath, encodedBoard); // Write the encoded board to a file

        File outputFile = new File(outputPath);
        assertTrue("Output file should be created.", outputFile.exists());
    }

    @Test
    public void testInvalidFileReading() {
        String invalidFilePath = "input/non_existent_file.txt";
        File file = new File(invalidFilePath);
        assertFalse("File should not exist.", file.exists());
    }



}
