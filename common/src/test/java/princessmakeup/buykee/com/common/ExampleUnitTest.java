package buykee.com.common;

import org.junit.Test;

import java.util.Stack;

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
    public void testStack() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.add(2);
        stack.add(3);
        Print.print(stack);

        int position1 = stack.search(3);
        Print.print(position1);

        int i = stack.peek();
        Print.print(i);

        Integer[] arrays = new Integer[stack.size()];
        stack.copyInto(arrays);
        arrays[0] = 10;
        Print.print(arrays);
        Print.print(stack);

    }
}