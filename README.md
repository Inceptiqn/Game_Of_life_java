# README.md

# Game of Life

This project implements the classic "Game of Life" simulation, a cellular automaton devised by mathematician John Conway. The simulation runs based on a set of rules that determine the state of each cell in a grid based on the states of its neighbors.

## Project Structure

```
game-of-life
├── src
│   ├── main
│   │   └── java
│   │       ├── BoardReader.java
│   │       ├── GameOfLife.java
│   │       ├── Main.java
│   │       └── Test.java
├── resources
│   └── boards
│       ├── toad.txt
│       └── gospel_glider_gun.txt
├── .vscode
│   ├── settings.json
│   └── launch.json
├── .gitignore
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 20 or higher
- Visual Studio Code with Java extensions installed

### Running the Simulation

1. Clone the repository:
   ```
   git clone <repository-url>
   cd game-of-life
   ```

2. Open the project in Visual Studio Code.

3. To run the simulation, you can either:
   - Provide a board configuration file as a command-line argument:
     ```
     java -cp target/classes Main <path-to-board-file>
     ```
   - Or run the simulation with a random initial state by executing:
     ```
     java -cp target/classes Main
     ```

### Testing

The `Test` class includes various test cases to verify the functionality of the Game of Life logic. You can run these tests to ensure the implementation behaves as expected.

### Board Configurations

Predefined board configurations are available in the `resources/boards` directory:
- `toad.txt`: A configuration for the "Toad" pattern.
- `gospel_glider_gun.txt`: A configuration for the "Gospel Glider Gun" pattern.

## License

This project is licensed under the MIT License. See the LICENSE file for details.