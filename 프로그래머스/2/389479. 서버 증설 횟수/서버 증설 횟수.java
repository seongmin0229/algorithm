import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int user = 0;
        int scalingCount = 0;
        Deque<Integer> servers = new ArrayDeque<>();
        for(int i = 0; i < players.length; i++){
            while(!servers.isEmpty() && i - servers.peek() >= k){
                servers.poll();
            }
            int player = players[i];
            int additional = (player / m) - servers.size();
            while(additional > 0){
                servers.add(i);
                scalingCount++;
                additional--;
            }
        }
        return scalingCount;
    }
}