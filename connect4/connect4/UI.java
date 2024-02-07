//extended from a tictactoe game code
package connect4;
import java.util.Scanner;

public class UI {
    Scanner scanner;
    State state = new State();
    
    public UI() {
        scanner = new Scanner(System.in);
    }
    
    public String getXOrO(int whoseMove) {
        if (whoseMove == -1) {
            return "x";
        } else if (whoseMove == 1) {
            return "O";
        } else {
            return " ";
        }
    }
    
    public String getPlayerName(int whoseMove, String xName, String yName) {
        return (whoseMove == -1) ? xName : yName;
    }
    
    public boolean isLegalMove(State state, int col) {
        return 1 <= col && col <= Constants.BOARD_SIZEX && state.getBoardCell(col, -1) == Constants.BLANK;
    }
    
    public String promptForName(String player) {
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();
    }
    
    public int getMoveCol(int whoseMove, String xName, String oName) {
        int col = 0;
        while (col <= 0 || col >= 4) {
            if (col < 0 || col > 3) {
                System.out.println(Constants.INVALID_COL);
            }
            try {
                System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_COL);
                scanner.next();
                continue;
            }
        }
        return col;
    }
    
    public boolean startNewGame() {
        System.out.println(Constants.START_NEW_GAME);
        String yesOrNo = scanner.next();
        if (yesOrNo.equals("Y") || yesOrNo.equals("y")) {
            state.reset();
            return true;
        } else {
            return false;
        }
    }
    
    public void printWelcome() {
        System.out.println(Constants.TITLE);
    }
    
    public void printBoard(State state) {
        System.out.println(Constants.DIVIDER_STRING);
        for (int row = 0; row < Constants.BOARD_SIZEX; row++) {
            System.out.printf(Constants.BOARD_STRING, getXOrO(state.getBoardCell(row, 0)), getXOrO(state.getBoardCell(row, 1)), getXOrO(state.getBoardCell(row, 2)), getXOrO(state.getBoardCell(row, 3)), getXOrO(state.getBoardCell(row, 4)), getXOrO(state.getBoardCell(row, 5)));
            System.out.println();
            System.out.println(Constants.DIVIDER_STRING);
        }
    }
    
    public void printInvalidColumn(int col) {
        if (col > 7 || col < 1) {
            System.out.printf(Constants.INVALID_COL);
        }
    }
    
    public void printInvalidMove(int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, col);
    }
    
    public void printMove(State state, int col){
        System.out.printf(Constants.PRINT_MOVE, getXOrO(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()), col);
        System.out.println();
    }
    
    public void printWinner(State state) {
        System.out.printf(Constants.WINNER, getXOrO(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()));
        System.out.println();
    }
    
    public void printTieGame() {
        System.out.println(Constants.TIE_GAME);
    }
}
