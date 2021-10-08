package Model;

public class Board {
    public enum Level {LEVEL_1, LEVEL_2, LEVEL_3}

    private Tile[][] tiles;
    private int[] pressedTilesIndexes;
    private Level lvl;


    public Board(Level lvl) {
        this.lvl = lvl;
        switch (lvl) {
            case LEVEL_1:
                setUpBoard(8);
                break;
            case LEVEL_2:
                setUpBoard(10);
                break;
            case LEVEL_3:
                setUpBoard(12);
                break;
        }
    }

    public void setUpBoard(int a) {
        this.tiles = new Tile[a][a];
        for (int i = 0; i < a * a; i++)
            tiles[i / a][i % a] = new Tile(getLvl());
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setPressedTilesIndexes(int[] PTI) {
        this.pressedTilesIndexes = PTI;
    }

    public int findRectangles() {
        int p1_i, p1_j, p2_j = -1, p3_i = -1;

        for (int i = 0; i < pressedTilesIndexes.length - 2 ; i += 2) {
            p1_i = pressedTilesIndexes[i];
            p1_j = pressedTilesIndexes[i + 1];
            for(int i_2 = i + 2 ; i_2 < pressedTilesIndexes.length ; i_2 += 2)
                if (pressedTilesIndexes[i_2] == p1_i)
                    p2_j = pressedTilesIndexes[i_2 + 1];
            for(int j = i + 3 ; j < pressedTilesIndexes.length ; j += 2)
                if(pressedTilesIndexes[j] == p1_j)
                    p3_i = pressedTilesIndexes[j - 1];
            for(int j_2 = i + 2 ; j_2 < pressedTilesIndexes.length ; j_2 += 2)
                if(pressedTilesIndexes[j_2] == p3_i && pressedTilesIndexes[j_2 + 1] == p2_j)
                    return Math.abs((p3_i - p1_i) * (p2_j - p1_j));
        }
        return -1;
    }

    public int getBoardLength() {
        return this.tiles.length;
    }

    public Level getLvl() {
        return this.lvl;
    }
}
