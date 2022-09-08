//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of
//candidates where the chosen numbers sum to target. You may return the combinations in any order.The same number may be chosen 
//from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers 
//is different.It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

class Solution {
    
    List<List<Integer>> allCombinations;
    List<Integer> currentCombination;
    int[] arr;
    int N;
    public void recur(int target, int index){
        
        //If target == 0 add it in  the final result as we found out the valid combination
        if(target == 0)
        {
            
            //we add the currentCombination into allCombination which are valid
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }
        
        // All elements to the right of index(including that index)
        //These are all possible options that are availablr for the target
        for(int i = index; i<N; i++)
        {
            if(target >= arr[i])
            {
                //we will include ith element in currentCombination 
                currentCombination.add(arr[i]);
                
                recur(target - arr[i], i);
                
                //we need to remove the last inserted element
                currentCombination.remove(currentCombination.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        allCombinations = new ArrayList<>();
        currentCombination = new ArrayList<>();
        
        int n = candidates.length;
        N = n;
        arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = candidates[i];
        }
        recur(target,0);
        
        return allCombinations;
    }
}
