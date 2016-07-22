package com.bitwise.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahuln on 7/21/2016.
 */
public class MineSweeper {


    private List<Field> mineFields = new ArrayList<>();
    private List<Field> hintFields = new ArrayList<>();

    public void addField(String initiator) {
        validate(initiator);
        String []rowCol=initiator.trim().split("[\\s]+");
        mineFields.add(new MineField(rowCol[0],rowCol[1]));
    }

    private void validate(String initiator) {
        validatePattern(initiator);

    }

    private void validatePattern(String initiator) {
        if (!initiator.matches("[ ]*[0-9]+[ ]+[0-9]+[ ]*"))
            throw new InputFormatViolationException();

    }

    public boolean isMineFieldEmpty() {
        return mineFields.isEmpty();
    }

    public boolean hasField(int i){
                if(mineFields.get(i)==null)
                    return true;
                else return false;
    }
    public boolean isHintFieldEmpty() {
        return hintFields.isEmpty();
    }

    public Field getField(int i) {
        return mineFields.get(i);
    }

    public class InputFormatViolationException extends RuntimeException {
    }

    public class FieldNotFoundException extends RuntimeException {
    }
}
