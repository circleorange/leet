import java.util.Arrays;

public class rmElem {
    /*
     * Given integer array and an integer, remove all of its occurrences in-place.
     * The order of elements may be changed.
     * Return number of elements in the array which are not equal to the integer.
     * 
     * Change the array such that the first k elements of array contain elements which
     * are not equal to the integer. 
     * Remaining elements are not important as well as the size of array.
     * 
     * Return k.
     * 
     * Examples:
     * 
     * Input:   nums = [3,2,2,3], val = 3
     * Output:  2, nums = [2,2,_,_]
     * Explanation: Function should return 2 with the first two elements being 2
     */

    public void run() {
        var nums   = new int[]{5,6,6,7,8,0,0,1,1,1,2,2,3,3,4,1,1};
        var val    = 1;
        int k      = removeElement(nums, val);
        print("Updated array: "+Arrays.toString(nums)+" with non-matching count of "+k);
        print("------------------");

        nums   = new int[]{3,2,2,3};
        val    = 3;
        k      = removeElement(nums, val);
        print("Updated array: "+Arrays.toString(nums)+" with non-matching count of "+k);
        print("------------------");

        nums   = new int[]{0,1,2,2,3,0,4,2};
        val    = 2;
        k      = removeElement(nums, val);
        print("Updated array: "+Arrays.toString(nums)+" with non-matching count of "+k);
        print("------------------");

        nums   = new int[]{0,1,2,2,3,0,4,2};
        val    = 5;
        k      = removeElement(nums, val);
        print("Updated array: "+Arrays.toString(nums)+" with non-matching count of "+k);
        print("------------------");

        nums   = new int[]{2};
        val    = 2;
        k      = removeElement(nums, val);
        print("Updated array: "+Arrays.toString(nums)+" with non-matching count of "+k);
        print("------------------");

        nums   = new int[]{1};
        val    = 2;
        k      = removeElement(nums, val);
        print("Updated array: "+Arrays.toString(nums)+" with non-matching count of "+k);
        print("------------------");

        nums   = new int[]{};
        val    = 2;
        k      = removeElement(nums, val);
        print("Updated array: "+Arrays.toString(nums)+" with non-matching count of "+k);
        print("------------------");

        nums   = new int[]{3,3};
        val    = 3;
        k      = removeElement(nums, val);
        print("Updated array: "+Arrays.toString(nums)+" with non-matching count of "+k);
        print("------------------");
    }

    public int removeElement(int[] nums, int val) {
        /*
         * Plan: Iterate over array, when match found, replace it with element in the back.
         */
        var pos     = 0;
        var slot    = nums.length;

        if (slot == 1 && nums[slot-1] == val)   return 0;
        //if (slot == 1 && nums[slot] == val)                     return 1;
        
        for (int i=0; i<slot; i++) {
            print("Starting at index "+i+": "+nums[i]+" with slot at "+slot);
            if (nums[i] == val) {
                print("Found matching element at index "+i);
                /*
                 * Find suitable slot at the end of the array to swap elements
                 */
                for (int j=slot-1; j>i; j--) {
                    print("Comparing element "+j+": "+nums[j]+" to input "+val+" for swap with slot "+slot);
                    if (nums[j] == val) {
                        slot--;
                        continue;
                    }
                    nums[i] = nums[j];
                    nums[j] = val;
                    pos++;
                    slot--;
                    print("Found suitable slot, updating slot to "+slot);
                    break;
                }
            } else {
                pos++;
            }
        }
        print("Position of slot "+slot);
        return pos;
    }

    public void print(Object obj) {
        System.out.println(obj);
    }
}
