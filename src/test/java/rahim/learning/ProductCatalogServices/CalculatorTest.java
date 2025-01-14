package rahim.learning.ProductCatalogServices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    public void test_addition_of_two_numbers_return_expected_answer() {
        //Arrange
        Calculator calculator = new Calculator();
        //Act
        int answer = calculator.add(10,20);
        //Assert
        assert(answer == 30);
    }

    @Test
    public void test_DivideByZero_throws_arithmetic_exception() {
        //Arrange
        Calculator calculator = new Calculator();
        //Act and Assert
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1,0);
        });
    }
}