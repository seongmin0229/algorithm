import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int l;
    static int r;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        /**
         * DFS 아님 BFS로 구현하는 그래프 탐색 문제
         * 더 이상 열릴 국경이 없을때까지 진행
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visit = new boolean[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag;
        int count = 0;
        while(true){
            flag = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!visit[i][j]) {
                        flag = dfs(i, j) || flag;
                    }
                }
            }

            if(!flag) {
                System.out.println(count);
//                System.out.println(Arrays.deepToString(map));
                return;
            }

            // 방문 배열 초기화
            for(int i = 0; i < n; i++){
                Arrays.fill(visit[i], false);
            }
            count++;
        }

    }

    private static boolean dfs(int i, int j) {
        Stack<int[]> stack = new Stack<>();
        Deque<int[]> queue = new ArrayDeque<>();
        int total = 0;

        stack.push(new int[]{i, j});
        visit[i][j] = true;

        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            int x = cur[0], y = cur[1];
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if(valid(nx, ny) && !visit[nx][ny] && isUnion(map[x][y], map[nx][ny])){
                    stack.push(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
            queue.add(new int[]{x, y});
            total += map[x][y];
        }

        if(queue.size() == 1) return false;

        int div = total / queue.size();

        while(!queue.isEmpty()){
            int[] cur = queue.pollFirst();
            int x = cur[0], y = cur[1];
            map[x][y] = div;
        }

        return true;
    }

    private static boolean valid(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }

    private static boolean isUnion(int a, int b) {
        int diff = Math.abs(a - b);
        return diff >= l && diff <= r;
    }
}
