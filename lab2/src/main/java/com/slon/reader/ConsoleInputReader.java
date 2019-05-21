package com.slon.reader;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.google.common.base.Charsets.UTF_8;

@Service
class ConsoleInputReader {

    private final InputStream inputStream = new CloseShieldInputStream(System.in);

    String read(){
        final String result;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8))) {
            result = bufferedReader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}
