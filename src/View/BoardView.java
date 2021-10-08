package View;

import Model.Board;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class BoardView {

    public static final int TOP_LEFT_X = 150, TOP_LEFT_Y = 50; //Global Constant for Board position

    private Rectangle board;
    private TileView[][] tiles;
    private int[] pressedTilesIndexes;
    private int pressedTilesCount;
    private int sizeOfBoard;

    public BoardView(Board b) {
        this.sizeOfBoard = b.getBoardLength() * View.SIZE_OF_TILE;
        this.board = new Rectangle(TOP_LEFT_X, TOP_LEFT_Y, sizeOfBoard, sizeOfBoard);
        this.tiles = new TileView[b.getBoardLength()][b.getBoardLength()];
        for (int i = 0; i < b.getBoardLength(); i++)
            for (int j = 0; j < b.getBoardLength(); j++)
                this.tiles[i][j] = new TileView(b.getTiles()[i][j],
                        TOP_LEFT_X + i * View.SIZE_OF_TILE, TOP_LEFT_Y + j * View.SIZE_OF_TILE);
        this.pressedTilesIndexes = new int[2 * b.getBoardLength() * b.getBoardLength()];
        this.pressedTilesCount = 0;
    }

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }

    public int[] findPressedTiles() {
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles.length; j++)
                if (tiles[i][j].isClicked()) {
                    pressedTilesIndexes[pressedTilesCount * 2] = i;
                    pressedTilesIndexes[(pressedTilesCount * 2) + 1] = j;
                    pressedTilesCount++;
                }
        return pressedTilesIndexes;
    }


    public TileView[][] getTiles() {
        return tiles;
    }

    public void show(Group root) {
        root.getChildren().add(board);
        for (int i = 0; i < tiles.length * tiles.length; i++)
            tiles[i / tiles.length][i % tiles.length].show(root);
    }
}
