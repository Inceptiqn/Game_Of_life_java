import java.io.*;
import java.util.*;

public class BoardReader {

    private int[][] board;
    private int rows;
    private int cols;

    public int[][] getBoard() {
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void importBoard(String filename) throws FileNotFoundException {
        List<int[]> boardList = new ArrayList<>();
        try (Scanner boardScan = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (boardScan.hasNextLine()) {
                String[] line = boardScan.nextLine().trim().split("");
                int[] row = new int[line.length];
                for (int j = 0; j < line.length; j++) {
                    row[j] = Integer.parseInt(line[j]);
                }
                boardList.add(row);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing the board file. Ensure it contains only 0s and 1s.");
            e.printStackTrace();
        }
        this.rows = boardList.size();
        this.cols = boardList.get(0).length;
        this.board = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            this.board[i] = boardList.get(i);
        }
    }
}