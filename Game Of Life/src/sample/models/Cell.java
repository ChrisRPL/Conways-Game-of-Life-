package sample.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
    private int row, column;
    private boolean isAlive;

    public Cell(int row, int column, boolean isAlive) {
        this.row = row;
        this.column = column;
        this.isAlive = isAlive;

        this.setFill(isAlive ? Color.BLACK : Color.WHITE);

        this.setWidth(10);
        this.setHeight(10);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
        this.setFill(isAlive ? Color.BLACK : Color.WHITE);
    }

    public Cell copy() {
        return new Cell(row, column, isAlive);
    }
}
