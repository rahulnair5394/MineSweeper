package com.bitwise.kata;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
class Square {
    private final char squareType;

    Square(char inputSquareType) {
        this.squareType = inputSquareType;
    }

    char getSquareType() {
        return squareType;
    }

    @Override
    public String toString() {
        return String.valueOf(squareType);
    }
}
