import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Integer, List<Integer>> map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        map = new HashMap<>();
        visit = new boolean[n];

        for(int i = 0; i < n; i++){
            map.put(i + 1, new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            String[] tmpSplit = br.readLine().split(" ");
            int a = Integer.parseInt(tmpSplit[0]);
            int b = Integer.parseInt(tmpSplit[1]);

            List<Integer> list = map.get(a);
            list.add(b);

            List<Integer> list2 = map.get(b);
            list2.add(a);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                count++;
                dfs(i);
            }
        }
        bw.append(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int i){
        visit[i] = true;
        List<Integer> list = map.get(i + 1);
        for (Integer integer : list) {
            if(!visit[integer - 1])
                dfs(integer - 1);
        }
    }
}
