package solutions;

import org.junit.Assert;
import org.junit.Test;

public class Task2Test {
    @Test
    public void positiveInt() {
	String value = "987123";
        int actual = Task2.convertInt(value);
        int expected = Integer.parseInt(value);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void negativeInt() {
        String value = "-987203";
        int actual = Task2.convertInt(value);
        int expected = Integer.parseInt(value);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void NegativeCaseLetter() {
        try {
            int actual = Task2.convertInt("a");
            } catch (Exception  e) {
            Assert.assertFalse(false);
        }
    }
    
    @Test
    public void positiveDoubleTwoAroundDot() {
	    String value = "2.202";
	    double actual = Task2.convertDouble(value);
	    double expected = Double.parseDouble(value);
	    Assert.assertEquals(expected, actual, 1);
    }
    

    @Test
    public void positiveDoubleOneAroundDotRight() {
	    String value = "0.202";
	    double actual = Task2.convertDouble(value);
	    double expected = Double.parseDouble(value);
	    Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void positiveDoubleOneAroundDotLeft() {
	    String value = "2.002";
	    double actual = Task2.convertDouble(value);
	    double expected = Double.parseDouble(value);
	    Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void positiveDoubleTheroAroundDot() {
	    String value = "0.002";
	    double actual = Task2.convertDouble(value);
	    double expected = Double.parseDouble(value);
	    Assert.assertEquals(expected, actual, 1);
    }
}
