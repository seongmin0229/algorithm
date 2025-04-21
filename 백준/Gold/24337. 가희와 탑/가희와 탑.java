import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int a = Integer.parseInt(split[1]);
        int b = Integer.parseInt(split[2]);

        if(a + b > n + 1) bw.append("-1");
        else{
            int pivot = Integer.max(a, b);
            List<Integer> numbers = new ArrayList<>();

            if(a == 1){
                numbers.add(pivot);
                for(int i = 0; i < n - a - b + 1; i++){
                    numbers.add(1);
                }
            }else{
                for(int i = 0; i < n - a - b + 1; i++){
                    numbers.add(1);
                }
                for(int i = 1; i < a; i++){
                    numbers.add(i);
                }
                numbers.add(pivot);
            }
            for(int i = b - 1; i > 0; i--){
                numbers.add(i);
            }
            for (Integer number : numbers) {
                bw.append(String.valueOf(number)).append(" ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }




}
