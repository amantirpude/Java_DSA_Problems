//Find First Repeated Character(GeeksForGeeks)
//Given a string S. The task is to find the first repeated character in it. 
//We need to find the character that occurs more than once and whose index of 
//second occurrence is smallest. S contains only lowercase letters. We should not use any
//data structure.
//Time Complexity = O(n)
//Space Complexity = O(1)

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String firstRepChar(String s) 
    { 
        String ans = "";
        int mask = 0;
        
        for(int i =0; i<s.length(); i++){
            int curr = s.charAt(i) - 'a';
            
            
            if((mask & (1<<curr)) > 0){
                return String.valueOf(s.charAt(i));
            }
            else{
                mask = (mask | (1<<curr));
            }
        }
        return "-1";
    }
} 
