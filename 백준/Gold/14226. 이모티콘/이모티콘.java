import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        boolean[][] visit = new boolean[2001][2001];


        queue.add(new int[]{0, 1, 0});
        visit[1][0] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int cur = poll[0];
            int cur_s = poll[1];
            int clipboard = poll[2];

            if(cur_s == s) {
                bw.append(String.valueOf(cur));
                break;
            }

            if(clipboard != 0 && !visit[cur_s + clipboard][clipboard] && cur_s + clipboard < 1001){
                visit[cur_s + clipboard][clipboard] = true;
                queue.add(new int[]{cur + 1, cur_s + clipboard, clipboard});
            }

            if(!visit[cur_s][cur_s]){
                visit[cur_s][cur_s] = true;
                queue.add(new int[]{cur + 1, cur_s, cur_s});
            }

            if(cur_s > 1 && !visit[cur_s - 1][clipboard]) {
                visit[cur_s - 1][clipboard] = true;
                queue.add(new int[]{cur + 1, cur_s - 1, clipboard});
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
