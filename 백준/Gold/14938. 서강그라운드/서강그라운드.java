import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dis = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) dis[i][j] = 0;
                else dis[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            dis[a][b] = w;
            dis[b][a] = w;
        }


        for(int c = 0; c < n; c++){
            for(int s = 0; s < n; s++){
                if(dis[s][c] == Integer.MAX_VALUE) continue;
                for(int e = 0; e < n; e++){
                    if(dis[c][e] == Integer.MAX_VALUE) continue;
                    int nDis = dis[s][c] + dis[c][e];
                    if(dis[s][e] > nDis) dis[s][e] = nDis;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                if(dis[i][j] <= m) sum += items[j];
            }
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
