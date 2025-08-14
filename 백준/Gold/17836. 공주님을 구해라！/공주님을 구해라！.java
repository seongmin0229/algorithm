import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    public static void main(String[] args) throws IOException {

        /**
         * 내 아이디어
         * 검으로 벽뚫을 할 수 있는걸 제외하면, 전형적인 BFS 문제
         * 근데 이 검으로 벽뚫하는걸 어떻게 처리할거냐?
         * 검을 가졌는지 아닌지에 대한 상태를 boolean값으로 처리
         * 검을 가진 상태가 되면, 이미 방문한 노드에 대해서도 다시 방문할 필요가 있으므로
         * 검을 가진 상태에 대한 visit을 하나 더 만들고, 따로 관리함
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        boolean[][] visitWithGram = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[3]));

        int answer = Integer.MAX_VALUE;
        pq.add(new int[]{0, 0, 0, 0});
        visit[0][0] = true;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int hasGram = current[2];
            int depth = current[3];

            if(x == n - 1 && y == m - 1) {
                answer = depth;
                break;
            }

            if(t < depth){
                break;
            }

            if(map[x][y] == 2){
                hasGram = 1;
            }

            for (int[] direction : directions) {
                int _x = x + direction[0];
                int _y = y + direction[1];

                if(isValid(_x, _y)){
                    if(hasGram == 0){
                        if(map[_x][_y] == 1 || visit[_x][_y]) continue;
                        pq.add(new int[]{_x, _y, hasGram, depth + 1});
                        visit[_x][_y] = true;
                    }else{
                        if(visitWithGram[_x][_y]) continue;
                        pq.add(new int[]{_x, _y, hasGram, depth + 1});
                        visitWithGram[_x][_y] = true;
                    }
                }
            }

        }

        if(answer == Integer.MAX_VALUE){
            bw.append("Fail");
        }else{
            bw.append(String.valueOf(answer));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isValid(int x, int y){
        return x < n && x >= 0 && y < m && y >= 0;
    }

}
