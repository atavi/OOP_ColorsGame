package Model;

public class Model {

    private Game game;

    public Model(){
    }

    public void setGame(Board.Level level){
        game = new Game(level);
    }

    public Board getBoard(){
        return game.getBoard();
    }

    public Game getGame() {
        return game;
    }
}
