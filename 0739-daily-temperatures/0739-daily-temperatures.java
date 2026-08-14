class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[]answer=new int[n];
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()){
                if(temperatures[i]>temperatures[stack.peek()]){
                    int index=stack.pop();
                    answer[index]=i-index;
                }
                else{
                    break;
                }
            }
            stack.push(i);
        }
        return answer;
        
    }
}