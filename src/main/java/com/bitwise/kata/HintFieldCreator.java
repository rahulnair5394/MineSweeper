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
        tempSquare = new Square[mineField.getNoOfRows()][mineField.getNoOfColumns()];
        hintField = new HintField(mineField.getNoOfRows(), mineField.getNoOfColumns());
        tempSquare = mineField.getSquares();
        tempArray = new String[mineField.getNoOfRows()];
        processTempSquare();
        return convertHintField();
    }

    private void processTempSquare() {
        for (int i = 0; i < tempSquare.length; i++) {
            for (int j = 0; j < tempSquare[1].length; j++)
                tempSquare[i][j] = new Square(getChar(i, j));
        }

    }

    private char getChar(int i, int j) {
        if (tempSquare[i][j].getSquareType() == '*')
            return '*';
        else return calculateAffinity(i, j);
    }

    private char calculateAffinity(int i, int j) {
        int count = 48;
        if (tempSquare[i][j].getSquareType() == '.') {
            for (int k = i - 1; k < i + 1; k++) {
                for (int l = j - 1; l < j + 1; l++) {
                    if (isValid(k, l))
                        if (tempSquare[k][l].getSquareType() == '*')
                            count++;
                }
            }
        }
        return (char) count;

    }

    private boolean isValid(int k, int l) {
        if(k>0&&k<tempSquare.length&&l>0&&l<tempSquare[k].length)
            return true;
        return false;
    }


    private Field convertHintField() {
        for (int i = 0; i < hintField.getNoOfRows(); i++) {
            String s = convertToString(tempSquare[i]);
            //s=s.replaceAll("[.]","1");
            tempArray[i] = s;
        }
        hintField.setSquares(tempArray);
        return hintField;
    }

    private String convertToString(Square[] a) {  //copied and modified from Arrays.toString();

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
