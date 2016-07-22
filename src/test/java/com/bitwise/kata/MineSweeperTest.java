package com.bitwise.kata;

import org.junit.Test;

/**
 * Created by rahuln on 7/21/2016.
 */
public class MineSweeperTest {
    MineSweeper mineSweeper = new MineSweeper();
    @Test
    public void itShouldAcceptUserInput_numeric(){
        mineSweeper.getField(" 5  5 ");
    }

    @Test(expected = MineSweeper.InputFormatViolationException.class)
    public void itShouldNotAcceptUserInput_AlphaNumeric(){
        mineSweeper.getField("a 5");
    }

    @Test(expected = MineSweeper.InputFormatViolationException.class)
    public void itShouldNotAcceptMoreThanTwoParameters(){
        mineSweeper.getField("5  5  5");
    }




}
