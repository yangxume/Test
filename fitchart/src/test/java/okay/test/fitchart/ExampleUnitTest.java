package okay.test.fitchart;

import org.junit.Test;

import static org.junit.Assert.*;

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
    public void testGetValue(){

        float minValue = 0;
        float maxValue = 100;

        float max = Math.max(minValue, maxValue);

        float min = Math.min(minValue, maxValue);

        float temp = max - min;

        System.out.println("max:"+max);
        System.out.println("min:"+min);
        System.out.println("temp:"+temp);

    }
}