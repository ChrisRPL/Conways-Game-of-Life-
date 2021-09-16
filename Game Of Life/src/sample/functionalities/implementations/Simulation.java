package sample.functionalities.implementations;

import sample.functionalities.interfaces.CellsLoader;
import sample.models.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {
    private List<List<Cell>> cellsGrid;

    Simulation(CellsLoader cellsLoader) {
        cellsGrid = cellsLoader.loadCells();
    }

    public void doOneSimulationSequence() {
        List<List<Cell>> cellsGridCopy = new ArrayList<>(cellsGrid);
        for (int i=1; i<cellsGrid.size()-1; i++){
            for (int j=1; j<cellsGrid.get(0).size()-1; j++){
                checkAndSetCellStatus(cellsGrid.get(i).get(j));
                cellsGridCopy.get(i).set(j, cellsGrid.get(i).get(j));
            }
        }

        for (int i=0; i<cellsGrid.size(); i++){
            for (int j=0; j<cellsGrid.get(i).size(); j++){
                cellsGrid.get(i).set(j, cellsGridCopy.get(i).get(j));
            }
        }
    }

    private int getAliveNeighborsCount(Cell cell) {
        int aliveNeighbors = 0;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                aliveNeighbors += cellsGrid.get(cell.getRow()+i).get(cell.getColumn()+j).isAlive() ? 1 : 0;

            aliveNeighbors -= cell.isAlive() ? 1 : 0;
            return aliveNeighbors;
    }

    private void checkAndSetCellStatus(Cell cell) {
        int aliveNeighbors = getAliveNeighborsCount(cell);

        if (cell.isAlive()){
            if (aliveNeighbors < 2 || aliveNeighbors > 3)
                cell.setAlive(false);
        } else {
            if (aliveNeighbors == 3)
                cell.setAlive(true);
        }
    }
}
