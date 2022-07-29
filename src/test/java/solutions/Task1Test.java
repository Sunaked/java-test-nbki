package solutions;

import org.junit.Assert;
import org.junit.Test;

public class Task1Test {
    @Test
    public void Sentence() {
        String actualReplace = Task1.replace("Hello my name is Huan Hablo", 'H', 'B');
        String expectedReplace = "Bello my name is Buan Bablo";
        Assert.assertEquals(expectedReplace, actualReplace);
    }

    @Test
    public void emptySentence() {
        String actualReplace = Task1.replace("", 'a', 'b');
        String expectedReplace = "";
        Assert.assertEquals(expectedReplace, actualReplace);
    }

    @Test
    public void emptyReplaceSymbol() {
        String actualReplace = Task1.replace("Hello my name is Huan Hablo", ' ', 'b');
        String expectedReplace = "HellobmybnamebisbHuanbHablo";
        Assert.assertEquals(expectedReplace, actualReplace);
    }

    @Test
    public void emptyReplaceForSymbol() {
        String actualReplace = Task1.replace("Hello my name is Huan Hablo", 'H', ' ');
        String expectedReplace = " ello my name is  uan  ablo";
        Assert.assertEquals(expectedReplace, actualReplace);
    }

    @Test
    public void Number() {
        String actualReplace = Task1.replace("123 123 123 123", '3', '1');
        String expectedReplace = "121 121 121 121";
        Assert.assertEquals(expectedReplace, actualReplace);
    }
}
