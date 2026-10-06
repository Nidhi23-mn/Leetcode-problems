class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            String letters = map[digits.charAt(i) - '0'];
            List<String> temp = new ArrayList<>();

            for (String str : result) {
                for (char c : letters.toCharArray()) {
                    temp.add(str + c);
                }
            }

            result = temp;
        }

        return result;
    }
}