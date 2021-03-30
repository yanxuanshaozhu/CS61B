import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlikTest {

    @Test
    public void testMethod() {
        int a = 127;
        int b = 127;
        int c = 128;
        int d = 128;
        Integer e = Integer.valueOf(127);
        Integer f = Integer.valueOf(127);
        Integer g = Integer.valueOf(128);
        Integer h = Integer.valueOf(128);

        assertTrue(a == b);
        assertTrue(c == d);

        // Something related to the Java Constant Pool, you can Google it
        assertTrue(e == f);
        assertFalse(g == h);
    }
}
