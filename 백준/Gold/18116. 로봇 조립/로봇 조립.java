import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        parent = new int[1000001];
        size = new int[1000001];
        for(int i = 1; i < 1000001; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("I")){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int aParent = find(a);
                int bParent = find(b);
                if(aParent != bParent){
                    union(aParent, bParent);
                }
            }else{
                int a = Integer.parseInt(st.nextToken());
                sb.append(size[find(a)]).append("\n");
            }
        }
        System.out.println(sb);

    }

    static void union(int a, int b){
        if(a < b){
            parent[b] = a;
            size[a] += size[b];
        }else{
            parent[a] = b;
            size[b] += size[a];
        }
    }

    static int find(int x){
        if(x != parent[x]){
            int root = find(parent[x]);
            parent[x] = root;
            return root;
        }
        return x;
    }
}
