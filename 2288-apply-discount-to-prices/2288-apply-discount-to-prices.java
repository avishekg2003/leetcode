class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            if (word.charAt(0) == '$' && word.length() > 1) {
                boolean valid = true;
                for (int i = 1; i < word.length(); i++) {
                    if (!Character.isDigit(word.charAt(i))) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    long price = Long.parseLong(word.substring(1));
                    double newPrice = price * (100 - discount) / 100.0;
                    word = String.format("$%.2f", newPrice);
                }
            }
            ans.append(word).append(" ");
        }
        return ans.toString().trim();
    }
}
