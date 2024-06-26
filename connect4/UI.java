package connect4;

//extended from a tictactoe game code
//ChatGPT used in debugging
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
        return 1 <= col && col <= Constants.BOARD_SIZEX && state.getBoardCell(col, 1) == Constants.BLANK;
    }
    
    public String promptForName(String player) {
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();
    }
    
    public int getMoveCol(int whoseMove, String xName, String oName) {
        int col = 0;
        while (col < 1 || col > Constants.BOARD_SIZEX) {
            System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
            try {
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_COL);
                scanner.next();
                continue;
            }
            if (col < 1 || col > Constants.BOARD_SIZEX) {
                System.out.println(Constants.INVALID_COL);
            }
        }
        return col - 1;
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
        for (int row = 0; row < Constants.BOARD_SIZEY; row++) {
            for (int col = 0; col < Constants.BOARD_SIZEX; col++) {
                System.out.print("| " + getXOrO(state.getBoardCell(col, row)) + " ");
            }
            System.out.println("|");
            System.out.println(Constants.DIVIDER_STRING);
        }
    }
    
    public void printInvalidColumn(int col) {
        System.out.printf(Constants.INVALID_COL);
    }
    
    public void printInvalidMove(int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, col);
    }
    
    public void printMove(State state, int col){
        System.out.printf(Constants.PRINT_MOVE, getXOrO(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()), col+1);
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
