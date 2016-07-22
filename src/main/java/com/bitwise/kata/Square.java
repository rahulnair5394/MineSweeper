package com.bitwise.kata;

/**
 * Created by rahuln on 7/22/2016.
 */
public class Square {
    Type squareType;

    public Square(char inputSquareType) {
        if (inputSquareType == '*') {
            this.squareType = HintFieldType.BOMB;
        }

    }

    public Type getType() {
        return squareType;
    }



}
