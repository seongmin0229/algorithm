import java.util.*;

class Solution {
    
    static int answer;
    static int n;
    static int m;
    static int[][] q;
    static int[] ans;
    
    public static int solution(int n, int[][] q, int[] ans) {
        Solution.answer = 0;
        Solution.n = n;
        Solution.m = q.length;
        Solution.q = q;
        Solution.ans = ans;
        
        dfs(0, new ArrayDeque<>());
        
        return answer;
    }
    
    public static void dfs(int previous_number, Deque<Integer> numq){
        if(numq.size() == 5){
            if(check(numq)){
                answer++;
            }
            return;
        }
        
        if(previous_number == n) return;
        
        for(int i = previous_number + 1; i <= n; i++){
            numq.addLast(i);
            dfs(i, numq);
            numq.removeLast();
        }
    }
    
    public static boolean check(Deque<Integer> numq){
        int[] picked = new int[5];
        int idx = 0;
        for(int x : numq) picked[idx++] = x;
        for(int i = 0; i < m; i++){
            if(!satisfy(i, picked)) return false;
        }
        return true;
    }
    
    public static boolean satisfy(int x, int[] answer){
        int[] target = q[x];
        int count = 0;
        for(int a : answer){
            for(int t : target){
                if(a == t) count++;
            }
        }
        
        return count == ans[x];
    }
}