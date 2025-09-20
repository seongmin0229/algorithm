import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 99000000;
    public static void main(String[] args) throws IOException {
        /**
         * 플로이드 와샬 알고리즘
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];

        // 초기화
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            if(graph[a][b] > c) graph[a][b] = c;
        }

        // 플로이드 와샬 시작
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[j][i] == INF) continue;
                for(int k = 0; k < n; k++){
                    if(graph[i][k] == INF) continue;
                    int cost = graph[j][i] + graph[i][k];
                    if(graph[j][k] > cost){
                        graph[j][k] = cost;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == INF){
                    sb.append(0);
                }else{
                    sb.append(graph[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
