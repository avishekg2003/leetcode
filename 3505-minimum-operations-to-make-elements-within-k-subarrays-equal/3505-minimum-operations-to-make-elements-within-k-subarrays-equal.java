class Solution {
    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();
    long sumLow = 0;
    long sumHigh = 0;
    int sizeLow = 0;
    int sizeHigh = 0;
    void addLow(int num)
    {
        low.put(num, low.getOrDefault(num, 0) + 1);
        sumLow += num;
        sizeLow++;
    }
    void addHigh(int num)
    {
        high.put(num, high.getOrDefault(num, 0) + 1);
        sumHigh += num;
        sizeHigh++;
    }
    void removeLow(int num)
    {
        int count = low.get(num);
        if (count == 1)
            low.remove(num);
        else
            low.put(num, count - 1);
        sumLow -= num;
        sizeLow--;
    }
    void removeHigh(int num)
    {
        int count = high.get(num);
        if (count == 1)
            high.remove(num);
        else
            high.put(num, count - 1);
        sumHigh -= num;
        sizeHigh--;
    }
    void rebalance() 
    {
        while (sizeLow > sizeHigh + 1)
        {
            int num = low.lastKey();
            removeLow(num);
            addHigh(num);
        }
        while (sizeLow < sizeHigh)
        {
            int num = high.firstKey();
            removeHigh(num);
            addLow(num);
        }
    }
    void add(int num)
    {
        if (low.isEmpty() || num <= low.lastKey())
            addLow(num);
        else
            addHigh(num);

        rebalance();
    }
    void remove(int num)
    {
        if (low.containsKey(num))
            removeLow(num);
        else
            removeHigh(num);

        rebalance();
    }
    long getCost()
    {
        int median = low.lastKey();
        return (long) median * sizeLow - sumLow
             + sumHigh - (long) median * sizeHigh;
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        for (int i = 0; i < n; i++) {
            add(nums[i]);
            if (i >= x)
                remove(nums[i - x]);
            if (i >= x - 1)
                cost[i - x + 1] = getCost();
        }
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];
        for (int j = 1; j <= k; j++)
            Arrays.fill(dp[j], INF);
        for (int j = 0; j <= k; j++)
            dp[j][0] = (j == 0) ? 0 : INF;
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= x && dp[j - 1][i - x] != INF) {
                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }
        return dp[k][n];
    }
}