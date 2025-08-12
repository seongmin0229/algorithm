import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 내 아이디어
         * 홀수일 때 - 선공 승(성원)
         * 짝수일 때 - 후공 승(형석)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        long total = 0L;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{1, 0, 0});

        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            int node = pop[0], parent = pop[1], depth = pop[2];


            if(node != 1 && adj[node].size() == 1){
                total += depth;
                continue;
            }

            for(int child : adj[node]) {
                if(child == parent) continue;
                stack.push(new int[]{child, node, depth + 1});
            }
        }

        if(total % 2 == 0){
            bw.append("No");
        }else {
            bw.append("Yes");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
