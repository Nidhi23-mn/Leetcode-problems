class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        long ans = 0;

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            ans = ans * 10 + digit;

            if (sign == 1 && ans > 2147483647) {
                return 2147483647;
            }

            if (sign == -1 && -ans < -2147483648L) {
                return -2147483648;
            }

            i++;
        }

        return (int)(sign * ans);
    }
}