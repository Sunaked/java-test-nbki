package solutions;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Task4Test {
    private final String BIG_CSV = "./src/test/bigCSV.csv";
    private final String SMALL_CSV = "./src/test/smallCSV.csv";

    @Test
    public void sortSmallCSV() {
        try {
            Task4.sortSmallCSV(SMALL_CSV);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            Assert.fail();
        }
    }

    @Test
    public void sortBigCSV() {
        try {
            Task4.sortCSVBig(BIG_CSV);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
}
