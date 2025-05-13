import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int m;
    static int n;
    static int k;
    static int[][] map;
    static boolean[][] visit;

    static int[][] iters = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < k; i++){
            String[] temp = br.readLine().split(" ");
            int startX = Integer.parseInt(temp[0]);
            int endX = Integer.parseInt(temp[2]);
            int startY = Integer.parseInt(temp[1]);
            int endY = Integer.parseInt(temp[3]);

            for(int j = startX; j < endX; j++){
                for(int k = startY; k < endY; k++){
                    map[j][k] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visit[i][j] && map[i][j] != 1){
                    int area = dfs(i, j);
                    areas.add(area);
                }
            }
        }
        areas.sort(Integer::compareTo);
        bw.append(String.valueOf(areas.size())).append("\n");
        for (Integer area : areas) {
            bw.append(String.valueOf(area)).append(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int i, int j){
        visit[i][j] = true;
        int count = 1;

        for (int[] iter : iters) {
            int _i = i + iter[0];
            int _j = j + iter[1];
            if(_i >= 0 && _j >= 0 && _i < n && _j < m && !visit[_i][_j] && map[_i][_j] != 1){
                count += dfs(_i, _j);
            }
        }
        return count;
    }
}
