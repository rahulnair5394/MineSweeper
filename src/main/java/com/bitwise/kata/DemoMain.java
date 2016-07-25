package com.bitwise.kata;

import java.util.Scanner;

/**
 * Created by rahul.nair@bitwiseglobal.com.
 */
class DemoMain {
    public static void main(String args[]) {


        MineSweeper mineSweeper = new MineSweeper();

        Scanner scanObject = new Scanner(System.in);
        int fieldNo = -1;
        boolean status = true;

        try {
            while (status) {

                    if (mineSweeper.addMineField(scanObject.nextLine())) {
                        fieldNo++;
                    } else {
                        status = false;
                    }

                    Field mineField = null;
                    if (mineSweeper.hasMineField(fieldNo) && status) {
                        mineField = mineSweeper.getMineField(fieldNo);
                        String[] squareInput = new String[mineField.getNoOfRows()];
                        for (int inputIndex = 0; inputIndex < mineField.getNoOfRows(); inputIndex++)
                            squareInput[inputIndex] = scanObject.nextLine();
                        mineField.setSquares(squareInput);
                    }
                    mineSweeper.addHintField(mineField);

            }
        } catch (MineField.InputValidationFailedException ivf) {
            System.out.println("The squares contained unexpected value(s).. ");
            fieldNo--;
        } catch (MineSweeper.InputFormatViolationException ifv) {
            System.out.println("The dimensions you entered was not expected.. ");
        } catch (Exception e) {
            System.out.println("An unexpected Error occurred! ");
        }

        System.out.println();
        System.out.println("##Output");
        for (int hindFieldIndex = 0; hindFieldIndex <= fieldNo; hindFieldIndex++) {
            System.out.println("Field #" + (hindFieldIndex + 1));
            mineSweeper.getHintField(hindFieldIndex).displaySquares();
            System.out.println();
        }

    }
}


/*

4 5
*****
*****
*****
*...*
3 4
****
..**
*..*
10 10
*****.....
.....*****
....****..
****....**
*********.
.........*
.....*.*.*
*.*.*.....
.*.*.*.*..
**********
0 0

##Output
Field #1
*****
*****
*****
*434*

Field #2
****
35**
*23*

Field #3
*****33332
23345*****
2333****64
****6666**
*********4
233344545*
12122*2*3*
*3*3*34231
4*6*6*5*42
**********


 */

