import java.util.*;

public class GameOfLife {

    Random random = new Random();
    private final int rows;
    private final int cols;
    private int[][] board;

    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new int[rows][cols];
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] newBoard) {
        if (newBoard.length != rows || newBoard[0].length != cols) {
            throw new IllegalArgumentException("Board dimensions do not match");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    public void randomState() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = random.nextInt(2);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void render() {
        System.out.println("-".repeat(cols + 2));

        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }

        System.out.println("-".repeat(cols + 2));
    }

    public void nextBoardState() {
        int[][] newState = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);

                // game rules
                if (board[i][j] == 1) {
                    if (liveNeighbors == 0 || liveNeighbors == 1) {
                        newState[i][j] = 0;
                    } else if (liveNeighbors == 2 || liveNeighbors == 3) {
                        newState[i][j] = 1;
                    } else if (liveNeighbors >= 3) {
                        newState[i][j] = 0;
                    }
                } else if (board[i][j] == 0) {
                    if (liveNeighbors == 3) {
                        newState[i][j] = 1;
                    }
                }
            }
        }
        board = newState;
    }

    private int countLiveNeighbors(int row, int col) {
        int[] directions = {-1, 0, 1};
        int liveNeighbors = 0;

        for (int i : directions) {
            for (int j : directions) {
                if (!(i == 0 && j == 0)) {
                    int newRow = row + i;
                    int newCol = col + j;

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 1) {
                        liveNeighbors++;
                    }
                }
            }
        }
        return liveNeighbors;
    }
}