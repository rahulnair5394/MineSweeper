package com.bitwise.kata;

import java.util.Scanner;

/**
 * Created by rahuln on 7/22/2016.
 */
public class MineField implements Field {

    private final int noOfRows;
    private final int noOfColumns;
    private final MineSquare[][] squares;
    Scanner scan = new Scanner(System.in);

    public MineField(String noOfRows, String noOfColumns) {//
        this.noOfRows = Integer.parseInt(noOfRows);
        this.noOfColumns = Integer.parseInt(noOfColumns);
        squares = new MineSquare[this.noOfRows][this.noOfColumns];

    }


    @Override
    public void setSquares(String fieldSquaresInputString, int atIndex) {

        validateColumnInputSquares(fieldSquaresInputString);
        fieldSquaresInputString.replaceAll("\\s+", "");
        char[] currentRow = fieldSquaresInputString.toCharArray();

        for (int i = 0; i < noOfColumns; i++) {
            squares[atIndex][i] = new MineSquare(currentRow[i]);
        }

    }

    @Override
    public void getSquares(int atIndex) {
        for (int i = 0; i < noOfColumns; i++) {
            System.out.print(squares[atIndex][i].getType());
        }
        System.out.println();

    }


    private void validateColumnInputSquares(String fieldSquaresInputString) {

        for (int i = 0; i < noOfColumns; i++) {
            if (fieldSquaresInputString.length() > noOfColumns)
                System.out.println("Column size exceeded for row ");
            if (!fieldSquaresInputString.matches("[*.\\s]+"))
                System.out.println("Row contains unexpected format ");
        }
    }


}
