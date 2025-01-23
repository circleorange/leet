import java.util.LinkedHashSet;

public class rmDup {
    /*
     * Given an integer array nums sorted in non-decreasing order, 
     * remove the duplicates in-place such that each unique element appears only once. 
     * The relative order of the elements should be kept the same. 
     * Then return the number of unique elements in nums.
     * 
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * 
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * 
     */
    public void run () {
        var nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates2(nums);
        print(k);

        var nums2 = new int[]{1,1,3};
        int h = removeDuplicates2(nums2);
        print(h);

        var nums3 = new int[]{1,1,2,2};
        int j = removeDuplicates2(nums3);
        print(j);

        var n4 = new int[]{-3,-1,0,0,0,3,3};
        int b = removeDuplicates2(n4);
        print(b);
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        var ans = new LinkedHashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
        }
        print(ans.toString());
        int j = 0;
        for (int n : ans) {
            nums[j] = n;
            j++;
        }
        return ans.size();
    }

    public int removeDuplicates (int[] nums) {
        var toAdd = 0;
        var toRemove = 0;

        if (nums.length == 1) {
            return 1;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            var curr = nums[i];
            var next = nums[i+1];

            if (curr == next || curr > next) {
                // condition to not include in the final result
                toRemove++;
                continue;
            }
            nums[toAdd] = curr;
            toAdd++;
        }
        var last = nums[nums.length-1];
        var secondLast = nums[nums.length-2];

        if (last > secondLast) {
            nums[toAdd] = last;
        }
        for (int num : nums) {
            System.out.println("Num: " + num);
        }
        return nums.length - toRemove;
    }

    public void print(Object obj) {
        System.out.println(obj);
    }
}
