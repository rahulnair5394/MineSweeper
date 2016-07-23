package com.bitwise.kata;

/**
 * Created by rahuln on 7/22/2016.
 */
interface Field {

    void setSquares(String[] fieldSquaresInputStrings);
    Square[][] getSquares();
    int getNoOfRows();
    int getNoOfColumns();

}
