import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByN {
    OffByN offByN = new OffByN(1);

    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'b'));
        assertTrue(offByN.equalChars('b', 'c'));
        assertFalse(offByN.equalChars('b', 'e'));
        assertFalse(offByN.equalChars('z', 'a'));

    }
}
