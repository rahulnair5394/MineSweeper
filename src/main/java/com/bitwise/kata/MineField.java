package com.bitwise.kata;


/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
public class MineField extends Field {




    public MineField(int noOfRows, int noOfColumns) {
        super(noOfRows,noOfColumns);
    }

    @Override
    void validateColumnInputSquares(String[] fieldSquaresInputString) {

        for (int i = 0; i < this.getNoOfColumns(); i++) {

            if (fieldSquaresInputString.length != this.getNoOfRows() ||
                    fieldSquaresInputString[i].length() != this.getNoOfColumns() ||
                    !fieldSquaresInputString[i].matches("[*.\\s]+"))
                throw new InputValidationFailedException();
        }
    }


    public class InputValidationFailedException extends RuntimeException {
    }
}
