package com.slon.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class InputReader<R> {

    private final ConsoleInputReader consoleInputReader;
    private final RetryReader retryReader;

    @Autowired
    protected InputReader(ConsoleInputReader consoleInputReader, RetryReader retryReader) {
        this.consoleInputReader = consoleInputReader;
        this.retryReader = retryReader;
    }

    public R read() {
        boolean requestRetry = true;

        while (requestRetry) {
            try {
                final String userInput = consoleInputReader.read();
                return readInput(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("Invalid input. Possible values are: %s", getPossibleValues()));
                requestRetry = retryReader.isRetryRequired();
            }
        }

        throw new IllegalArgumentException("User didn't enter necessary input.");
    }

    abstract String getPossibleValues();

    abstract R readInput(String userInput) throws IllegalArgumentException;
}
