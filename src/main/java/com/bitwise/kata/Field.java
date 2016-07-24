package com.bitwise.kata;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
abstract class Field {

    private final int noOfRows;
    private final int noOfColumns;
    private final Square[][] squares;

    Field(int noOfRows, int noOfColumns) {
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

    void displaySquares(){
        for (Square[] square : squares) {
            for (Square aSquare : square) System.out.print(aSquare);
            System.out.println();
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
