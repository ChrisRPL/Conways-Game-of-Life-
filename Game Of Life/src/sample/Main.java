package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.CellsGridController;
import sample.functionalities.implementations.FileCellsLoader;
import sample.functionalities.implementations.RandomCellsLoader;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        List<String> programParameters = getParameters().getRaw();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/res/fxml/cells_grid.fxml"));
        Parent root = loader.load();
        Scene startPage = new Scene(root);

        CellsGridController cellsGridController = loader.getController();

        if (programParameters.size() > 1) {
            int rows = Integer.parseInt(programParameters.get(0));
            int cols = Integer.parseInt(programParameters.get(1));

            cellsGridController.setSimulationValues(new RandomCellsLoader(rows, cols));
        } else {
            String filePath = programParameters.get(0);
            cellsGridController.setSimulationValues(new FileCellsLoader(filePath));
        }

        primaryStage.setScene(startPage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
