package com.bitwise.kata;

/**
 * Created by rahul.nair@bitwiseglobal.com .
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
