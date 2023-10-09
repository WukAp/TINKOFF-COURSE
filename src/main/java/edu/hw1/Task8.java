package edu.hw1;

public class Task8 {
    public final static int BOARD_SIZE = 8;
    private static final int[][] KNIGHT_STEPS =
        {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    private static final int KNIGHT = 1;

    /**
     * returns true if the knights are placed on the chessboard in such way that no knight can capture another knight
     *
     * @param board the board with the  knights locations
     * @return true if the knights can't be reached and false if can
     */
    public boolean knightBoardCapture(int[][] board) {
        if (board == null || board.length != BOARD_SIZE || board[0].length != BOARD_SIZE) {
            throw new IllegalArgumentException("input board should be " + BOARD_SIZE + "x" + BOARD_SIZE);
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == KNIGHT) {
                    for (int[] knightStep : KNIGHT_STEPS) {
                        int x = i + knightStep[0];
                        int y = j + knightStep[1];
                        if (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE && board[x][y] == KNIGHT) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
