class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for (String str : strs) {
            int n = str.length();
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                encoded = encoded + (int) c + "/";
            }
            encoded = encoded + "|";
        }
        System.out.println(encoded);
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int len = str.length();
        String curr = "";
        String currC = "";
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '|') {
                decoded.add(curr);
                curr = "";
            } else if (str.charAt(i) == '/') {
                int n = Integer.parseInt(currC);
                char c = (char) n;
                curr = curr + c;
                currC = "";

            } else {
                currC = currC + str.charAt(i);
            }

        }

        return decoded;
    }
}
