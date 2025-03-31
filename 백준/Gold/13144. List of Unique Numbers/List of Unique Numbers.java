import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int[] nums;
    static boolean[] visit;
    static long answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        visit = new boolean[100001];
        answer = 0;
        String[] line = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        int start = 0;
        int end = 0;

        while(start < n){
            if(visit[nums[end]]){
                answer += end - start;
                visit[nums[start]] = false;
                start++;
                continue;
            }

            if(end == n - 1){
                answer += end - start + 1;
                visit[nums[start]] = false;
                start++;
                continue;
            }

            visit[nums[end]] = true;
            end++;
        }

        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
