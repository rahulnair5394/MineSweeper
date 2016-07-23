package com.bitwise.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahuln on 7/21/2016.
 */
public class MineSweeper {


    private List<Field> mineFields = new ArrayList<>();
    private List<Field> hintFields = new ArrayList<>();
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
        if (mineFields.get(i) == null)
            return false;
        else return true;
    }

    public boolean isHintFieldEmpty() {
        return hintFields.isEmpty();
    }

    public boolean hasHintField(int i) {
        if (hintFields.get(i) == null)
            return true;
        else return false;
    }

    public class InputFormatViolationException extends RuntimeException {
    }


}
