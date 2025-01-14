package io.guara.cleancode.exercises.calculator;

import java.util.ArrayList;
import java.util.List;

import io.guara.cleancode.exercises.expressions.parser.Expression;
import io.guara.cleancode.exercises.expressions.parser.ExpressionParser;
import io.guara.cleancode.exercises.expressions.parser.Operations;

public class Calculator {

    List<String> history = new ArrayList<>();

    /**
     * Calculate the expression.
     */
    public Double calculate(String expression) {

        Expression parsed = ExpressionParser.parse(expression);

        Operations o = parsed.nextOperation(); // the math operation
        Double n1 = parsed.nextOperand(); // the first operand
        Double n2 = parsed.nextOperand(); // the second operand

        throw new RuntimeException("Not implemented");
    }

    /**
     * Return the history of operations performed.
     * The format of the history is "10.0 + 5.0 = 15.0"
     */
    public List<String> getHistory() {
        return this.history;
    }
    
}
