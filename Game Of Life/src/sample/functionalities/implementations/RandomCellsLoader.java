package sample.functionalities.implementations;

import sample.functionalities.interfaces.CellsLoader;
import sample.models.Cell;

import java.util.ArrayList;
import java.util.List;

public class RandomCellsLoader implements CellsLoader {
    private final int ROWS, COLS;

    RandomCellsLoader(int rows, int cols) {
        this.ROWS = rows;
        this.COLS = cols;
    }

    @Override
    public List<List<Cell>> loadCells() {
        List<List<Cell>> cells = new ArrayList<>();

        for (int i=0; i<ROWS; i++){
            List<Cell> cellsRow = new ArrayList<>();
            for (int j=0; j<COLS; j++){
                cellsRow.add(new Cell(i, j, Math.random() < 0.5));
            }
            cells.add(cellsRow);
        }

        return cells;
    }
}
