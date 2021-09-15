import org.junit.Test;
import static org.junit.Assert.*;

public class ProductExceptSelf {
    // Dual Pointer variant
    public int[] productExceptSelf(int[] nums) {
        int[] returnedArr = new int[nums.length];
        for (int i = 0; i < returnedArr.length; i += 1) {
            returnedArr[i] = 1;
        }
        // Each product except self is leftProduct * rightProduct
        int leftProduct = 1, rightProduct = 1;
        // It seems it's just iterating once, actually it accesses each member twice
        for (int i = 0; i < returnedArr.length; i += 1) {
            returnedArr[i] *= leftProduct;
            returnedArr[returnedArr.length - i - 1] *= rightProduct;
            leftProduct *= nums[i];
            rightProduct *= nums[nums.length - i - 1];
        }
        return returnedArr;
    }
    @Test
    public void testProductExceptSelf() {
        int[] arr1 = new int[]{1,2,3,4};
        int[] expected = new int[]{24,12,8,6};
        assertArrayEquals(expected, productExceptSelf(arr1));
    }
}
