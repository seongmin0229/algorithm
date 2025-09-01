import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;

    static boolean[][] visit;
    static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 아이디어
         * 구현 + DFS 문제
         * 빙하가 녹는건 구현, 빙하가 두 덩어리 이상으로 떨어져있는지 확인은 DFS
         * 이 때 빙하가 녹는 로직을 구현할 때 조심해야 하는게, 음수로 떨어지면 안되고, 해당 년도에 함께 녹은 빙하를 바다로 인식하면 안됨.
         */

        int t = 1;
        while(true){
            List<int[]> targets = new ArrayList<>();
            for(int i = 1; i < n - 1; i++){
                for(int j = 1; j < m - 1; j++){
                    if(map[i][j] != 0){
                        int count = 0;
                        for (int[] direction : directions) {
                            int _x = i + direction[0];
                            int _y = j + direction[1];
                            if(map[_x][_y] == 0) count++;
                        }
                        targets.add(new int[]{i, j, count});
                    }
                }
            }

            for (int[] target : targets) {
                int x = target[0];
                int y = target[1];
                int count = target[2];

                if(map[x][y] - count >= 0) map[x][y] -= count;
                else map[x][y] = 0;
            }

//            System.out.println(Arrays.deepToString(map));

            int sectors = 0;
            for(int i = 1; i < n - 1; i++){
                for(int j = 1; j < m - 1; j++){
                    if(map[i][j] != 0 && !visit[i][j]){
                        sectors += 1;
                        dfs(i, j);
                        if(sectors >= 2){
                            System.out.println(t);
                            return;
                        }
                    }
                }
            }

            for(int i = 0; i < n; i++){
                Arrays.fill(visit[i], false);
            }

            if(sectors == 0){
                System.out.println(0);
                return;
            }

            t++;
        }

    }

    private static void dfs(int i, int j) {
        if(!isValid(i, j) || map[i][j] == 0 || visit[i][j]){
            return;
        }

        visit[i][j] = true;

        for (int[] direction : directions) {
            int _x = i + direction[0];
            int _y = j + direction[1];

            dfs(_x, _y);
        }
    }

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

}
