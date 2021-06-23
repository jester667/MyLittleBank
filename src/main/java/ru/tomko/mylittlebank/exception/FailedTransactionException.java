package ru.tomko.mylittlebank.exception;

public class FailedTransactionException extends Exception {
    public FailedTransactionException(String er) {
        super(er);
    }
}
