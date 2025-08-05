import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visit;
    static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        map = new int[n][m];
        visit = new boolean[n][m];
        int answer = 0;

        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[2]));
        pq.add(new int[]{0, 0, 1});
        visit[0][0] = true;

        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int x = poll[0];
            int y = poll[1];
            int d = poll[2];
            if(x == n - 1 && y == m - 1){
                answer = d;
                break;
            }
            for (int[] direction : directions) {
                int _x = x + direction[0];
                int _y = y + direction[1];

                if(_x >= 0 && _x < n && _y >= 0 && _y < m && map[_x][_y] == 1 && !visit[_x][_y]){
                    pq.add(new int[]{_x, _y, d + 1});
                    visit[_x][_y] = true;
                }
            }
        }

        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
