package edu.hw1;

public class Task8 {
    public final static int BOARD_SIZE = 8;
    private static final int[][] KNIGHT_STEPS =
        {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    /**
     * returns true if the knights are placed on the chessboard in such way that no knight can capture another knight
     *
     * @param board the board with the  knights locations
     * @return true if the knights can't be reached and false if can
     */
    public boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    for (int[] knightStep : KNIGHT_STEPS) {
                        int x = i + knightStep[0];
                        int y = j + knightStep[1];
                        if (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE && board[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
