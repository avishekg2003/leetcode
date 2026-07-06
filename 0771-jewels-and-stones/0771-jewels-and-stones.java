class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int i,j;
        int c=0;
        int a= jewels.length();
        int b= stones.length();
        for(i=0;i<a;i++){
            for(j=0;j<b;j++){
                if(jewels.charAt(i)==stones.charAt(j))
                {
                    c++;
                }
            }
        }
        return c;
        
        
    }
}