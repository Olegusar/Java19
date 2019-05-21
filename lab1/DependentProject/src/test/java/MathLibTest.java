import com.slon.math.MathLib;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathLibTest {

    @Test
    void shouldRaiseNumbersToPower() {
        assertEquals(4, MathLib.pow(2, 2));
        assertEquals(8, MathLib.pow(2, 3));
        assertEquals(5, MathLib.pow(5, 1));
        assertEquals(1, MathLib.pow(5, 0));
        assertEquals(1, MathLib.pow(1, 1));
    }

    @Test
    void shouldCalculateFactorialOfNumber() {
        assertEquals(6, MathLib.factorial(3));
    }

    @Test
    void shouldCalculateLogarithm() {
        assertEquals(2, MathLib.log(4, 2));

        final int number = 4;
        final int power = 2;
        final double result = MathLib.pow(number, power);
        assertEquals(power, MathLib.log(result, number));
    }
}