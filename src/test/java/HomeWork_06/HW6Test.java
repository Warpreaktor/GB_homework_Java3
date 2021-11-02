package HomeWork_06;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HW6Test {
    @Test
    public void testCheckOneOrFour1() {
        HW6 hw6 = new HW6();
        int[] arr = {6, 2, 32, 3, 1, 48, 8, 187};
        Assert.assertTrue(hw6.checkOneOrFour(arr));
    }
    @Test
    public void testCheckOneOrFour2() {
        HW6 hw6 = new HW6();
        int[] arr = {166, 2, 3, 36, 0, 8, 28, 23};
        Assert.assertFalse(hw6.checkOneOrFour(arr));
    }
    @Test
    public void testCheckOneOrFour3() {
        HW6 hw6 = new HW6();
        int[] arr = {79, 4, 3, 31, 0, 8, 8, 11};
        Assert.assertTrue(hw6.checkOneOrFour(arr));
    }
    @Test
    public void testCheckOneOrFour4() {
        HW6 hw6 = new HW6();
        int[] arr = {45, 5, 3, 4, 0, 83, 1, 98};
        Assert.assertTrue(hw6.checkOneOrFour(arr));
    }
}