class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < num.length(); i++)
        {
            char digit = num.charAt(i);
            while (k > 0 && stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > digit) 
                   {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }
        while (k > 0)
        {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        int i = 0;
        while (i < stack.length() && stack.charAt(i) == '0')
        {
            i++;
        }
        String result = stack.substring(i);
        return result.length() == 0 ? "0" : result;
    }
}
