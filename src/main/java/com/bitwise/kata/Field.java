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


    void setSquares(String[] fieldSquaresInputStrings) {
        fieldSquaresInputStrings=processStringInput(fieldSquaresInputStrings);
        this.validateColumnInputSquares(fieldSquaresInputStrings);
        for (int fieldSquaresInputStringsIndex = 0; fieldSquaresInputStringsIndex < noOfRows; fieldSquaresInputStringsIndex++) {
            fieldSquaresInputStrings[fieldSquaresInputStringsIndex] = fieldSquaresInputStrings[fieldSquaresInputStringsIndex].replaceAll("\\s+", "");
            char[] currentRow = fieldSquaresInputStrings[fieldSquaresInputStringsIndex].toCharArray();
            for (int columnIndex = 0; columnIndex < noOfColumns; columnIndex++)
                squares[fieldSquaresInputStringsIndex][columnIndex] = new Square(currentRow[columnIndex]);
        }
    }

    private String[] processStringInput(String[] fieldSquaresInputStrings) {
        for(int index = 0; index < fieldSquaresInputStrings.length; index++)
            fieldSquaresInputStrings[index]=fieldSquaresInputStrings[index].replaceAll("[ ]+","");
        return fieldSquaresInputStrings;
    }

    void displaySquares() {
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
