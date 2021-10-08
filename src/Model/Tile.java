package Model;

import java.util.Random;

public class Tile {
    public enum color {BLUE, ORANGE, GREEN, YELLOW, RED, MAGENTA, VIOLET, CYAN};

    private color tileColor;

    public Tile(Board.Level lvl){
        Random rnd = new Random();
        switch (lvl) {
            case LEVEL_1:
                setColor(rnd.nextInt(4));
                break;
            case LEVEL_2:
                setColor(rnd.nextInt(6));
                break;
            case LEVEL_3:
                setColor(rnd.nextInt(8));
                break;
        }
    }

    public void setColor(int num){
        switch (num){
            case 0:
                this.tileColor = color.BLUE;
                break;
            case 1:
                this.tileColor = color.GREEN;
                break;
            case 2:
                this.tileColor = color.YELLOW;
                break;
            case 3:
                this.tileColor = color.RED;
                break;
            case 4:
                this.tileColor = color.MAGENTA;
                break;
            case 5:
                this.tileColor = color.ORANGE;
                break;
            case 6:
                this.tileColor = color.CYAN;
                break;
            case 7:
                this.tileColor = color.VIOLET;
                break;
        }
    }

    public color getTileColor() {
        return tileColor;
    }

}
