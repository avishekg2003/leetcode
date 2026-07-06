class Solution {
    public int hammingWeight(int n) {
        int r,c=0;
        while(n!=0)
        {
            r=n%2;
            if(r==1)
            {
                c++;
            }
            n=n/2;
        }
        return c;

        
    }
}