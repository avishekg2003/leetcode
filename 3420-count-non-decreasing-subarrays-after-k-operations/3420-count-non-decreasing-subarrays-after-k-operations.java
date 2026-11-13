class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int LOG = 18;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                next[i] = st.peek();
            }
            st.push(i);
        }
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[][] up = new int[LOG][n];
        long[][] sum = new long[LOG][n];
        for (int i = 0; i < n; i++) {
            up[0][i] = next[i];
            if (next[i] != -1) {
                sum[0][i] =
                    (long) nums[i] * (next[i] - i);
            }
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int mid = up[j - 1][i];
                if (mid != -1) {
                    up[j][i] = up[j - 1][mid];
                    if (up[j][i] != -1) {
                        sum[j][i] =
                            sum[j - 1][i] + sum[j - 1][mid];
                    } else {
                        up[j][i] = -1;
                    }

                } else {
                    up[j][i] = -1;
                }
            }
        }

        // Calculate cost of subarray [l, r]
        long ans = 0;

        for (int r = 0; r < n; r++) {

            int low = 0;
            int high = r;

            while (low < high) {

                int mid = low + (high - low) / 2;

                long maxSum = 0;
                int cur = mid;

                for (int j = LOG - 1; j >= 0; j--) {

                    int p = up[j][cur];

                    if (p != -1 && p <= r) {
                        maxSum += sum[j][cur];
                        cur = p;
                    }
                }

                maxSum += (long) nums[cur] * (r - cur + 1);

                long cost = maxSum -
                    (prefix[r + 1] - prefix[mid]);

                if (cost <= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            ans += r - low + 1;
        }

        return ans;
    }
}
