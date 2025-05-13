
import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    static int w;
    static int h;

    static int[][] map;
    static boolean[][] visit;

    static int[][] iters = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        while(!line.equals("0 0")){
            String[] split = line.split(" ");
            w = Integer.parseInt(split[0]);
            h = Integer.parseInt(split[1]);

            map = new int[h][w];
            visit = new boolean[h][w];

            for(int i = 0; i < h; i++){
                String[] nums = br.readLine().split(" ");
                map[i] = Arrays.stream(nums)
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            bw.append(String.valueOf(numOfIsland())).append("\n");

            line = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int numOfIsland() {
        int count = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(!visit[i][j] && map[i][j] == 1){
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j) {
        visit[i][j] = true;
        for(int[] iter : iters){
            int _i = i + iter[0];
            int _j = j + iter[1];

            if(_i >= 0 && _j >= 0 && _i < h && _j < w && !visit[_i][_j] && map[_i][_j] == 1){
                dfs(_i, _j);
            }
        }
    }
}
