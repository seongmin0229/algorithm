import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int x;
    static Map<Integer, List<int[]>> graph1;
    static Map<Integer, List<int[]>> graph2;
    static int[] s;
    static int[] _s;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        x = Integer.parseInt(line[2]);

        graph1 = new HashMap<>();
        graph2 = new HashMap<>();
        s = new int[n];
        _s = new int[n];
        visit = new boolean[n];

        Arrays.fill(s, Integer.MAX_VALUE);
        Arrays.fill(_s, Integer.MAX_VALUE);

        s[x - 1] = 0;
        _s[x - 1] = 0;

        for(int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]) - 1;
            int b = Integer.parseInt(split[1]) - 1;
            int c = Integer.parseInt(split[2]);

            if(graph1.containsKey(a)){
                List<int[]> list = graph1.get(a);
                list.add(new int[]{b, c});
            }
            else{
                ArrayList<int[]> newList = new ArrayList<>();
                newList.add(new int[]{b, c});
                graph1.put(a, newList);
            }

            if(graph2.containsKey(b)){
                List<int[]> list = graph2.get(b);
                list.add(new int[]{a, c});
            }
            else{
                ArrayList<int[]> newList = new ArrayList<>();
                newList.add(new int[]{a, c});
                graph2.put(b, newList);
            }
        }

        dijkstra();
//        System.out.println("s = " + Arrays.toString(s));
//        System.out.println("_s = " + Arrays.toString(_s));

        for(int i = 0; i < n; i++){
            s[i] += _s[i];
        }

        bw.append(String.valueOf(Arrays.stream(s).max().getAsInt()));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra() {
        PriorityQueue<Pair> queue1 = new PriorityQueue<>();
        queue1.add(new Pair(x - 1, 0));
        while(!queue1.isEmpty()){
            Pair pair = queue1.poll();
            s[pair.node] = pair.cost;

            List<int[]> edges = graph1.get(pair.node);
            for (int[] edge : edges) {
                if(s[edge[0]] > s[pair.node] + edge[1]){
                    queue1.add(new Pair(edge[0], s[pair.node] + edge[1]));
                }
            }
        }

        PriorityQueue<Pair> queue2 = new PriorityQueue<>();
        queue2.add(new Pair(x - 1, 0));
        while(!queue2.isEmpty()){
            Pair pair = queue2.poll();
            _s[pair.node] = pair.cost;

            List<int[]> edges = graph2.get(pair.node);
            for (int[] edge : edges) {
                if(_s[edge[0]] > _s[pair.node] + edge[1]){
                    queue2.add(new Pair(edge[0], _s[pair.node] + edge[1]));
                }
            }

        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.cost, this.cost);
        }
    }


}
