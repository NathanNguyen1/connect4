//isWinner method pasted from the GPT
//Extended from tictactoe
package connect4;
/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_SIZEX][Constants.BOARD_SIZEY];
    
    public boolean isWinner() {
             // Check rows
        for (int row = 0; row < Constants.BOARD_SIZEX; row++) {
            for (int col = 0; col <= Constants.BOARD_SIZEY - 4; col++) {
                int player = getBoardCell(row, col);
                if (player != Constants.BLANK &&
                    player == getBoardCell(row, col + 1) &&
                    player == getBoardCell(row, col + 2) &&
                    player == getBoardCell(row, col + 3)) {
                    return true;
                }
            }
        }
    
        // Check columns
        for (int col = 0; col < Constants.BOARD_SIZEY; col++) {
            for (int row = 0; row <= Constants.BOARD_SIZEX - 4; row++) {
                int player = getBoardCell(row, col);
                if (player != Constants.BLANK &&
                    player == getBoardCell(row + 1, col) &&
                    player == getBoardCell(row + 2, col) &&
                    player == getBoardCell(row + 3, col)) {
                    return true;
                }
            }
        }
    
        // Check diagonals (top-left to bottom-right)
        for (int row = 0; row <= Constants.BOARD_SIZEX - 4; row++) {
            for (int col = 0; col <= Constants.BOARD_SIZEY - 4; col++) {
                int player = getBoardCell(row, col);
                if (player != Constants.BLANK &&
                    player == getBoardCell(row + 1, col + 1) &&
                    player == getBoardCell(row + 2, col + 2) &&
                    player == getBoardCell(row + 3, col + 3)) {
                    return true;
                }
            }
        }
    
        // Check diagonals (bottom-left to top-right)
        for (int row = 3; row < Constants.BOARD_SIZEX; row++) {
            for (int col = 0; col <= Constants.BOARD_SIZEY - 4; col++) {
                int player = getBoardCell(row, col);
                if (player != Constants.BLANK &&
                    player == getBoardCell(row - 1, col + 1) &&
                    player == getBoardCell(row - 2, col + 2) &&
                    player == getBoardCell(row - 3, col + 3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_SIZEX; row++) {
            for (int col=0; col<Constants.BOARD_SIZEY; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) {
        if (row >= 0 && row < Constants.BOARD_SIZEX) {
            if (col >= 0 && col < Constants.BOARD_SIZEY) {
                return this.board[row][col];
            }
        }
        return 0;
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }

    public void reset(){
        gameState = Constants.STANDBY;
        board = new int[Constants.BOARD_SIZEX][Constants.BOARD_SIZEY];
    }
}
