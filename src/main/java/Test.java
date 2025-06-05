public class Test {
    public static void runAllTests() {
        // TEST 1: dead cells with no live neighbors should stay dead
        int[][] initState1 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] expectedNextState1 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        runTest(1, initState1, expectedNextState1);

        // TEST 2: Dead cells with exactly 3 neighbors should come alive
        int[][] initState2 = {
                {0, 0, 1},
                {0, 1, 1},
                {0, 0, 0}
        };
        int[][] expectedNextState2 = {
                {0, 1, 1},
                {0, 1, 1},
                {0, 0, 0}
        };
        runTest(2, initState2, expectedNextState2);

        // TEST 3: Live cells with fewer than 2 neighbors should die (underpopulation)
        int[][] initState3 = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] expectedNextState3 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        runTest(3, initState3, expectedNextState3);

        // TEST 4: Live cells with 2 or 3 neighbors should stay alive
        int[][] initState4 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        int[][] expectedNextState4 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        runTest(4, initState4, expectedNextState4);

        // TEST 5: Oscillating pattern (Blinker)
        int[][] initState5 = {
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        };
        int[][] expectedNextState5 = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        runTest(5, initState5, expectedNextState5);

        // TEST 6: Still life (Block)
        int[][] initState6 = {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int[][] expectedNextState6 = {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        runTest(6, initState6, expectedNextState6);
    }

    public static void runTest(int testNum, int[][] initState, int[][] expectedNextState) {
        GameOfLife testGame = new GameOfLife(initState.length, initState[0].length);
        testGame.setBoard(initState);
        testGame.nextBoardState();

        int[][] actualNextState = testGame.getBoard();
        boolean passed = compareBoards(expectedNextState, actualNextState);

        if (passed) {
            System.out.println("PASSED " + testNum);
        } else {
            System.out.println("FAILED " + testNum + "!");
            System.out.println("Expected:");
            printBoard(expectedNextState);
            System.out.println("Actual:");
            printBoard(actualNextState);
        }
        System.out.println("-".repeat(20));
    }

    public static boolean compareBoards(int[][] board1, int[][] board2) {
        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[i].length; j++) {
                if (board1[i][j] != board2[i][j]) return false;
            }
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}