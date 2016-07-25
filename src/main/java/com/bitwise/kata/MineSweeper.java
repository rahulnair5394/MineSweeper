package com.bitwise.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
class MineSweeper {


    private final List<Field> mineFields = new ArrayList<>();
    private final List<Field> hintFields = new ArrayList<>();
    private final HintFieldCreator fieldCreator = new HintFieldCreator();

    boolean addMineField(String initiator) {
        validatePattern(initiator);
        String[] rowCol = initiator.trim().split("[\\s]+");
        if(checkRowCol(rowCol))
        mineFields.add(new MineField(Integer.parseInt(rowCol[0]), Integer.parseInt(rowCol[1])));
        return checkRowCol(rowCol);
    }

    private boolean checkRowCol(String[] rowCol) {
        return !(Integer.parseInt(rowCol[0]) > 100 || Integer.parseInt(rowCol[0]) < 1 || Integer.parseInt(rowCol[1]) > 100 || Integer.parseInt(rowCol[1]) < 1);
    }


    Field getMineField(int index) {
        return mineFields.get(index);
    }

    boolean addHintField(Field mineField) {
        if (mineField != null) {
            Field hintField = fieldCreator.makeHintField(mineField);
            return hintFields.add(hintField);
        }
        return false;
    }

    Field getHintField(int index) {
        return hintFields.get(index);
    }


    private void validatePattern(String initiator) {
        if(!initiator.matches("[ ]*[0-9]+[ ]+[0-9]+[ ]*"))
            throw new InputFormatViolationException();


    }

    boolean isMineFieldEmpty() {
        return mineFields.isEmpty();
    }

    boolean hasMineField(int i) {
        return mineFields.get(i) != null;
    }

    boolean isHintFieldEmpty() {
        return hintFields.isEmpty();
    }

    boolean hasHintField(int i) {
        return hintFields.get(i) != null;
    }

    class InputFormatViolationException extends RuntimeException {
    }



}
