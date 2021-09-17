package sample.controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import sample.functionalities.implementations.Simulation;
import sample.functionalities.interfaces.CellsLoader;
import sample.models.Cell;

import java.util.List;

public class CellsGridController {

    private Simulation simulation;

    @FXML
    private GridPane board;

    @FXML
    public void initialize() {
        animateSimulation();
    }

    private void animateSimulation() {
        KeyFrame frame = new KeyFrame(Duration.millis(100), event -> simulation.doOneSimulationSequence());
        Timeline animation = new Timeline();
        animation.getKeyFrames().add(frame);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }

    public void setSimulationValues(CellsLoader cellsLoader) {
        simulation = new Simulation(cellsLoader);
        List<List<Cell>> cellsGrid = simulation.getCellsGrid();

        for (int i = 0; i < cellsGrid.size(); i++) {
            for (int j = 0; j < cellsGrid.get(0).size(); j++) {
                board.add(cellsGrid.get(i).get(j), j, i);
            }
        }

        board.setAlignment(Pos.CENTER);
        board.setGridLinesVisible(true);
    }

}
