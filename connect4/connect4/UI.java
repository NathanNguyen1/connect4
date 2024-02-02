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
        return 1 <= col && col <= Constants.BOARD_SIZEX && state.getBoardCell(col -1) == Constants.BLANK;
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
}