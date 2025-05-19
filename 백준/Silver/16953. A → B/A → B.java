import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparing(x -> x[0]));

        queue.add(new long[]{0, a});

        long answer = -1;

        while(!queue.isEmpty()){
            long[] poll = queue.poll();
            long x = poll[0];
            long y = poll[1];

            if(y == b) {
                answer = x + 1;
                break;
            }

            long _y = Long.parseLong(y + "1");
            if(_y <= b){
                queue.add(new long[]{x + 1, _y});
            }

            if(y * 2 <= b){
                queue.add(new long[]{x + 1, y * 2});
            }
        }

        bw.append(String.valueOf(answer));


        bw.flush();
        bw.close();
        br.close();
    }
}
