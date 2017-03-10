package princessmakeup.buykee.com.beauty;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void t_Add() throws Exception {
        List<String> tempList = new ArrayList<>();
        tempList.add("1");
        tempList.add("1");
        tempList.add("1");

        tempList.add(1, "0");

        System.out.print(tempList.toString());
    }

}