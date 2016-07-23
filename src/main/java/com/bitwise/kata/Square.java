package com.bitwise.kata;

/**
 * Created by rahuln on 7/22/2016.
 */
public class Square {
    char squareType;

    public Square(char inputSquareType) {
    this.squareType=inputSquareType;

    }

    public char getType() {
        return squareType;
    }

    @Override
    public String toString() {
        return String.valueOf(squareType);
    }
}
