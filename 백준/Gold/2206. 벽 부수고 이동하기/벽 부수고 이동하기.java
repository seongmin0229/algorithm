import java.io.*;
import java.util.*;

public class Main {


    static int n;
    static int m;
    static char[][] map;
    static boolean[][][] visit;
    static int[][] iters = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");

        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        map = new char[n][m];
        visit = new boolean[n][m][2];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        int answer = bfs();
        bw.append(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {

        Queue<State> queue = new LinkedList<>();
        State init = new State(0, 0, 1, false);
        queue.add(init);
        visit[0][0][0] = true;

        while(!queue.isEmpty()){
            State state = queue.poll();
            int x = state.x;
            int y = state.y;
            if(x == n - 1 && y == m - 1) return state.count;

            for(int[] iter : iters){
                int _x = x + iter[0];
                int _y = y + iter[1];

                if(_x >= 0 && _x < n && _y >= 0 && _y < m){
                    if(map[_x][_y] == '0' && !visit[_x][_y][state.wallBreak ? 1 : 0]){
                        queue.add(new State(_x, _y, state.count + 1, state.wallBreak));
                        visit[_x][_y][state.wallBreak? 1 : 0] = true;
                    }
                    if(map[_x][_y] == '1' && !state.wallBreak && !visit[_x][_y][1]){
                        queue.add(new State(_x, _y, state.count + 1, true));
                        visit[_x][_y][1] = true;
                    }
                }
            }
        }


        return -1;
    }

    static class State{
        int x;
        int y;
        int count;
        boolean wallBreak;

        public State(int x, int y, int count, boolean wallBreak) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wallBreak = wallBreak;
        }
    }


}
