class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            int count=0;
            for(int j=i;j<s.length();j++){
                int k;
            for(k=i;k<j;k++){
                if (s.charAt(k)==s.charAt(j)){
                    break;
                }
            }
            if(k!=j){
                break;
            }
            count++;
        }
        if(count>max){
            max=count;
        }
    }
    return max;
}
}