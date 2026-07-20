package Day9;
import java.util.*;
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        // Arrays.sort(nums);
        // int n = nums.length;
        // if(n == 0) return 0;
        // int curr = 1;
        // int maxLen = 1;
        // for(int  i = 1; i < n; i++){
        //     if(nums[i] == nums[i - 1]) continue;
        //     if(nums[i] == nums[i - 1] + 1) {
        //         curr++;
        //     } else {
        //         maxLen = Math.max(maxLen, curr);
        //         curr = 1;
        //     }
        // }
        // return Math.max(maxLen, curr);
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int ans = 0;
        for(int x : set) {
            if(!set.contains(x - 1)) {
                int y = x + 1;
                while(set.contains(y)) y++;
                ans = Math.max(ans, y - x);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = longestConsecutive(nums);
        System.out.println(ans);
    }
}
