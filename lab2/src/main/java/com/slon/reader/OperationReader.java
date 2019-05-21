package com.slon.reader;

import com.slon.math.MathOperator;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class OperationReader extends InputReader<MathOperator> {

    private final Map<String, MathOperator> operatorMap = ImmutableMap.<String, MathOperator>builder()
            .put("+", MathOperator.ADDITION)
            .put("-", MathOperator.SUBTRACTION)
            .put("/", MathOperator.DIVISION)
            .put("*", MathOperator.MULTIPLICATION)
            .build();

    OperationReader(ConsoleInputReader consoleInputReader, RetryReader retryReader) {
        super(consoleInputReader, retryReader);
    }

    @Override
    String getPossibleValues() {
        return Joiner.on(", ").join(operatorMap.keySet());
    }

    @Override
    MathOperator readInput(String userInput) {
        return Optional.ofNullable(operatorMap.get(userInput)).orElseThrow(IllegalArgumentException::new);
    }
}
