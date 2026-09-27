class Solution {
    public boolean isPalindrome(String lower) {
        String s = lower.toLowerCase();
        int len = s.length();
        int l = 0;
        int r = len - 1;
        while (l < r) {
            while (l < r && !alphaNum(s.charAt(l))) {
                l++;
            }
            while (l < r && !alphaNum(s.charAt(r))) {
                r--;
            }

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
