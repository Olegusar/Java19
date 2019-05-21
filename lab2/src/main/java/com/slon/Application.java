package com.slon;


import com.slon.math.MathOperator;
import com.slon.math.OperationFactory;
import com.slon.reader.NumberInputReader;
import com.slon.reader.OperationReader;
import com.slon.reader.RetryReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private Application() {
    }

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.slon");

        final OperationFactory operationFactory = applicationContext.getBean(OperationFactory.class);
        final OperationReader operationReader = applicationContext.getBean(OperationReader.class);
        final NumberInputReader numberInputReader = applicationContext.getBean(NumberInputReader.class);
        final RetryReader retryReader = applicationContext.getBean(RetryReader.class);

        try {
            boolean isUserSelectedExit = true;
            while (isUserSelectedExit){
                System.out.println("Enter the first number: ");
                final double leftArg = numberInputReader.read();
                System.out.println("Enter the second number: ");
                final double rightArg = numberInputReader.read();

                System.out.println("Enter the operation: ");
                final MathOperator mathOperator = operationReader.read();
                final double result = operationFactory.getMathOperation(mathOperator).operate(leftArg, rightArg);

                System.out.println(String.format("%.2f %s %.2f = %.2f",
                        leftArg, mathOperator.getValue(), rightArg, result));
                isUserSelectedExit = retryReader.isRetryRequired();
            }
        } catch (IllegalArgumentException ex){
            System.out.println("Shutting down...");
        }

    }
}
