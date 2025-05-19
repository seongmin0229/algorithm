import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        bw.append(Integer.toString(bfs(n, k)));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int n, int k) {
        int[] visit = new int[100001];
        Arrays.fill(visit, -1);

        Deque<Pair> queue = new ArrayDeque<>();
        queue.addFirst(new Pair(n, 0));
        visit[n] = 0;

        while(!queue.isEmpty()){
            Pair i = queue.pollFirst();
            int pos = i.pos;
            int h = i.h;

            if(pos == k) return h;

            if(pos < 50001 && visit[pos * 2] == -1) {
                visit[pos * 2] = h;
                queue.addFirst(new Pair(pos * 2, h));
            }

            if(pos > 0 && visit[pos - 1] == -1){
                visit[pos - 1] = h + 1;
                queue.add(new Pair(pos - 1, h + 1));
            }

            if(pos < 100000 && visit[pos + 1] == -1){
                visit[pos + 1] = h + 1;
                queue.add(new Pair(pos + 1, h + 1));
            }
        }
        return -1;
    }

    static class Pair implements Comparable<Pair>{
        int pos;
        int h;

        public Pair(int pos, int h) {
            this.pos = pos;
            this.h = h;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.h, o.h);
        }
    }

}
