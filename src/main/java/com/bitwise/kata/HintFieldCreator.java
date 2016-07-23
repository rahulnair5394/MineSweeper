package com.bitwise.kata;

import java.util.Scanner;

/**
 * Created by Rahul Nair on 7/23/2016.
 */
public class HintFieldCreator {

    Field hintField;
    Square[][] tempSquare;

    public Field makeHintField(Field mineField) {
        tempSquare= new Square[mineField.getNoOfRows()][mineField.getNoOfColumns()];
        hintField=new HintField(mineField.getNoOfRows(),mineField.getNoOfColumns());
        return hintField;

    }


}
