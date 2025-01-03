package unruly;
import java.io.IOException;
import java.util.Scanner;

public class Unruly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the input file path:");
        String inputFilePath = scanner.nextLine();

        System.out.println("Enter the output file path:");
        String outputFilePath = scanner.nextLine();

        System.out.println("Enter the maximum number of nodes to expand:");
        int maxNodes = scanner.nextInt();

        try {
            Board board = BoardParser.parse(inputFilePath);

            System.out.println("Initial Board:");
            Utils.printBoard(board);

            Solver solver = new Solver(maxNodes);
            String solution = solver.solve(board);

            if (solution != null) {
                System.out.println("\nSolution:");
                System.out.println(solution);
                Utils.writeToFile(outputFilePath, solution);
            } else {
                System.out.println("No solution found.");
            }

        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }

        scanner.close();
    }
}
