package com.bitwise.kata;

/**
 * Created by Rahul Nair on 7/23/2016.
 */
public class HintField implements Field{

    private final int noOfRows;
    private final int noOfColumns;
    private final Square[][] squares;

    public HintField(int noOfRows, int noOfColumns) {//
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        squares = new Square[this.noOfRows][this.noOfColumns];
    }

    @Override
    public void setSquares(String[] fieldSquaresInputStrings) {

    }

    @Override
    public Square[][] getSquares() {
        return new Square[0][];
    }

    @Override
    public int getNoOfRows() {
        return this.noOfRows;
    }

    @Override
    public int getNoOfColumns() {
        return this.noOfColumns;
    }
}
