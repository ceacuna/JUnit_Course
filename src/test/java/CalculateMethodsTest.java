
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.Assert.assertEquals;

public class CalculateMethodsTest {
    private CalculateMethods calculateMethods;

    @BeforeEach
    public void initTest(){
        calculateMethods = new CalculateMethods();
    }
    @Test
    public void testDivide(){
        double result = calculateMethods.divide(100, 10);
        double expected = 10;
        assertEquals(expected, result, 0.001);
    }
    @Test
    public void testDivideByZero() {
        Assert.assertThrows(ArithmeticException.class, () -> calculateMethods.divide(100, 0));
    }
}
