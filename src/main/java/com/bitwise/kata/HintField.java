package com.bitwise.kata;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
class HintField extends Field {



    HintField(int noOfRows, int noOfColumns) {
        super(noOfRows,noOfColumns);//
    }

    @Override
    void validateColumnInputSquares(String[] fieldSquaresInputString) {

        for (String aFieldSquaresInputString : fieldSquaresInputString) {

            if (fieldSquaresInputString.length != this.getNoOfRows() ||
                    aFieldSquaresInputString.length() != this.getNoOfColumns() ||
                    !aFieldSquaresInputString.matches("[0-8*\\s]+"))
                throw new InputValidationFailedException();
        }
    }

    private class InputValidationFailedException extends RuntimeException {
    }
}
