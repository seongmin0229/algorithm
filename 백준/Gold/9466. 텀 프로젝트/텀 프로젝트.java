import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int n;
    static int[] students;
    static boolean[] visit;
    static int[] kind;

    static final int INDETERMINATE = 0;
    static final int NOT_IN_GROUP = 1;
    static final int GROUP = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visit = new boolean[n + 1];
            kind = new int[n + 1];
            String[] split = br.readLine().split(" ");
            for(int i = 1; i <= n; i++){
                students[i] = Integer.parseInt(split[i - 1]);
            }

            for(int i = 1; i <= n; i++){
                if(!visit[i]) {
                    dfs(i);
                }
            }

            int count = 0;
            for(int i = 1; i <= n; i++){
                if(kind[i] == NOT_IN_GROUP) count++;
            }

            bw.append(String.valueOf(count)).append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int i){
        if(visit[i]){
            if(kind[i] == INDETERMINATE){
                return i;
            }
            return -1;
        }

        if(i == students[i]){
            visit[i] = true;
            kind[i] = GROUP;
            return -1;
        }

        visit[i] = true;
        int result = dfs(students[i]);
        if(result == -1){
            kind[i] = NOT_IN_GROUP;
            return result;
        }

        kind[i] = GROUP;

        if(result == i){
            return -1;
        }

        return result;
    }
}
