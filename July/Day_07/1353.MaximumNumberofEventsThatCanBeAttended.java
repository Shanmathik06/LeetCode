// Question : https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
class Solution {

    public int maxEvents(int[][] events) {
        int n = events.length;
        int maxDay=0;
        int totalDay=0;
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        // To find how many days we have, to atten the event
        for(int [] event :events){
            maxDay=Math.max(event[1],maxDay);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        // Start with day 1 and traverse the array
        for(int day=1,j=0;day<=maxDay;day++){
            //if 0 position is lesser than or equal to the curr day , we have the chance to  atten the function
            while(j<n && events[j][0]<=day){
                pq.offer(events[j][1]);
                j++;
            }
            // if the val in the queue is is greater than the curr day, the the event finish . we cant able to atten th event 
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
            // if the end day is not exceed the curr day ,then we can go to the event
           if (!pq.isEmpty() && pq.peek()>=day){
                pq.poll();
                totalDay++;
            }
            
            
        }
        return totalDay;
    }
}
