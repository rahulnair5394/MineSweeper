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
        checkRowCol(rowCol);
        return mineFields.add(new MineField(Integer.parseInt(rowCol[0]), Integer.parseInt(rowCol[1])));
    }

    private void checkRowCol(String[] rowCol) {
        if(Integer.parseInt(rowCol[0])>99||Integer.parseInt(rowCol[1])>99)
            throw new FieldLimitException();
    }


    Field getMineField(int i) {
        return mineFields.get(i);
    }

    boolean addHintField(Field mineField) {
        if (mineField != null) {
            Field hintField = fieldCreator.makeHintField(mineField);
            return hintFields.add(hintField);
        }
        return false;
    }

    Field getHintField(int i) {
        return hintFields.get(i);
    }


    private void validatePattern(String initiator) {
        if (!initiator.matches("[ ]*[0-9]+[ ]+[0-9]+[ ]*"))
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


    class FieldLimitException extends RuntimeException {
    }
}
