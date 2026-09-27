class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<HashMap<HashMap<Character, Integer>, ArrayList<String>>> listOfAnagrams = new ArrayList<>();
        List<List<String>> output = new ArrayList<>();
        HashMap<Character, Integer> inital = new HashMap<>();
        HashMap<HashMap<Character, Integer>, ArrayList<String>> initalAna = new HashMap<>();
        ArrayList<String> initalStr = new ArrayList<>();
        initalStr.add(strs[0]);
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            inital.put(c, inital.getOrDefault(c, 0) + 1);
        }
        initalAna.put(inital, initalStr);
        listOfAnagrams.add(initalAna);

        for (int k = 1; k < strs.length; k++) {
            String s = strs[k];
            HashMap<Character, Integer> h = new HashMap<>();
            //create hashmap for string s
            for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    h.put(c, h.getOrDefault(c, 0) + 1);
                }
            //compare hashmap with hashmap list
            boolean newHash = true;
            for (HashMap<HashMap<Character, Integer>, ArrayList<String>> x : listOfAnagrams) {
                for (HashMap<Character, Integer> f : x.keySet()){
                    if (f.equals(h)) {
                        newHash = false;
                    }
                }
                if (newHash) {
                    ArrayList<String> t = new ArrayList<>();
                    t.add(s);
                    x.put(h, t);
                }
                else {
                    ArrayList<String> stringList = x.get(h);
                    stringList.add(s);
                    x.put(h, stringList);
                }
            }
            
        }
        for (HashMap<HashMap<Character, Integer>, ArrayList<String>> h : listOfAnagrams) {
            for (HashMap<Character, Integer> key : h.keySet()) {
                output.add(h.get(key));
            }
            
        }
        return output;
    }
}
