class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] current : intervals) {
            if (list.isEmpty() || current[0] > list.get(list.size() - 1)[1]) {
                list.add(current);
            } else {
                int[] last = list.get(list.size() - 1);
                last[1] = Math.max(last[1], current[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}