class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }
        int[] newParent = new int[n];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] oldLast = new int[n];
        int[] stack = new int[2 * n];
        int top = 0;
        int[] order = new int[n];
        int idx = 0;
        stack[top++] = 0;
        while (top > 0) {
            int event = stack[--top];
            if (event < 0) {
                int node = ~event;
                int ch = s.charAt(node) - 'a';
                last[ch] = oldLast[node];
                continue;
            }
            int node = event;
            int ch = s.charAt(node) - 'a';
            oldLast[node] = last[ch];
            if (node == 0) {
                newParent[node] = -1;
            } else if (last[ch] != -1) {
                newParent[node] = last[ch];
            } else {
                newParent[node] = parent[node];
            }
            last[ch] = node;
            order[idx++] = node;
            stack[top++] = ~node;
            for (int child : tree[node]) {
                stack[top++] = child;
            }
        }
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            answer[newParent[node]] += answer[node];
        }
        return answer;
    }
}
