import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if(map.containsKey(a)){
                map.get(a).add(b);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(b);
                map.put(a, l);
            }
        }

        map.values().forEach(list -> list.sort(null));

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];
            if(y == t) {
                System.out.println(d);
                return;
            }
            for(int i = -2; i <= 2; i++){
                int nx = x + i;
                List<Integer> yList = map.get(nx);

                if(yList == null) continue;

                for(int j = -2; j <= 2; j++){
                    int ny = y + j;
                    if(!yList.contains(ny)) continue;
                    q.add(new int[]{nx, ny, d + 1});
                    yList.remove((Integer)ny);
                }

            }
        }
        System.out.println(-1);
    }
}
