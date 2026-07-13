package Day4;
import java.util.Scanner;
public class Candy {
    public static int candy(int[] nums){
        int n = nums.length;
        int cnt = 0;
        int[] candies = new int[n];
        for(int i = 0; i < n; i++) candies[i] = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        for(int i = n - 1; i > 0; i--){
            if(nums[i - 1] > nums[i]){
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
            cnt += candies[i - 1];
        }
        return cnt + candies[n - 1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int ans = candy(nums);
        System.out.println(ans);
        System.out.println();
    }
}
