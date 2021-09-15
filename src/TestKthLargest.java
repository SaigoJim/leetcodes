import org.junit.Test;

import static org.junit.Assert.*;
public class TestKthLargest {
    @Test
    public void testKthLargest() {
        KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertEquals(4, k.add(3));
    }
}
