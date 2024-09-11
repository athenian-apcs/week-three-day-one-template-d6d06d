import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MyTests {

    private MyMain myMain;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        myMain = new MyMain();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDivisibleByFour() {
        assertTrue(myMain.divisibleByFour(8), "8 should be divisible by 4");
        assertTrue(myMain.divisibleByFour(12), "12 should be divisible by 4");
        assertFalse(myMain.divisibleByFour(10), "10 should not be divisible by 4");
        assertFalse(myMain.divisibleByFour(15), "15 should not be divisible by 4");
        assertTrue(myMain.divisibleByFour(0), "0 should be divisible by 4");
        assertTrue(myMain.divisibleByFour(-16), "-16 should be divisible by 4");
    }

    @Test
    public void testPrintNumsUpTo() {
        myMain.printNumsUpTo(10);
        String expected = "1 2 3 4 5\n6 7 8 9 10\n";
        assertEquals(expected.strip(), outContent.toString().strip());

        outContent.reset();
        myMain.printNumsUpTo(7);
        expected = "1 2 3 4 5\n6 7 ";
        assertEquals(expected.strip(), outContent.toString().strip());

        outContent.reset();
        myMain.printNumsUpTo(3);
        expected = "1 2 3 ";
        assertEquals(expected.strip(), outContent.toString().strip());
    }

    @Test
    public void testSumDigits() {
        assertEquals(6, myMain.sumDigits(123), "Sum of digits of 123 should be 6");
        assertEquals(10, myMain.sumDigits(1234), "Sum of digits of 1234 should be 10");
        assertEquals(1, myMain.sumDigits(1000), "Sum of digits of 1000 should be 1");
        assertEquals(0, myMain.sumDigits(0), "Sum of digits of 0 should be 0");
        assertEquals(9, myMain.sumDigits(900), "Sum of digits of 900 should be 9");
    }

    @Test
    public void testIsSelfDivisor() {
        assertTrue(myMain.isSelfDivisor(128), "128 should be a self divisor");
        assertFalse(myMain.isSelfDivisor(26), "26 should not be a self divisor");
        assertFalse(myMain.isSelfDivisor(13), "13 should not be a self divisor");
        assertTrue(myMain.isSelfDivisor(11), "11 should be a self divisor");
    }
}

