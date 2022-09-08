// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

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
        
        //skip the ith element
        
        helper(nums, i+1,subSet,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        
        helper(nums, 0, subSet, ans);
        return ans;
    }
}
