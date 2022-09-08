// 90. Subsets ll(leetcode)

//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

//The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    
    public static void helper(int[] nums, int i, List<Integer> subSet, List<List<Integer>> ans){
        
        // base condition
        if(i == nums.length){
            ans.add(new ArrayList(subSet));
            return;
        }
        
        // pick the ith element
        subSet.add(nums[i]);
        helper(nums,i+1,subSet,ans);
        
        
        // backtrack and undo the changes that have been made
        subSet.remove(subSet.size() - 1);
        
        //Check if the current element is not same as the previous element
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        
        helper(nums, i+1,subSet,ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, subSet, ans);
        return ans;
    }
}
