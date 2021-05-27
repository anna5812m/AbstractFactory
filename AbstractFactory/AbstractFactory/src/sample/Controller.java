package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import model.*;

public class Controller {
    public Canvas canvas;
    public GraphicsContext gr;
    public ListView choiceOfArrow;
    private ObservableList<AbstractProductArrow> items;
    private AbstractProductArrow currentArrow;

    public void initialize() {
        ArrowDependence arrowDependence = new FactoryDependence().CreateArrow(1, 5, 55, 55);
        ArrowAssociation arrowAssociation = new FactoryAssociation().CreateArrow(1, 5, 55, 55);
        ArrowAggregation arrowAggregation = new FactoryAggregation().CreateArrow(1, 5, 55, 55);
        items = FXCollections.observableArrayList(arrowDependence,arrowAssociation,arrowAggregation);
        choiceOfArrow.setItems(items);
        choiceOfArrow.getSelectionModel().select(1);
        gr = canvas.getGraphicsContext2D();
        currentArrow = null;
    }

    public void mousePressed(MouseEvent mouseEvent) {
        currentArrow = (AbstractProductArrow) items.get(choiceOfArrow.getSelectionModel().getSelectedIndex()).clone();
        currentArrow.setStartX(mouseEvent.getX());
        currentArrow.setStartY(mouseEvent.getY());
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        if(currentArrow != null) {
            currentArrow.setEndX(mouseEvent.getX());
            currentArrow.setEndY(mouseEvent.getY());
            currentArrow.draw(gr);
            }
        currentArrow = null;
        }

    public void clear(ActionEvent actionEvent) {
        gr.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
    }
}

