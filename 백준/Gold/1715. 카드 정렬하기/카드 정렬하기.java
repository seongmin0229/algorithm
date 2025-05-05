
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while(!queue.isEmpty()){
            if(queue.size() == 1){
                break;
            }

            int x = queue.poll();
            int y = queue.poll();

            queue.add(x + y);
            sum += x + y;
        }
        bw.append(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
