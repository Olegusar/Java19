package com.slon.reader;

import com.google.common.base.Objects;
import org.springframework.stereotype.Service;

@Service
public class RetryReader {

    private static final String YES_ANSWER = "Y";
    private static final String NO_ANSWER = "N";

    private final ConsoleInputReader consoleInputReader;

    public RetryReader(ConsoleInputReader consoleInputReader) {
        this.consoleInputReader = consoleInputReader;
    }

    public boolean isRetryRequired() {
        System.out.println(String.format("Do you want to retry input?[%s/%s]", YES_ANSWER, NO_ANSWER));

        boolean result = false;
        boolean requestRetry = true;
        while (requestRetry) {

            final String retryAnswer = consoleInputReader.read();
            if (Objects.equal(retryAnswer, YES_ANSWER)) {
                result = true;
                requestRetry = false;
                System.out.println("Please try once more: ");
            } else if (Objects.equal(retryAnswer, NO_ANSWER)) {
                requestRetry = false;
            } else {
                System.out.println(String.format("Possible options are: %s or %s. Please retry: ",
                        YES_ANSWER, NO_ANSWER));
            }
        }

        return result;
    }
}
