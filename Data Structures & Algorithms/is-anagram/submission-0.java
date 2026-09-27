class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> characters = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);        
            characters.put(c, characters.getOrDefault(c, 0) + 1);
            //Process char
        }
        for (int i = 0; i < t.length(); i++){
            char x = t.charAt(i);
            if (!characters.containsKey(x)) {
                return false;
            }        
            characters.put(x, characters.getOrDefault(x, 0) - 1);
            if (characters.get(x) == 0) {
                characters.remove(x);
            }
            //Process char
        }

        return characters.isEmpty();

    }
}
