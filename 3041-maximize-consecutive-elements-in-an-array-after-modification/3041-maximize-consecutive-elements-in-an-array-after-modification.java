class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int x : nums)
        {
            int best = dp.getOrDefault(x, 0) + 1;
            int best2 = dp.getOrDefault(x + 1, 0) + 1;
            dp.put(x + 1, Math.max(dp.getOrDefault(x + 1, 0), best));
            dp.put(x + 2, Math.max(dp.getOrDefault(x + 2, 0), best2));
            ans = Math.max(ans, Math.max(dp.get(x + 1), dp.get(x + 2)));
        }
        return ans;
    }
}
