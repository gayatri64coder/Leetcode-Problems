class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0 ; i < s.length() ;i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        StringBuilder result = new StringBuilder();
        while( !pq.isEmpty() ){
            char c = pq.poll();
            result.append(String.valueOf(c).repeat(map.get(c)));
        }

        return result.toString();
    }
}