package BinarySearch;

public class SquareRootEstimation {
    public static int sqrt(int n){
        if(n == 0) return 0;
        int left = 1;
        int right = n;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(mid == n/mid) return mid;
            else if(mid > n/mid){
                ans = mid;
                right = mid - 1; // search in the left half
            } else {
                left = mid + 1; // search in the right half
            }
        }

        return ans - 1; //return the floor value because ans is the first number whose square is greater than n
    }
}
