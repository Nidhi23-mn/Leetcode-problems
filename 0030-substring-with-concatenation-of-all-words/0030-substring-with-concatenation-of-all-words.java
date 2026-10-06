class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;

        if (totalLen > s.length()) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int start = 0; start < wordLen; start++) {
            int left = start;
            int count = 0;

            Map<String, Integer> current = new HashMap<>();

            for (int right = start; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (!map.containsKey(word)) {
                    current.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                current.put(word, current.getOrDefault(word, 0) + 1);
                count++;

                while (current.get(word) > map.get(word)) {
                    String remove = s.substring(left, left + wordLen);

                    current.put(remove, current.get(remove) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == totalWords) {
                    ans.add(left);

                    String remove = s.substring(left, left + wordLen);
                    current.put(remove, current.get(remove) - 1);
                    left += wordLen;
                    count--;
                }
            }
        }

        return ans;
    }
}