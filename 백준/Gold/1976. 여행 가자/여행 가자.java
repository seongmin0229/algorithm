import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");

            for(int j = 0; j < line.length; j++){
                if(Integer.parseInt(line[j]) == 1){
                    union(i, j);
                }
            }
        }

        String[] line = br.readLine().split(" ");

        int root = find(Integer.parseInt(line[0]) - 1);
        boolean flag = true;

        for(int i = 1; i < m; i++){
            if(find(Integer.parseInt(line[i]) - 1) != root){
                flag = false;
                break;
            }
        }

        if(flag) bw.append("YES");
        else bw.append("NO");

//        System.out.println(Arrays.toString(parent));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int x) {
        if(x != parent[x]){
            return find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}
