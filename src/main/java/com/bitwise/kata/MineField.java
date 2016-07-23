package com.bitwise.kata;


/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
public class MineField implements Field {

    private final int noOfRows;
    private final int noOfColumns;
    private final Square[][] squares;


    public MineField(int noOfRows, int noOfColumns) {
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        squares = new Square[this.noOfRows][this.noOfColumns];

    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }

    @Override
    public void setSquares(String[] fieldSquaresInputString) {
        validateColumnInputSquares(fieldSquaresInputString);
        for (int i = 0; i < noOfRows; i++) {
            fieldSquaresInputString[i] = fieldSquaresInputString[i].replaceAll("\\s+", "");
            char[] currentRow = fieldSquaresInputString[i].toCharArray();
            for (int j = 0; j < noOfColumns; j++) squares[i][j] = new Square(currentRow[j]);
        }
    }

    @Override
    public Square[][] getSquares() {
       return squares;
    }


    private void validateColumnInputSquares(String[] fieldSquaresInputString) {

        for (int i = 0; i < noOfColumns; i++) {

            if (fieldSquaresInputString.length != noOfRows ||
                    fieldSquaresInputString[i].length() != noOfColumns ||
                    !fieldSquaresInputString[i].matches("[*.\\s]+"))
                throw new InputValidationFailedException();
        }
    }


    public class InputValidationFailedException extends RuntimeException {
    }
}
