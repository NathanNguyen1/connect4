package connect4;

 
public class EventLoop {
    State state =  new State();
    UI ui = new UI();
    int row, col;
    
    public static void main(String[] args) {
        EventLoop eventLoop = new EventLoop();
        eventLoop.run();
    }
    
    public void run() {
        while (state.getGameState() != Constants.QUIT_PROGRAM) {
            int gameState = state.getGameState();
            if (gameState == Constants.STANDBY) {
                state.setGameState(Constants.GET_X_NAME);
            }
        }
    }
}
