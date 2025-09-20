import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h, w;
    static int[][] map, ps;
    public static void main(String[] args) throws IOException {
        /**
         * BFS, 대신 직사각형의 크기를 고려해서 이동시켜야함
         * 직사각형의 모서리(가장 왼쪽 위칸)을 기준으로 이동시킴
         * 대신 직사각형의 크기를 고려해서 벽이 있으면 이동할 수 없도록 분기처리를 해야함
         * 이때 벽이 있음을 판단하기 위해 누적합을 사용
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] iters = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ps = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                ps[i][j] = map[i - 1][j - 1] + ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        int s_r = Integer.parseInt(st.nextToken()) - 1;
        int s_c = Integer.parseInt(st.nextToken()) - 1;

        int f_r = Integer.parseInt(st.nextToken()) - 1;
        int f_c = Integer.parseInt(st.nextToken()) - 1;



        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{s_r, s_c, 0});
        visit[s_r][s_c] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.removeFirst();
            int x = cur[0];
            int y = cur[1];
            int c = cur[2];

            if(x == f_r && y == f_c) {
                System.out.println(c);
                return;
            }

            for (int[] iter : iters) {
                int _x = x + iter[0];
                int _y = y + iter[1];

                if(_x < 0 || _y < 0 || _x >= n - h + 1 || _y >= m - w + 1) continue;
                if(visit[_x][_y]) continue;
                if(blocked(_x, _y)) continue;

                queue.addLast(new int[]{_x, _y, c + 1});
                visit[_x][_y] = true;
            }
        }
        System.out.println(-1);
    }

    static boolean blocked(int x, int y){
        int x2 = x + h - 1, y2 = y + w - 1;
        return ps[x2 + 1][y2 + 1] - ps[x][y2 + 1] - ps[x2 + 1][y] + ps[x][y] > 0;
    }
}
