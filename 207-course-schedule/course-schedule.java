class Solution {
    //using BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int []ind = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        //empty arraylist
        for(int i =0 ; i< numCourses ;i++){
            list.add(new ArrayList<>());
        }
        
        //add prerequisites to adj list
        for(int[] a : prerequisites){
            int course = a[0];
            int pre =a[1];
            list.get(pre).add(course);
            ind[course]++;
        }
        //fill value in queue
        for(int i =0 ; i < numCourses ;i++){
            if(ind[i] == 0){
                q.add(i);
            }
        }
        int com = 0;
        while(!q.isEmpty()){
            int num = q.poll();
            com++;

            for(int neighbor : list.get(num)){
                ind[neighbor]--;
                if(ind[neighbor] ==0){
                    q.add(neighbor);
                }
            }
        }
        
        
        return com == numCourses;
    }
}