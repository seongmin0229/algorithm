import java.io.*;
import java.util.Arrays;

public class Main {

    static int[][] graph;
    static boolean[][] visit;
    static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);

        graph = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < k; i++){
            String[] split = br.readLine().split(" ");
            int r = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);

            graph[r - 1][c - 1] = 1;
        }

        int answer = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 1 && !visit[i][j]){
                    answer = Math.max(answer, dfs(i, j));
                }
            }
        }
        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int x, int y){
        visit[x][y] = true;
        int sum = 1;
        for (int[] direction : directions) {
            int _x = x + direction[0];
            int _y = y + direction[1];

            if(_x >= 0 && _x < n && _y >= 0 && _y < m && !visit[_x][_y] && graph[_x][_y] == 1){
                sum += dfs(_x, _y);
            }
        }
        return sum;
    }
}
