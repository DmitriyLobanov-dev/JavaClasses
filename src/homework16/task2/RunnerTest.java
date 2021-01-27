package homework16.task2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RunnerTest {

    static String text;
    static List<String> listAllWords;
    static List<String> listWords;

    @BeforeClass
    public static void setUp() throws Exception {
        text = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking\n" +
                "up, what should he see but a Lamb just beginning to drink a little lower down.";
        listAllWords = new ArrayList<>(Arrays.asList(text.split(" ")));
        listWords = new ArrayList<>();
        Collections.sort(listAllWords);
    }

    @Test
    public void testGetWordsSameLetterStartsWith() {
        Assert.assertEquals("A: a at\n" +
                "B: beginning but\n" +
                "D: down drink\n" +
                "H: he hillside\n" +
                "J: just\n" +
                "L: lamb lapping little looking lower\n" +
                "O: on once\n" +
                "S: see should spring\n" +
                "T: time to\n" +
                "U: up upon\n" +
                "W: was what when wolf", Runner.getWordsSameLetterStartsWith(text));
    }
}
