package com.bitwise.kata;

import java.util.ArrayList;

/**
 * Created by rahuln on 7/21/2016.
 */
public class MineSweeper {


    ArrayList<Field> mineFields = new ArrayList<Field>();
    ArrayList<Field> hintFields = new ArrayList<Field>();

    public void getField(String initiator) {
        validate(initiator);

    }

    private void validate(String initiator) {
        validatePattern(initiator);

    }

    private void validatePattern(String initiator) {
        if (!initiator.matches("[ ]+[0-9]+[ ]+[0-9]+[ ]+"))
            throw new InputFormatViolationException();

    }

    public boolean isMineFieldEmpty() {
        return mineFields.isEmpty();
    }
    public boolean isHintFieldEmpty() {
        return hintFields.isEmpty();
    }

    public class InputFormatViolationException extends RuntimeException {
    }
}
