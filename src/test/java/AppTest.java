import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    @Test
    public void test() {

        RuntimeException rtE = null;
        String str;

        str = "AAAA1111";
        try {
            App.rtl(str);
        } catch (Exception e) {
            rtE = (RuntimeException) e;
        } finally {
            assertNotNull(rtE);
            assertEquals(rtE.getMessage(), "Wrong format");
        }

        rtE = null;
        str = "";
        try {
            App.rtl(str);
        } catch (Exception e) {
            rtE = (RuntimeException) e;
        } finally {
            assertNotNull(rtE);
            assertEquals(rtE.getMessage(), "Wrong format");
        }

        rtE = null;
        str = " ";
        try {
            App.rtl(str);
        } catch (Exception e) {
            rtE = (RuntimeException) e;
        } finally {
            assertNotNull(rtE);
            assertEquals(rtE.getMessage(), "Wrong format");
        }

        str = "A";
        assertEquals("A", App.rtl(str));

        str = "AAAA";
        assertEquals("A4", App.rtl(str));

        str = "AAAABBBCCX";
        assertEquals("A4B3C2X", App.rtl(str));

        str = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBB";
        assertEquals("A4B3C2XYZD4E3F3A6B10", App.rtl(str));

        str = "XYZ";
        assertEquals("XYZ", App.rtl(str));
    }
}
