package aharon.connect4;

public class ConnectBoard {
    private int width;
    private int height;
    private int[][] board;
    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
    };

    public int[][] getBoard() {
        return board;
    }

    public ConnectBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[height][width];
    }

    boolean isFull(int column) {
        if (board[0][column] == 1 || board[0][column] == 2) {
            return true;
        } else {
            return false;
        }
    }

    void insert(int column, int color) {
        if (!isFull(column)) {
            for (int row = height - 1; row >= 0; row--) {
                if (board[row][column] == 0) {
                    board[row][column] = color;
                    break;
                }
            }
        }
    }

    public int calculateWinner() {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                int currentValue = board[row][column];
                if (currentValue == 0) { continue; }

                for (int ix = 0; ix < DIRECTIONS.length; ix++) {
                    int[] directions = DIRECTIONS[ix];
                    int moveX = directions[0];
                    int moveY = directions[1];

                    boolean isWinning = true;
                    for (int step = 1; step < 4; step++) {
                        int xStep = moveX * step;
                        int yStep = moveY * step;
                        int newRow = row + xStep;
                        int newCol = column + yStep;

                        if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width
                                || board[newRow][newCol] != currentValue) {
                            isWinning = false;
                            break;
                        }
                    }
                    if (isWinning) {
                        return currentValue;
                    }
                }
            }
        }
        return  -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (board[row][column] == 0) {
                    sb.append(" 0 ");
                }
                if (board[row][column] == 1) {
                    sb.append(" 1 ");
                }
                if (board[row][column] == 2) {
                    sb.append(" 2 ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}