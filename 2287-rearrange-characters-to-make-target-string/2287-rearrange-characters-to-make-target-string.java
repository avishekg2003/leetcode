class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int count = freq[ch - 'a'];
            int copies = count;
            int required = 0;
            for (int j = 0; j < target.length(); j++) {
                if (target.charAt(j) == ch) {
                    required++;
                }
            }
            copies = count / required;
            ans = Math.min(ans, copies);
        }
        return ans;
    }
}
