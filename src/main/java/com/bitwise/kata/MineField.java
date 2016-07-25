package com.bitwise.kata;


/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
class MineField extends Field {


    MineField(int noOfRows, int noOfColumns) {
        super(noOfRows, noOfColumns);
    }

    @Override
    void validateColumnInputSquares(String[] fieldSquaresInputString) {

        for (int rowIndex = 0; rowIndex < this.getNoOfRows(); rowIndex++) {

            if (fieldSquaresInputString.length != this.getNoOfRows() ||
                    fieldSquaresInputString[rowIndex].length() != this.getNoOfColumns() ||
                    !fieldSquaresInputString[rowIndex].matches("[*.\\s]+"))
                throw new InputValidationFailedException();
        }
    }


    class InputValidationFailedException extends RuntimeException {
    }
}
