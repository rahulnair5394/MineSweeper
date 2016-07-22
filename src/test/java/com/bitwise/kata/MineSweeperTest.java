package com.bitwise.kata;

import org.junit.Assert;
import org.junit.Test;


public class MineSweeperTest {

    @Test
    public void itShouldAcceptUserInput_numeric(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addField(" 5  5 ");
        //then

           }

    @Test(expected = MineSweeper.InputFormatViolationException.class)
    public void itShouldNotAcceptUserInput_AlphaNumeric(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addField("a 5");
        //then

    }

    @Test(expected = MineSweeper.InputFormatViolationException.class)
    public void itShouldNotAcceptMoreThanTwoParameters(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addField(" 5 5 5 ");
        //then


    }

    @Test
    public void itShouldCreateAField(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addField("5  5");
        //then
        Assert.assertFalse(mineSweeper.isMineFieldEmpty());
    }

    @Test
    public void itShouldCreateAndInitializeAField(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addField("5  5");
        if(mineSweeper.hasField(0)) {
            Field field = mineSweeper.getField(0);
            field.setSquares("*....", 0);
            field.setSquares("*...*", 1);
            field.setSquares("..*..", 2);
            field.setSquares("*...*", 3);
            field.setSquares("*.*..", 4);

        }
        //then
        Assert.assertFalse(mineSweeper.hasField(0));
    }

    @Test
    public void itShouldCreateAndDisplayAField(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addField("5  5");
        Field field = field = mineSweeper.getField(0);
          field.setSquares("*....", 0);
            field.setSquares("*...*", 1);
            field.setSquares("..*..", 2);
            field.setSquares("*...*", 3);
            field.setSquares("*.*..", 4);

        field.getSquares(0);
        field.getSquares(1);
        field.getSquares(2);
        field.getSquares(3);
        field.getSquares(4);

        //then
        Assert.assertFalse(mineSweeper.hasField(0));
    }

}
