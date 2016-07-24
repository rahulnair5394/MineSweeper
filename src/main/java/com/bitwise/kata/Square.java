package com.bitwise.kata;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
public class Square {
    private final char squareType;

    public Square(char inputSquareType) {
        this.squareType = inputSquareType;
    }

    public char getSquareType() {
        return squareType;
    }

    @Override
    public String toString() {
        return String.valueOf(squareType);
    }
}
