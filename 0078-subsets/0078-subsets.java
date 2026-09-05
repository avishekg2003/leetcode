class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>subset=new ArrayList<>();
        solve(0,nums,ans,subset);
        return ans;
        
    }
    public void solve(int i,int[]nums,List<List<Integer>>ans,List<Integer>subset){
        if(i==nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        solve(i+1,nums,ans,subset);
        subset.remove(subset.size()-1);
        solve(i+1,nums,ans,subset);
    }
}