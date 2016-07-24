package com.bitwise.kata;

import java.util.Arrays;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
public class HintFieldCreator {

    Field hintField;
    Square[][] tempSquare;
    String[] tempArray;

    public Field makeHintField(Field mineField) {
        tempSquare= new Square[mineField.getNoOfRows()][mineField.getNoOfColumns()];
        hintField=new HintField(mineField.getNoOfRows(),mineField.getNoOfColumns());
        tempSquare=mineField.getSquares();
        tempArray=new String[mineField.getNoOfRows()];
        //processHintSquares();

        for(int i=0;i<hintField.getNoOfRows();i++) {
            String s = convertedToString(tempSquare[i]);
            s=s.replaceAll("[.]","0");
            tempArray[i]=s;
        }
        return hintField;

    }

    private String convertedToString(Square[] a){  //copied and modified from Arrays.toString();

        if (a == null)
            throw new UnexpectedNullStringFound();

        int iMax = a.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();

        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax)
                return b.toString();

        }
    }


    private class UnexpectedNullStringFound extends RuntimeException {
    }
}
