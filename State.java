package connect4; 
//Extended from tictactoe
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
        int total;
        for (int row=0; row<Constants.BOARD_SIZEX; row++) {
            total = getBoardCell(row, 0) + getBoardCell(row,1) + getBoardCell(row,2) + getBoardCell(row, 3);
            if (total == -4 || total == 4) return true;
        }
        for (int row=1; row<Constants.BOARD_SIZEX; row++) {
            total = getBoardCell(row, 1) + getBoardCell(row,2) + getBoardCell(row,3) + getBoardCell(row, 4);
            if (total == -4 || total == 4) return true;
        }
        for (int row=2; row<Constants.BOARD_SIZEX; row++) {
            total = getBoardCell(row, 2) + getBoardCell(row,3) + getBoardCell(row,4) + getBoardCell(row, 5);
            if (total == -4 || total == 4) return true;
        }
        for (int row=3; row<Constants.BOARD_SIZEX; row++) {
            total = getBoardCell(row, 3) + getBoardCell(row,4) + getBoardCell(row,5) + getBoardCell(row, 6);
            if (total == -4 || total == 4) return true;
        }
        for (int col=0; col<Constants.BOARD_SIZEY; col++) {
            total = getBoardCell(0, col) + getBoardCell(1,col) + getBoardCell(2, col) + getBoardCell(3,col);
            if (total == -4 || total == 4) return true;
        }
        for (int col=1; col<Constants.BOARD_SIZEY; col++) {
            total = getBoardCell(1, col) + getBoardCell(2,col) + getBoardCell(3, col) + getBoardCell(4,col);
            if (total == -4 || total == 4) return true;
        }
        for (int col=2; col<Constants.BOARD_SIZEY; col++) {
            total = getBoardCell(2, col) + getBoardCell(3,col) + getBoardCell(4, col) + getBoardCell(5,col);
            if (total == -4 || total == 4) return true;
        }
        total = getBoardCell(0,0) + getBoardCell(1,1) + getBoardCell(2,2) + getBoardCell(3,3);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(0,1) + getBoardCell(1,2) + getBoardCell(2,3) + getBoardCell(3,4);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(0,2) + getBoardCell(1,3) + getBoardCell(2,4) + getBoardCell(3,5);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(0,3) + getBoardCell(1,4) + getBoardCell(2,5) + getBoardCell(3,6);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(0,6) + getBoardCell(1,5) + getBoardCell(2,4) + getBoardCell(3,3);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(0,5) + getBoardCell(1,4) + getBoardCell(2,3) + getBoardCell(3,2);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(0,4) + getBoardCell(1,3) + getBoardCell(2,2) + getBoardCell(3,1);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(0,3) + getBoardCell(1,2) + getBoardCell(2,1) + getBoardCell(3,0);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(1,0) + getBoardCell(2,1) + getBoardCell(3,2) + getBoardCell(4,3);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(1,1) + getBoardCell(2,2) + getBoardCell(3,3) + getBoardCell(4,4);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(1,2) + getBoardCell(2,3) + getBoardCell(3,4) + getBoardCell(4,5);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(1,3) + getBoardCell(2,4) + getBoardCell(3,5) + getBoardCell(4,6);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(1,6) + getBoardCell(2,5) + getBoardCell(3,4) + getBoardCell(4,3);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(1,5) + getBoardCell(2,4) + getBoardCell(3,3) + getBoardCell(4,2);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(1,4) + getBoardCell(2,3) + getBoardCell(3,2) + getBoardCell(4,1);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(1,3) + getBoardCell(2,2) + getBoardCell(3,1) + getBoardCell(4,0);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(2,0) + getBoardCell(3,1) + getBoardCell(4,2) + getBoardCell(5,3);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(2,1) + getBoardCell(3,2) + getBoardCell(4,3) + getBoardCell(5,4);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(2,2) + getBoardCell(3,3) + getBoardCell(4,4) + getBoardCell(5,5);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(2,3) + getBoardCell(3,4) + getBoardCell(4,5) + getBoardCell(5,6);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(2,6) + getBoardCell(3,5) + getBoardCell(4,4) + getBoardCell(5,3);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(2,5) + getBoardCell(3,4) + getBoardCell(4,3) + getBoardCell(5,2);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(2,4) + getBoardCell(3,3) + getBoardCell(4,2) + getBoardCell(5,1);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(2,3) + getBoardCell(3,2) + getBoardCell(4,1) + getBoardCell(5,0);
        if (total == -4 || total == 4) return true;
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
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }
    
    public void reset(){
        gameState = Constants.STANDBY;
        board = new int[Constants.BOARD_SIZEX][Constants.BOARD_SIZEY];
    }
}