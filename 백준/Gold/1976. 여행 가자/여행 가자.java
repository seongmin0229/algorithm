import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;


        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int isConnected = Integer.parseInt(st.nextToken());
                if(isConnected == 1){
                    if(find(i) != find(j)) union(i, j);
                }
            }
        }

//        System.out.println(Arrays.toString(parent));

        st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken()) - 1;
        while(st.hasMoreTokens()){
            int cur = Integer.parseInt(st.nextToken()) - 1;
            if(parent[cur] != parent[first]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }

    static int find(int x){
        if(x == parent[x]) return x;
        else{
            int root = find(parent[x]);
            parent[x] = root;
            return root;
        }
    }

    static void union(int a, int b){
        int aParent = find(a);
        int bParent = find(b);

        if(aParent < bParent) parent[bParent] = aParent;
        else parent[aParent] = bParent;
    }
}
