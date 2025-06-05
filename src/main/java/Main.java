import java.io.*;

public class Main {
    public static void main(String[] args) {
        GameOfLife game;

        if (args.length > 0) {
            String filename = args[0];
            try {
                BoardReader reader = new BoardReader();
                reader.importBoard(filename);
                int rows = reader.getRows();
                int cols = reader.getCols();

                game = new GameOfLife(rows, cols);
                game.setBoard(reader.getBoard());

            } catch (FileNotFoundException e) { //file not found
                System.out.println("File not found: " + e.getMessage());
                return;
            }
        } else {
            game = new GameOfLife(25, 100);
            game.randomState();
        }

        clearScreen();
        game.render();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        while (true) {
            game.nextBoardState();
            moveCursorToTop();
            game.render();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void moveCursorToTop() {
        System.out.print("\033[H");
    }
}