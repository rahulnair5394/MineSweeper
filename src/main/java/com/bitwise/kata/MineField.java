package com.bitwise.kata;

/**
 * Created by rahuln on 7/22/2016.
 */
public class MineField implements Field {
    private final int noOfRows;
    private final int noOfColumns;
    private Square[][] squares;

    public MineField(int noOfRows,int noOfColumns) {
        this.noOfRows=noOfRows;
        this.noOfColumns = noOfColumns;
    }



    @Override
    public void setSquares(char[][] fieldSquaresInputString) {
        squares=new Square[noOfRows][noOfColumns];
        validateColumnInputSquares(fieldSquaresInputString);




    }

    private void validateColumnInputSquares(char[][] fieldSquaresInputString) {

        for(int i =0; i<noOfRows;i++){
            if(fieldSquaresInputString[i].length>noOfColumns)
                System.out.println("Column size exceeded for row ");
            if(!fieldSquaresInputString[i].equals('.')||!fieldSquaresInputString[i].equals('*'))
                System.out.println("Row contains unexpected format ");
        }
    }
}
