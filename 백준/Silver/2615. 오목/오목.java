import java.io.*;
import java.util.Arrays;

public class Main {

    static int[][] map;
    static int[][] directions = new int[][]{{1, -1}, {1, 1}, {1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[19][19];

        for(int i = 0; i < 19; i++){
            String[] temp = br.readLine().split(" ");
            for(int j = 0; j < 19; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        boolean isComplete = false;
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < 19; j++){
            for(int i = 0; i < 19; i++){
                if(map[i][j] == 1 || map[i][j] == 2){
                    if(bruteforce(i, j, map[i][j])){
                        sb.append(map[i][j]);
                        sb.append("\n");
                        sb.append(i + 1).append(" ");
                        sb.append(j + 1);
                        isComplete = true;
                        break;
                    }
                }
            }
            if(isComplete) break;
        }

        if(!isComplete){
            sb.append("0");
        }

        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static boolean bruteforce(int i, int j, int v) {
        int temp_i = i;
        int temp_j = j;
        int sum = 0;

        for (int[] direction : directions) {
            while(temp_i >= 0 && temp_j >= 0 && temp_i < 19 && temp_j < 19 && map[temp_i][temp_j] == v){
                temp_i += direction[0];
                temp_j += direction[1];
                sum++;
            }
            temp_i = i;
            temp_j = j;
            while(temp_i >= 0 && temp_j >= 0 && temp_i < 19 && temp_j < 19 && map[temp_i][temp_j] == v){
                temp_i -= direction[0];
                temp_j -= direction[1];
                sum++;
            }
            sum -= 1;
            if(sum == 5) return true;
            temp_i = i;
            temp_j = j;
            sum = 0;
        }

        return false;
    }
}
