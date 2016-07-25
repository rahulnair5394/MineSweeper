package com.bitwise.kata;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
class HintFieldCreator {

    private Field hintField;
    private Square[][] tempSquare;
    private String[] tempArray;

    Field makeHintField(Field mineField) {
        tempSquare = new Square[mineField.getNoOfRows()][mineField.getNoOfColumns()];
        hintField = new HintField(mineField.getNoOfRows(), mineField.getNoOfColumns());
        tempSquare = mineField.getSquares();
        tempArray = new String[mineField.getNoOfRows()];
        processTempSquare();
        return convertHintField();
    }

    private void processTempSquare() {
        for (int rowIndex = 0; rowIndex < tempSquare.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < tempSquare[rowIndex].length; columnIndex++)
                tempSquare[rowIndex][columnIndex] = new Square(getChar(rowIndex, columnIndex));
        }

    }

    private char getChar(int rowIndex, int columnIndex) {
        if (tempSquare[rowIndex][columnIndex].getSquareType() == '*')
            return '*';
        else return calculateAffinity(rowIndex, columnIndex);
    }

    private char calculateAffinity(int rowIndex, int columnIndex) {
        int affinity = 48;
        if (tempSquare[rowIndex][columnIndex].getSquareType() == '.') {
            affinity = findNeighbours(rowIndex, columnIndex, affinity);
        }
        return (char) affinity;

    }

    private int findNeighbours(int rowIndex, int columnIndex, int affinity) {
        for (int neighbourRowIndex = rowIndex - 1; neighbourRowIndex <= rowIndex + 1; neighbourRowIndex++)
            for (int neighbourColumnIndex = columnIndex - 1; neighbourColumnIndex <= columnIndex + 1; neighbourColumnIndex++) affinity = checkNeighbour(affinity, neighbourRowIndex, neighbourColumnIndex);
        return affinity;
    }

    private int checkNeighbour(int affinity, int neighbourRowIndex, int neighbourColumnIndex) {
        if (isValid(neighbourRowIndex, neighbourColumnIndex))
            if (tempSquare[neighbourRowIndex][neighbourColumnIndex].getSquareType() == '*')
                affinity++;
        return affinity;
    }

    private boolean isValid(int neighbourRowIndex, int neighbourColumnIndex) {
        return neighbourRowIndex >= 0 && neighbourRowIndex < tempSquare.length && neighbourColumnIndex >= 0 && neighbourColumnIndex < tempSquare[neighbourRowIndex].length;
    }


    private Field convertHintField() {
        for (int rowIndex = 0; rowIndex < hintField.getNoOfRows(); rowIndex++) {
            String rowStringSet = convertToString(tempSquare[rowIndex]);
            //s=s.replaceAll("[.]","1"); //for testing
            tempArray[rowIndex] = rowStringSet;
        }
        hintField.setSquares(tempArray);
        return hintField;
    }

    private String convertToString(Square[] squareArray) {  //copied and modified Arrays.toString();
        if (squareArray == null) throw new UnexpectedNullStringFound();
        int iMax = squareArray.length - 1;
        if (iMax == -1)
            return "";
        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(String.valueOf(squareArray[i]));
            if (i == iMax)
                return b.toString();
        }
    }


    private class UnexpectedNullStringFound extends RuntimeException {
    }
}
