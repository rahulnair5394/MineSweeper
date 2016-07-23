package com.bitwise.kata;

import org.junit.Assert;
import org.junit.Test;


public class MineSweeperTest {

    @Test
    public void itShouldAcceptUserInput_numeric() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField(" 5  5 ");
        //then

    }

    @Test(expected = MineSweeper.InputFormatViolationException.class)
    public void itShouldNotAcceptUserInput_AlphaNumeric() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField("a 5");
        //then

    }

    @Test(expected = MineSweeper.InputFormatViolationException.class)
    public void itShouldNotAcceptMoreThanTwoParameters() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField(" 5 5 5 ");
        //then


    }

    @Test
    public void itShouldCreateAField() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField("5  5");
        //then
        Assert.assertFalse(mineSweeper.isMineFieldEmpty());
    }

    /*@Test
    public void itShouldCreateAndInitializeAField(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addField("5  5");
        if(mineSweeper.hasField(0)) {
            Field field = mineSweeper.getField(0);
            int noOFRows=field.getNoOfRows;
            int noOfColumns=field.getNoOfColumns;
            Square[][] squares= new Square[noOFRows][noOfColumns];
            field.setSquares(squares);


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
*/
    @Test
    public void itShouldCreateAndInitializeAField() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField("5  5");
        if (mineSweeper.hasMineField(0)) {
            Field field = mineSweeper.getMineField(0);
            String squareInput[] = {"*....", "..*.*", ".*..*", "...*.", "....."};
            field.setSquares(squareInput);
        }
        //then
        Assert.assertTrue(mineSweeper.hasMineField(0));
    }

    @Test
    public void itShouldCreateAndDisplayAField() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField("5  5");
        if (mineSweeper.hasMineField(0)) {
            Field field = mineSweeper.getMineField(0);
            String squareInput[] = {"*....", "..*.*", ".*..*", "...*.", "....."};
            field.setSquares(squareInput);
            Square[][] squares = field.getSquares();
            for (Square[] square : squares) {
                for (Square aSquare : square) System.out.print(aSquare);
                System.out.println();
            }
        }
        //then
        Assert.assertTrue(mineSweeper.hasMineField(0));
    }

    @Test(expected = MineField.InputValidationFailedException.class)
    public void itShouldAddMultipleFields_mismatchFail() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField("5  5");
        if (mineSweeper.hasMineField(0)) {
            Field field = mineSweeper.getMineField(0);
            String squareInput[] = {"*....", "..*.*", ".*..*", "...*.", "....."};
            field.setSquares(squareInput);
        }
        mineSweeper.addMineField("5  6 ");
        if (mineSweeper.hasMineField(1)) {
            Field field = mineSweeper.getMineField(1);
            String squareInput[] = {"*....", "..*.*", ".*..*", "...*.", "....."};
            field.setSquares(squareInput);
        }
        //then
        Assert.assertTrue(mineSweeper.hasMineField(0));
    }

    @Test
    public void itShouldAddMultipleFields() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField("5  4 ");
        if (mineSweeper.hasMineField(0)) {
            Field field = mineSweeper.getMineField(0);
            String squareInput[] = {"*...", "..*.", ".*..", "...*", "...."};
            field.setSquares(squareInput);
        }


        mineSweeper.addMineField("5  5");
        if (mineSweeper.hasMineField(1)) {
            Field field = mineSweeper.getMineField(1);
            String squareInput[] = {"*....", "..*.*", ".*..*", "...*.", "....."};
            field.setSquares(squareInput);
        }

        //then
        Assert.assertTrue(mineSweeper.hasMineField(0));
        Assert.assertTrue(mineSweeper.hasMineField(1));
    }




}
