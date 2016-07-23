package com.bitwise.kata;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
interface Field {

    void setSquares(String[] fieldSquaresInputStrings);
    Square[][] getSquares();
    int getNoOfRows();
    int getNoOfColumns();

}
