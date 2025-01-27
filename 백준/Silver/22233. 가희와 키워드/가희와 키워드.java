import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, Integer> keyWords = new HashMap<>();
        int c = 0;
        while(c < n){
            keyWords.put(br.readLine(), 1);
            c++;
        }
        c = 0;

        while(c < m){
            String[] words = br.readLine().split(",");
            for(String word : words){
                keyWords.remove(word);
            }
            bw.append(Integer.toString(keyWords.size())).append("\n");
            c++;
        }
        bw.flush();
    }
}
