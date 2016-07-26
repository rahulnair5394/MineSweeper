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
        Assert.assertFalse(mineSweeper.isMineFieldEmpty());
    }

    @Test
    public void itShouldAcceptUserInput_checkLessThanHundred() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField("101  101 ");
        //then
        Assert.assertTrue(mineSweeper.isMineFieldEmpty());
    }

    @Test
    public void itShouldAcceptUserInput_checkUpperLimit() {
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField("99  99 ");
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
        mineSweeper.addMineField("5  4 ");  /////////////////////////
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

    @Test
    public void itShouldCreateAndDisplayHintField() {
        //given
        MineSweeper mineSweeper = new MineSweeper();

        //when
        mineSweeper.addMineField("10  10 ");
        Field mineField = null;
        if (mineSweeper.hasMineField(0)) {
            mineField = mineSweeper.getMineField(0);
            String squareInput[] = {"*..*..*...", "*.*..*.*..", ".*.*....*.", "*..*...**.", "..*....*..",
                    "*..*..*...", "*.*..*.*..", ".*.*....**", "*..*...***", "..*....*.*"};
            mineField.setSquares(squareInput);
        }

        if (mineSweeper.addHintField(mineField)) {
            Square[][] squares = mineSweeper.getHintField(0).getSquares();
            for (Square[] square : squares) {
                for (Square aSquare : square) System.out.print(aSquare);
                System.out.println();
            }
        }

        //then
        Assert.assertTrue(mineSweeper.hasMineField(0));
        Assert.assertFalse(mineSweeper.isHintFieldEmpty());
        Assert.assertTrue(mineSweeper.hasHintField(0));
    }


    @Test
    public void itShouldCreateAndDisplayHintField_multiple() {  //lengthy method! can be changed in main using while.

        //given
        MineSweeper mineSweeper = new MineSweeper();

        //when
        mineSweeper.addMineField("10  10 ");
        int fieldNo = 0;
        Field mineField = null;
        if (mineSweeper.hasMineField(fieldNo)) {
            mineField = mineSweeper.getMineField(fieldNo);
            String squareInput[] = {"*..*..*...", "*.*..*.*..", ".*.*....*.", "*..*...**.", "..*....*..",
                    "*..*..*...", "*.*..*.*..", ".*.*....**", "*..*...***", "..*....*.*"};
            mineField.setSquares(squareInput);
        }

        mineSweeper.addHintField(mineField);
        System.out.println("Field #" + (fieldNo + 1));
        mineSweeper.getHintField(fieldNo).displaySquares();   //added property in field for Displaying Squares.
        System.out.println();
        fieldNo++;
        mineSweeper.addMineField("5  5 ");

        Field mineField1 = null;
        if (mineSweeper.hasMineField(fieldNo)) {
            mineField1 = mineSweeper.getMineField(fieldNo);

            String squareInput[] = {"*....", "..*.*", ".*..*", "...*.", "....."};
            mineField1.setSquares(squareInput);
        }

        mineSweeper.addHintField(mineField1);
        System.out.println("Field #" + (fieldNo + 1));
        mineSweeper.getHintField(fieldNo).displaySquares();

        //then
        Assert.assertTrue(mineSweeper.hasMineField(0));
        Assert.assertFalse(mineSweeper.isHintFieldEmpty());
        Assert.assertTrue(mineSweeper.hasHintField(0));
        Assert.assertTrue(mineSweeper.hasHintField(1));
    }

    @Test
    public void itShouldAcceptSquareValuesWithSpacesAndProcessRemovingSpaces(){
        //given
        MineSweeper mineSweeper = new MineSweeper();
        //when
        mineSweeper.addMineField("5  5");
        if (mineSweeper.hasMineField(0)) {
            Field field = mineSweeper.getMineField(0);
            String squareInput[] = {"*..  ..  ", "..  *.*", ".*  ..*", ".  ..*.", "..  ..."};
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
}

