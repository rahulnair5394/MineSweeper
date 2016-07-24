package com.bitwise.kata;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
public class HintField extends Field {



    public HintField(int noOfRows, int noOfColumns) {
        super(noOfRows,noOfColumns);//
    }

    @Override
    void validateColumnInputSquares(String[] fieldSquaresInputString) {

        for (int i = 0; i < fieldSquaresInputString.length; i++) {

            if (fieldSquaresInputString.length != this.getNoOfRows() ||
                    fieldSquaresInputString[i].length() != this.getNoOfColumns() ||
                    !fieldSquaresInputString[i].matches("[0-9*\\s]+"))
                throw new InputValidationFailedException();
        }
    }

    private class InputValidationFailedException extends RuntimeException {
    }
}
