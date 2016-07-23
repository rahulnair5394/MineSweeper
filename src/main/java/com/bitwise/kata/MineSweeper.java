package com.bitwise.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul.nair@bitwiseglobal.com .
 */
class MineSweeper {


    private final List<Field> mineFields = new ArrayList<>();
    private final List<Field> hintFields = new ArrayList<>();
    HintFieldCreator fieldCreator = new HintFieldCreator();

    public void addMineField(String initiator) {
        validatePattern(initiator);
        String[] rowCol = initiator.trim().split("[\\s]+");
        mineFields.add(new MineField(Integer.parseInt(rowCol[0]), Integer.parseInt(rowCol[1])));
    }

    public Field getMineField(int i) {
        return mineFields.get(i);
    }


    private void validatePattern(String initiator) {
        if (!initiator.matches("[ ]*[0-9]+[ ]+[0-9]+[ ]*"))
            throw new InputFormatViolationException();

    }

    public boolean isMineFieldEmpty() {
        return mineFields.isEmpty();
    }

    public boolean hasMineField(int i) {
        return mineFields.get(i) != null;
    }

    public boolean isHintFieldEmpty() {
        return hintFields.isEmpty();
    }

    public boolean hasHintField(int i) {
        return hintFields.get(i) == null;
    }

    public class InputFormatViolationException extends RuntimeException {
    }


}
