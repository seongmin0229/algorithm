import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int l;
    static int k;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        l = Integer.parseInt(split[2]);
        k = Integer.parseInt(split[3]);

        List<int[]> stars = new ArrayList<>();

        for(int i = 0; i < k; i++){
            String[] split1 = br.readLine().split(" ");
            int x = Integer.parseInt(split1[0]);
            int y = Integer.parseInt(split1[1]);
            stars.add(new int[]{x, y});
        }

        int max = -1;
        for(int i = 0; i < stars.size(); i++){
            for(int j = 0; j < stars.size(); j++){
                int[] star1 = stars.get(i);
                int[] star2 = stars.get(j);
                int count = 0;
                for (int[] star : stars) {
                    if(star[0] >= star1[0] && star[0] <= star1[0] + l && star[1] >= star2[1] && star[1] <= star2[1] + l) count++;
                }
                max = Math.max(count, max);
            }
        }

        bw.append(String.valueOf(k - max));
        bw.flush();
        bw.close();
        br.close();
    }


}
