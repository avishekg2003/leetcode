class Solution {
    public int characterReplacement(String s, int k) {
        int []freq= new int [26];
        int left=0;
        int maxFreq =0;
        int ans=0;
        for (int right =0;right<s.length();right++)
        {
            freq[s.charAt(right)-'A']++;
            maxFreq=0;
            for (int i=0;i<26;i++)
            {
            maxFreq=Math.max(maxFreq,freq[i]);
            }          
            
            while ((right-left+1)-maxFreq > k)
            {
                freq[s.charAt(left)-'A']--;
                left++;
                maxFreq=0;
            
            for(int i=0;i<26;i++)
            {
                maxFreq=Math.max(maxFreq,freq[i]);
            }
        }
        ans=Math.max(ans,right-left+1);

        }
        return ans;
}
}