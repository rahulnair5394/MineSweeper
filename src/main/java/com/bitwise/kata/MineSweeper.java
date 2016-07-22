package com.bitwise.kata;

/**
 * Created by rahuln on 7/21/2016.
 */
public class MineSweeper {

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

    public class InputFormatViolationException extends RuntimeException {
    }
}
