import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        /**
         * 벨만 포드 알고리즘
         * n - 1 번 완화 반복
         * n번째에 한 번 더 수행해서 음수 사이클 판별
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new int[]{u, v, w};
        }

        long[] distance = new long[n + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;

        // n - 1번 완화
        for(int i = 1; i < n; i++){
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if(distance[u] == INF) continue;
                long newDistance = distance[u] + w;
                if(distance[v] > newDistance){
                    distance[v] = newDistance;
                }
            }
        }

        // 음수 사이클 감지
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(distance[u] == INF) continue;
            long newDistance = distance[u] + w;
            if(distance[v] > newDistance){
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int v = 2; v <= n; v++) {
            sb.append(distance[v] == INF ? -1 : distance[v]).append('\n');
        }
        System.out.println(sb);
    }
}
