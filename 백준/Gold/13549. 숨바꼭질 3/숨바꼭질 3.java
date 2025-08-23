import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        /**
         * 0 - 1 BFS 문제, 보통 Deque를 사용함
         */

        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.add(n);

        while(!deque.isEmpty()){
            int cur = deque.pollFirst();

            if(cur == k) break;

            int nx = cur * 2;
            if(nx < 100001 && dist[nx] > dist[cur]){
                dist[nx] = dist[cur];
                deque.addFirst(nx);
            }

            nx = cur - 1;
            if(nx >= 0 && dist[nx] > dist[cur] + 1){
                dist[nx] = dist[cur] + 1;
                deque.addLast(nx);
            }

            nx = cur + 1;
            if(nx < 100001 && dist[nx] > dist[cur] + 1){
                dist[nx] = dist[cur] + 1;
                deque.addLast(nx);
            }
        }

        System.out.println(dist[k]);
    }
}
