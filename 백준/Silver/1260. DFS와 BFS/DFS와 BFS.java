import java.io.*;
import java.util.*;

public class Main {
    static Node[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int v = Integer.parseInt(arr[2]);

        nodes = new Node[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(i + 1);
        }

        int c = 0;
        while(c++ < m){
            String[] marr = br.readLine().split(" ");
            int x = Integer.parseInt(marr[0]);
            int y = Integer.parseInt(marr[1]);
            nodes[x - 1].connect(nodes[y - 1]);
            nodes[y - 1].connect(nodes[x - 1]);
        }

        for(int i = 0; i < n; i++){
            nodes[i].connected.sort(new NodeComparator());
        }
        bw.append(Integer.toString(v)).append(" ");
        dfs(v, bw);
        bw.append("\n");
        Arrays.fill(visited, false);
        bfs(v, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start, BufferedWriter bw) throws IOException {
        Node curNode = nodes[start - 1];
        visited[start - 1] = true;

        for(Node node : curNode.connected){
            if(!visited[node.number - 1]){
                bw.append(Integer.toString(node.number)).append(" ");
                dfs(node.number, bw);
            }
        }
    }

    private static void bfs(int start, BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start - 1] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            bw.append(Integer.toString(cur)).append(" ");
            for(Node node : nodes[cur - 1].connected){
                if(!visited[node.number - 1]){
                    visited[node.number - 1] = true;
                    queue.add(node.number);
                }
            }
        }
    }

    static class Node{
        int number;
        List<Node> connected;

        public Node(int number) {
            this.number = number;
            connected = new ArrayList<>();
        }

        public void connect(Node node){
            connected.add(node);
        }
    }

    static class NodeComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.number, o2.number);
        }
    }
}