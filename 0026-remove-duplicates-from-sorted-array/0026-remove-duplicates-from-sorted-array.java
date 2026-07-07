class Solution {
    public int removeDuplicates(int[] nums) {
    int n= nums.length;
    int i=1;
    int j=0;
    while(i<n)
    {
        if(nums[i]==nums[i-1])
        {
            i++;
            continue;
        }
        nums [j+1]=nums[i];
        j++;
        i++;
    }
    return j+1;
        
    }
}