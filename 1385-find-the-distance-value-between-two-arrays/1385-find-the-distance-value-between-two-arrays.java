import java.util.Arrays;
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int nums : arr1) {
            int low = 0;
            int high = arr2.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr2[mid] < nums) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            boolean valid = true;
            if (low < arr2.length &&
                Math.abs(arr2[low] - nums) <= d) {

                valid = false;
            }
            if (high >= 0 &&
                Math.abs(arr2[high] - nums) <= d) {
                valid = false;
            }
            if (valid) {
                count++;
            }
        }
        return count;
    }
}