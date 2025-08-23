import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] s = new long[n];
        HashSet<Long> visited = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            s[i] = Long.parseLong(st.nextToken());
            visited.add(s[i]);
        }

        /**
         * 내 아이디어
         * 우선순위 큐를 사용해서 샘터 위치에서 +-1, +-2... 이런식으로 BFS 돌려서 집의 위치를 결정해주고
         * 중복된 위치에 대해서는 배열로 관리한다.
         */


        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        long answer = 0;

        for (long i : s) {
            pq.add(new long[]{1, i, -1});
            pq.add(new long[]{1, i, 1});
        }

        while (k > 0 && !pq.isEmpty()){
            long[] cur = pq.poll();
            long distance = cur[0];
            long coordinate = cur[1];
            long direction = cur[2];

            long _coordinate = coordinate + direction;

            if(!visited.contains(_coordinate)){
                visited.add(_coordinate);
                k--;
                answer += distance;
                pq.add(new long[]{distance + 1, _coordinate, direction});
            }
        }

        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
