package View;

import Model.Tile;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TileView {

    private Rectangle rct;
    private Tile.color color;
    private int r, g, b;
    private boolean isClicked;

    public TileView(Tile tile, double x, double y) {
        this.rct = new Rectangle(x, y, View.SIZE_OF_TILE, View.SIZE_OF_TILE);
        setTileColor(tile.getTileColor());
        this.isClicked = false;
        rct.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tileIsPressed();
            }
        });
    }

    private void setTileColor(Tile.color color) {
        this.color = color;
        switch (color) {
            case RED:
                setRGB(141, 2, 31);
                break;
            case ORANGE:
                setRGB(240, 94, 35);
                break;
            case YELLOW:
                setRGB(252, 226, 5);
                break;
            case CYAN:
                setRGB(64, 224, 208);
                break;
            case VIOLET:
                setRGB(178, 0, 237);
                break;
            case BLUE:
                setRGB(16, 52, 166);
                break;
            case GREEN:
                setRGB(60, 180, 100);
                break;
            case MAGENTA:
                setRGB(255, 0, 144);
                break;
        }
    }

    public void tileIsPressed() {
        if (!isClicked) {
            rct.setFill(Color.rgb((int) (r / 2.5), (int) (g / 2.5), (int) (b / 2.5)));
        } else {
            rct.setFill(Color.rgb(r, g, b));
        }
        isClicked = !isClicked;
    }

    private void setRGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void show(Group root) {
        rct.setFill(Color.rgb(r, g, b));
        rct.setStroke(Color.BLACK);
        rct.setStrokeWidth(4);
        root.getChildren().add(rct);
    }

}
