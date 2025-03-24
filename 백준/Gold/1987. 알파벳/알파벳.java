import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int r;
    static int c;

    static char[][] map;
    static boolean[][] visit;

    static boolean[] alphabet;

    static int max;

    static int depth;

    static int[][] iters = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        alphabet = new boolean[26];
        max = 0;
        depth = 0;

        String[] split = br.readLine().split(" ");

        r = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);

        map = new char[r][c];
        visit = new boolean[r][c];

        for(int i = 0; i < r; i++){
            char[] s = br.readLine().toCharArray();
            map[i] = s;
        }

        dfs(0, 0);

        bw.append(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        depth++;
        alphabet[map[x][y] - 'A'] = true;
        visit[x][y] = true;
        max = Integer.max(max, depth);

        for(int[] iter : iters){
            int _x = x + iter[0];
            int _y = y + iter[1];

            if(_x >= 0 && _y >= 0 && _x < r && _y < c && !alphabet[map[_x][_y] - 'A'] && !visit[_x][_y]){
                dfs(_x, _y);
            }
        }
        depth--;
        alphabet[map[x][y] - 'A'] = false;
        visit[x][y] = false;
    }

}
