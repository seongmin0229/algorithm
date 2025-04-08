import java.io.*;
import java.util.*;

public class Main {

    static final int WALL = 0;
    static final int SPACE = 1;
    static final int FIRE = 2;

    static int r;
    static int c;

    static int[][] map;

    static List<int[]> fires;

    static int[][] iters = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");

        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        map = new int[r][c];
        visit = new boolean[r][c];

        fires = new ArrayList<>();
        int startX = 0;
        int startY = 0;

        for(int i = 0; i < r; i++){
            char[] line2 = br.readLine().toCharArray();
            for(int j = 0; j < c; j++){
                if(line2[j] == '#'){
                    map[i][j] = WALL;
                }
                if(line2[j] == '.'){
                    map[i][j] = SPACE;
                }
                if(line2[j] == 'J'){
                    map[i][j] = SPACE;
                    startX = i;
                    startY = j;
                }
                if(line2[j] == 'F'){
                    map[i][j] = FIRE;
                    fires.add(new int[]{i, j});
                }
            }
        }

        int answer = bfs(startX, startY);

        if(answer == -1) bw.append("IMPOSSIBLE");
        else bw.append(String.valueOf(answer + 1));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int startX, int startY) {

        Queue<State> queue = new LinkedList<>();

        queue.add(new State(startX, startY, 0));
        visit[startX][startY] = true;

        Queue<int[]> fireQueue = new LinkedList<>(fires);

        while(!queue.isEmpty()){

            int queueSize = queue.size();

            while(queueSize-- > 0){
                State state = queue.poll();

                if(map[state.x][state.y] == FIRE) continue;

                if(state.x == 0 || state.y == 0 || state.x == r - 1 || state.y == c - 1) return state.depth;

                for(int[] iter : iters){
                    int _x = state.x + iter[0];
                    int _y = state.y + iter[1];
                    if(_x > -1 && _y > -1 && _x < r && _y < c && map[_x][_y] == SPACE && !visit[_x][_y]){
                        queue.add(new State(_x, _y, state.depth + 1));
                        visit[_x][_y] = true;
                    }
                }
            }

            int fireQueueSize = fireQueue.size();

            while(fireQueueSize-- > 0){
                int[] fire = fireQueue.poll();

                for(int[] iter : iters){
                    int _x = fire[0] + iter[0];
                    int _y = fire[1] + iter[1];
                    if(_x > -1 && _y > -1 && _x < r && _y < c && map[_x][_y] == SPACE){
                        fireQueue.add(new int[]{_x, _y});
                        map[_x][_y] = FIRE;
                    }
                }

            }
        }

        return -1;
    }


    static class State{
        int x;
        int y;
        int depth;

        public State(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

}
