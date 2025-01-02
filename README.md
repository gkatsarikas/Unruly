# Unruly
An implementation of the board game Unruly in Java. This project aims to encode the game as a search problem
and solve it using a common search method.

---

## Features

- Solve puzzles of any even size (`n x m`) where `n,m` are 2 even numbers greater than 5.
- Input files specify puzzle instances using encoded strings.
- Outputs solutions in a format compliant with Unruly game rules.
- Includes unit tests for core components.
- Clear and modular project structure.

---

## Game Rules

1. The board consists of tiles that can either be empty, black (`B`) or white (`W`). 
2. No more than 2 consecutive tiles can have the same color horizontally or vertically.
3. Each row and column must contain an equal amount of black and white tiles.


## Requirements

- **JDK**: Version 21 or later
- **Build tool**: Apache Maven for dependency management and builds


## Project structure

The project consists of the following modules:

1. **Unruly.java**: Main class. Handles input file and attempts to solve the given game instance
2. **Solver.java**: Implements the backtracking algorithm for solving the puzzle.
3. **BoardParser.java**: Reads input files and parses the encoded puzzle.
4. **Validator.java**: Ensures that board states comply with the rules.
5. **Encoder.java**: Encodes the solution into the required output format.
6. **Utils.java**: Utility methods for printing boards and handling common tasks.

---

## Usage

### **Run the Solver**

1. Compile the project:
   ```
   javac -d out src/main/java/unruly/*.java
   ```
2. Run the game solver:
   ```
   java -cp build unruly.Unruly
   ```