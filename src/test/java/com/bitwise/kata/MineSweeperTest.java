package com.bitwise.kata;

import org.junit.Assert;
import org.junit.Test;


public class MineSweeperTest {

    @Test
    public void itShouldAcceptUserInput_numeric(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.getField(" 5  5 ");
        //then

           }

    @Test(expected = MineSweeper.InputFormatViolationException.class)
    public void itShouldNotAcceptUserInput_AlphaNumeric(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.getField("a 5");
        //then

    }

    @Test(expected = MineSweeper.InputFormatViolationException.class)
    public void itShouldNotAcceptMoreThanTwoParameters(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.getField(" 5 5 5 ");
        //then


    }

    @Test
    public void itShouldCreateAField(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.getField("5  5");
        //then
        Assert.assertFalse(mineSweeper.isMineFieldEmpty());
    }



}
