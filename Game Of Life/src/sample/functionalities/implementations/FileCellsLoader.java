package sample.functionalities.implementations;

import sample.functionalities.interfaces.CellsLoader;
import sample.models.Cell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileCellsLoader implements CellsLoader {
    final private String PATH;

    public FileCellsLoader(String path) {
        this.PATH = path;
    }

    @Override
    public List<List<Cell>> loadCells() {
        List<List<Cell>> cells = new ArrayList<>();
        try {
            List<String> gridRows = Files.lines(Paths.get(PATH)).collect(Collectors.toList());
            for (int i=0; i<gridRows.size(); i++){
                char [] cellsInRow = gridRows.get(i).toCharArray();
                List<Cell> cellsRow = new ArrayList<>();
                for (int j=0; j<cellsInRow.length; j++){
                    cellsRow.add(new Cell(i, j, cellsInRow[j] == '.' ? false : true));
                }
                cells.add(cellsRow);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(cells.size() + " " + cells.get(0).size());
        return cells;
    }
}
