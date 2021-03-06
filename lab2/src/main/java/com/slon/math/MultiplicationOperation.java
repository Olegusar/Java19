package com.slon.math;

import org.springframework.stereotype.Service;

@Service
public class MultiplicationOperation implements MathOperation {

    public double operate(double leftArgument, double rightArgument) {
        return leftArgument * rightArgument;
    }
}
