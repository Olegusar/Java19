package com.barmin.math;

import com.google.common.math.BigIntegerMath;

public class MathLib {

    private MathLib() {
    }

    public static double pow(double number, double power) {
        return StrictMath.pow(number, power);
    }

    public static int factorial(int number) {
        return BigIntegerMath.factorial(number).intValue();
    }

    public static double log(double number, double base) {
        return (StrictMath.log(number) / StrictMath.log(base));
    }
}
