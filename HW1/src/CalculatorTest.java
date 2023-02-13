import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {
        // positive tests
        assertThat(Calculator.calculatingDiscount(1, 10)).isEqualTo(0.9);
        assertThat(Calculator.calculatingDiscount(100, 0)).isEqualTo(100);
        assertThat(Calculator.calculatingDiscount(100, 1)).isEqualTo(99);
        assertThat(Calculator.calculatingDiscount(1000, 50)).isEqualTo(500);
        assertThat(Calculator.calculatingDiscount(1000, 99)).isEqualTo(10);
        assertThat(Calculator.calculatingDiscount(100, 100)).isEqualTo(0);

        //negative tests
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-1, 10))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(0, 10))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(1, -1))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(101, 101))
                .isInstanceOf(ArithmeticException.class);
    }
}