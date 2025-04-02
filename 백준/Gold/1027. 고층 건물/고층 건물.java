import java.io.*;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double[] buildings = new double[n];
        int[] view = new int[n];
        String[] line = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            buildings[i] = Integer.parseInt(line[i]);
        }

        for(int i = 0; i < n - 1; i++){
            int lastView = i + 1;
            view[i] += 1;
            view[i + 1] += 1;
            for(int j = i + 2; j < n; j++){
                if(buildings[j] > buildings[lastView] + ((buildings[lastView] - buildings[i]) / (lastView - i)) * (j - lastView)){
                    view[i] += 1;
                    view[j] += 1;
                    lastView = j;
                }
            }
        }

        bw.append(String.valueOf(Arrays.stream(view).max().getAsInt()));

        bw.flush();
        bw.close();
        br.close();
    }
}
