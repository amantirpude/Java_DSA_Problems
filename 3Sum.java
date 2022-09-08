//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        // we will sort the array
        Arrays.sort(arr);
        
        List<List<Integer>> answer = new ArrayList<>();
        
        int n = arr.length;
        
        // we will fix the element and try to find the other elements such that there sum is -fixed Element.
        int i = 0;
        while(i<n){
            int target = -arr[i]; //-fixedElement
            int start = i+1;
            int end = n-1;
            while(start < end){
                int currSum = arr[start] + arr[end];
                if(currSum == target){
                    List<Integer> currentPair = new ArrayList<>();
                    
                    currentPair.add(arr[i]);
                    currentPair.add(arr[start]);
                    currentPair.add(arr[end]);
                    
                    answer.add(currentPair);
                    
                    // move start and end until we didn't get different value from the previous one.
                    
                    int oldStartValue = arr[start];
                    int oldEndValue = arr[end];
                    start++;
                    end--;
                    
                    while(start < end && arr[start] == oldStartValue) start++;
                    while(start < end && arr[end] == oldEndValue) end--;

                }
                else if(currSum > target) end--;
                else start++;
            }
            // move the fixed elemwnt until it also becomes different.
            int oldFixedValue = arr[i];
            while(i < n && arr[i] == oldFixedValue) i++;
        }
        return answer;
    }
}
