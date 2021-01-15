package test1;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int[] nums = {3, 3, 4};
        int[] n = new Solution().twoSum(nums, 6);
        for (int i : n) {
            System.out.print(i + " ");
        }
    }
}

// 暴力解法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        // 遍历
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    if (!list.contains(i))
                        list.add(i);
                    if (!list.contains(j))
                        list.add(j);
                }
            }
        }
        // List<Integer> 转 int[]
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        // 返回结果
        return arr;
    }
}