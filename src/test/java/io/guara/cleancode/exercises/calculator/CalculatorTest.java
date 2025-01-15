package io.guara.cleancode.exercises.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void OnePlusOneShouldResultInTwo() {
        Double result = new Calculator().calculate("1 + 1");
        assertEquals(2D, result);
    }

    @Test
    void TenMinusOneShouldResultInNine() {
        Double result = new Calculator().calculate("10 - 1");
        assertEquals(9D, result);
    }

    @Test
    void FiveTimesFourShouldResultInTwenty() {
        Double result = new Calculator().calculate("5 * 4");
        assertEquals(20D, result);
    }

    @Test
    void EightyDivededByTenShouldResultInEight() {
        Double result = new Calculator().calculate("80 / 10");
        assertEquals(8D, result);
    }

    @Test
    void DivisionByZeroShouldResultInError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().calculate("10 / 0");
        });
    }

    @Test
    void anyNullNumberShouldResultInError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().calculate("1 + ");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().calculate(" + 1");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().calculate(" + ");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().calculate("1 - ");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().calculate("1 / ");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().calculate("1 * ");
        });
    }

    @Test
    void invalidOperationShouldResultInError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Calculator().calculate("1 ? 1");
        });
    }

    @Test
    void mustAddOperatinInHistory() {
        Calculator calculator = new Calculator();
        calculator.calculate("1 + 1");
        calculator.calculate("10 / 5");
        assertEquals("1 + 1 = 2", calculator.getHistory().get(0));
        assertEquals("10 / 5 = 2", calculator.getHistory().get(1));
    }

}
