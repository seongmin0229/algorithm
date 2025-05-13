import java.io.*;
import java.util.*;

public class Main {

    // union-find 풀이

    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        parent = new int[n + 1];

        // 초기화
        for(int i = 1; i < n + 1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            union(a, b);
        }

        Set<Integer> components = new HashSet<>();
        for(int i = 1; i < n + 1; i++){
            components.add(find(i));
        }

        bw.append(String.valueOf(components.size()));

        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            parent[pa] = pb;
        }
    }
}
