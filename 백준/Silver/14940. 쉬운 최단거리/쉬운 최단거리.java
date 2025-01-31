import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[][] repeater = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);

        map = new int[n][m];
        visited = new boolean[n][m];

        int x = 0;
        int y = 0;
        int c = 0;
        while(c < n){
            String[] line = br.readLine().split(" ");
            for(int i = 0; i < line.length; i++){
                int n = Integer.parseInt(line[i]);
                if(n == 1) map[c][i] = -1;
                if(n == 0) {
                    map[c][i] = 0;
                    visited[c][i] = true;
                }
                if(n == 2){
                    map[c][i] = -1;
                    x = c;
                    y = i;
                }
            }
            c++;
        }

        setDistanceFromXY(x, y);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.append(Integer.toString(map[i][j])).append(" ");
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setDistanceFromXY(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            map[node.x][node.y] = node.d;
            for(int[] repeat : repeater){
                int _x = node.x + repeat[0];
                int _y = node.y + repeat[1];
                if((_x < n && _y < m && _x >= 0 && _y >= 0) && !visited[_x][_y]){
                    queue.add(new Node(_x, _y, node.d + 1));
                    visited[_x][_y] = true;
                }
            }
        }

//        if(x >= n || y >= m || x < 0 || y < 0) return;
//        if(visited[x][y]) return;
//        map[x][y] = distance;
//        visited[x][y] = true;
//        setDistanceFromXY(x + 1, y, distance + 1);
//        setDistanceFromXY(x - 1, y, distance + 1);
//        setDistanceFromXY(x, y + 1, distance + 1);
//        setDistanceFromXY(x, y - 1, distance + 1);
    }

    static class Node{
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }



}