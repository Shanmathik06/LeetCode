// Question : https://leetcode.com/problems/making-a-large-island/
class Solution {
  //Initialization
    Map <Integer,Integer> map;
    int R,C;
    int [][]diff={{0,1},{0,-1},{-1,0},{1,0}};
    public int largestIsland(int[][] grid) {
        map=new HashMap<>();
        R=grid.length;
        C=grid[0].length;
        int max=0;
        int id=2;
         
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==1){

                     int size=dfs(i,j,id,grid);
                     map.put(id,size);
                     id++;
                }
            }
        }
        boolean hasZero=false;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==0){
                    hasZero=true;
                    int size=1;
                    Set <Integer> set =new HashSet<>();
                    for(int [] nums:diff){
                        int nr=nums[0]+i;
                        int nc=nums[1]+j;
                        if(nr<R && nr>=0 && nc<C && nc>=0 && grid[nr][nc]>1){
                        if(!set.contains(grid[nr][nc])){
                            set.add(grid[nr][nc]);
                            size+=map.get(grid[nr][nc]);

                        }
                    }
                    }
                 max=Math.max(max,size);   
                }
            }
        }
        return hasZero?max:R*C;
    }
       public int dfs(int r,int c,int id, int grid[][]){
            if(r>=R || r<0 || c>=C || c<0 ||grid[r][c]!=1){
                return 0;
            }
             grid[r][c]=id;
             int size=1;
             for(int []d:diff){
                int nr=d[0]+r;
                int nc=d[1]+c;
                    size+=dfs(nr,nc,id,grid);
                }
              return size;
             }
        }
