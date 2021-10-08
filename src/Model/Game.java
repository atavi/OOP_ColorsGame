package Model;

public class Game {

    private String playerName;
    private int score;
    private Board board;
    private boolean isOn;

    public Game(Board.Level level, String name){
        this.isOn = true;
        this.board = new Board(level);
        this.score = 0;
        this.playerName = name;
    }

    public Game(Board.Level level){
        this.isOn = true;
        this.board = new Board(level);
        this.score = 0;
        this.playerName = "New Player";
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOnOff(){
        this.isOn = !isOn;
    }

    public Board getBoard() {
        return this.board;
    }
}
