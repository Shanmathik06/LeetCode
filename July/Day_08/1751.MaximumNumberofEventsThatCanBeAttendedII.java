class Solution {
    private int[][] dp;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int n = events.length;
        dp = new int[k+1][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return dfs(0,k,events);
    }
    private int dfs(int curIdx,int count,int[][] events){
        if(count==0 || curIdx==events.length){
            return 0;
        }
        if(dp[count][curIdx]!=-1){
            return dp[count][curIdx];
        }
        int nxtIdx = bisectRight(events,events[curIdx][1]);
        dp[count][curIdx] = Math.max(dfs(curIdx+1,count,events),events[curIdx][2]+dfs(nxtIdx,count-1,events));
        return dp[count][curIdx];
    }
    private int bisectRight(int[][] events,int target){
        int left = 0, right = events.length;
        while(left<right){
            int mid = (left+right)/2;
            if(events[mid][0]<=target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
