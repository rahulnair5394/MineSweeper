package com.bitwise.kata;

import java.util.Arrays;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
abstract class Field {

    private int noOfRows;
    private int noOfColumns;
    private Square[][] squares;

    protected Field(int noOfRows, int noOfColumns) {
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        squares = new Square[this.noOfRows][this.noOfColumns];
    }



    void setSquares(String[] fieldSquaresInputStrings){
        this.validateColumnInputSquares(fieldSquaresInputStrings);
        for (int i = 0; i < noOfRows; i++) {
            fieldSquaresInputStrings[i] = fieldSquaresInputStrings[i].replaceAll("\\s+", "");
            char[] currentRow = fieldSquaresInputStrings[i].toCharArray();
            for (int j = 0; j < noOfColumns; j++) squares[i][j] = new Square(currentRow[j]);
        }
    }

    abstract void validateColumnInputSquares(String[] fieldSquaresInputStrings);


    Square[][] getSquares() {
        return this.squares;
    }
    int getNoOfRows() {
        return this.noOfRows;
    }
    int getNoOfColumns() {
        return this.noOfColumns;
    }


}
