package com.slon.reader;

import org.springframework.stereotype.Service;

@Service
public class NumberInputReader extends InputReader<Double> {

    public NumberInputReader(ConsoleInputReader consoleInputReader, RetryReader retryReader) {
        super(consoleInputReader, retryReader);
    }

    @Override
    String getPossibleValues() {
        return "any number. Decimal number should be split via '.'";
    }

    @Override
    Double readInput(String userInput) throws IllegalArgumentException {
        return Double.parseDouble(userInput);
    }
}
