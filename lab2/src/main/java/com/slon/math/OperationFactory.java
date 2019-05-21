package com.slon.math;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class OperationFactory {

    private final ImmutableMap<MathOperator, Class<? extends MathOperation>> operationsMap =
            ImmutableMap.<MathOperator, Class<? extends MathOperation>>builder()
                    .put(MathOperator.ADDITION, AdditionOperation.class)
                    .put(MathOperator.SUBTRACTION, SubstrationOperation.class)
                    .put(MathOperator.DIVISION, DivisionOperation.class)
                    .put(MathOperator.MULTIPLICATION, MultiplicationOperation.class)
                    .build();

    private final ApplicationContext applicationContext;

    @Autowired
    public OperationFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public MathOperation getMathOperation(MathOperator mathOperator) {
        final Class<? extends MathOperation> operationClass = operationsMap.get(mathOperator);

        if (Objects.isNull(operationClass)) {
            throw new RuntimeException(String.format("There is no operation for '%s' operator", mathOperator));
        }

        return applicationContext.getBean(operationClass);
    }
}
