package View;

import Model.Board;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class View {
    public static final int SIZE_OF_TILE = 75; //Global Constant for Size Of Tiles
    public static final int SIZE_OF_SCENE = 780; //Global Constant for Window Size

    private Stage mainStage;
    private Scene scene;
    private Group root;
    private ToggleGroup tg;
    private Button newGame;
    private Button rectangleFound;
    private RadioButton rbLVL1;
    private RadioButton rbLVL2;
    private RadioButton rbLVL3;
    private BoardView boardView;

    public View(Stage stage){
        mainStage = stage;

        root = new Group();

        setUpButtons();

        scene = new Scene(root, SIZE_OF_SCENE , SIZE_OF_SCENE);
        scene.setFill(Color.ANTIQUEWHITE);

        mainStage.setScene(scene);
        mainStage.show();
    }

    public void drawNewBoard(Board board){
        boardView = new BoardView(board);
        boardView.show(root);
    }

    public void changeLevel(Board board){
        root = new Group();
        setUpButtons();
        scene.setRoot(root);
        drawNewBoard(board);
    }

    public Button getNewGame(){
        return newGame;
    }

    public Button getRectangleFound(){
        return rectangleFound;
    }

    public int getLevelButtonSelected(){ //this method return which level selection radio button is currently selected.
        if(rbLVL1.isSelected())
            return 1;
        if(rbLVL2.isSelected())
            return 2;
        return 3;
    }

    public void debugFunction(){
        Rectangle dbg = new Rectangle(0,0, 200, 200);
        this.root.getChildren().add(dbg);
    }

    public void update(){
        mainStage.show();
    }

    private void setUpButtons(){
        newGame = new Button("NEW GAME");
        newGame.setPadding(new Insets(10, 20, 10, 20));
        newGame.setLayoutX(30);
        newGame.setLayoutY(30);

        tg = new ToggleGroup();

        rbLVL1 = new RadioButton("LEVEL 1");
        rbLVL1.setToggleGroup(tg);
        rbLVL1.setSelected(true);
        rbLVL1.setPadding(new Insets(10, 20, 10, 20));
        rbLVL1.setLayoutX(30);
        rbLVL1.setLayoutY(60);

        rbLVL2 = new RadioButton("LEVEL 2");
        rbLVL2.setToggleGroup(tg);
        rbLVL2.setPadding(new Insets(10, 20, 10, 20));
        rbLVL2.setLayoutX(30);
        rbLVL2.setLayoutY(90);

        rbLVL3 = new RadioButton("LEVEL 3");
        rbLVL3.setToggleGroup(tg);
        rbLVL3.setPadding(new Insets(10, 20, 10, 20));
        rbLVL3.setLayoutX(30);
        rbLVL3.setLayoutY(120);

        rectangleFound = new Button("CLCIK");
        rectangleFound.setLayoutY(200);
        rectangleFound.setLayoutX(30);

        root.getChildren().addAll(rbLVL1, rbLVL2, rbLVL3, newGame, rectangleFound);
    }

    public BoardView getBoardView(){
        return boardView;
    }

}
