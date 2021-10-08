package Controller;

import Model.Board;
import Model.Model;
import View.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;

        view.update();

        view.getNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (view.getLevelButtonSelected() == 1)
                    model.setGame(Board.Level.LEVEL_1);
                else if (view.getLevelButtonSelected() == 2)
                    model.setGame(Board.Level.LEVEL_2);
                else
                    model.setGame(Board.Level.LEVEL_3);
                view.changeLevel(model.getGame().getBoard());
            }
        });

        view.getRectangleFound().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.getBoard().setPressedTilesIndexes(view.getBoardView().findPressedTiles());
                System.out.println(model.getBoard().findRectangles());
            }
        });

        /*
        ChangeListener<Toggle> toggleChangeListener = new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                if (v.getRbLVL1().equals(arg2))
                    m.setBoard(Board.Level.LEVEL_1);
                else if (v.getRbLVL2().equals(arg2))
                    m.setBoard(Board.Level.LEVEL_2);
                else if (v.getRbLVL3().equals(arg2))
                    m.setBoard(Board.Level.LEVEL_3);
                v.changeLevel(m.getBoard());
                v.update();
                }
            };
        v.addToggleChangeListener(toggleChangeListener);*/
    }
}
