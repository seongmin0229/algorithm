
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] schedules = new int[n][2];

        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split(" ");

            int s = Integer.parseInt(split[0]);
            int t = Integer.parseInt(split[1]);

            schedules[i][0] = s;
            schedules[i][1] = t;
        }

        Arrays.sort(schedules, Comparator.comparingInt(x -> x[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int[] schedule : schedules) {
            int s = schedule[0];
            int t = schedule[1];

            if(!queue.isEmpty() && queue.peek() <= s){
                queue.poll();
            }

            queue.add(t);
        }
        bw.append(String.valueOf(queue.size()));

        bw.flush();
        bw.close();
        br.close();
    }
}
