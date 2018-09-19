package com.louise.base;

import com.louise.base.utils.TimeIntervalUtils;

import org.junit.Test;

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
    public void testTimeInterval() throws InterruptedException {
        TimeIntervalUtils.addStartTime("1");
        Thread.sleep(1000);
        long interval = TimeIntervalUtils.getTimeInterval("1");
        System.out.println(interval);
    }
}