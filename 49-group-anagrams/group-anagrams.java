class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*List<List<String>> result = new ArrayList<>();
        if(strs.length == 0 ){
            return result;
        }
        if( strs.length == 1){
            result.add(new ArrayList<>(List.of(strs[0])));
            return result;
        }*/
        Map<String , List<String>> map = new HashMap<>();

        for( String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedKey = String.valueOf(arr);

            if( !map.containsKey(sortedKey)){
                map.put(sortedKey,new ArrayList<>());
            }
            map.get(sortedKey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}