package Day3;

import java.io.*;
import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k){
        int n = nums.length;
        long[] prefix = new long[n+1];
        for(int i = 0; i < n; i++){
            prefix[i+1] = prefix[i] + (long) nums[i];
        }
        int minLength = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int j = 0; j <= n; j++){
            while(!deque.isEmpty() && prefix[j] - prefix[deque.peekFirst()] >= k){
                minLength = Math.min(minLength, j - deque.pollFirst());
            }
            while(!deque.isEmpty() && prefix[j] <= prefix[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(j);
        }
        return minLength <= n ? minLength : -1;
    }
}
public class ShortestSubarray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] first = br.readLine().trim().split("\\s+");
        
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);
        int[] nums = new int[n];
        String[] parts = br.readLine().trim().split("\\s+");
        for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(parts[i]);
        Solution sol = new Solution();
        int ans = sol.shortestSubarray(nums, k);
        System.out.println(ans);
        System.out.flush();
    }
}

