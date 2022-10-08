class Solution {
    static int countOfSubstrings(String S, int K) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<K;i++) {
            char ch = S.charAt(i);
            
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        
        int count = 0;
        
        if(map.size() == K-1) count++;
        
        for(int i=K;i<S.length();i++) {
            char chToRemove = S.charAt(i-K);
            
            if(map.get(chToRemove) == 1) {
                map.remove(chToRemove);
            } else {
                map.put(chToRemove, map.get(chToRemove) - 1);
            }
            
            char ch = S.charAt(i);
            
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
            
            if(map.size() == K-1) {
                count++;
            }
        }
        
        return count;
    }
};
