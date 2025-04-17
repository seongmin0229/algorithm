import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] buildings = new int[n][5];

        String[] line = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            buildings[i][0] = Integer.parseInt(line[i]);
            buildings[i][1] = -1;
            buildings[i][2] = -1;
            buildings[i][3] = 0;
            buildings[i][4] = 0;
        }

        for(int i = 1; i < n; i++){
            if(buildings[i][0] >= buildings[i - 1][0]){
                int preIdx = buildings[i - 1][1];
                while(preIdx != -1 && buildings[preIdx][0] <= buildings[i][0]){
                    preIdx = buildings[preIdx][1];
                }
                if(preIdx != -1){
                    buildings[i][1] = preIdx;
                    buildings[i][3] = buildings[preIdx][3] + 1;
                }
            }else{
                buildings[i][1] = i - 1;
                buildings[i][3] = buildings[i - 1][3] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(buildings[i][0] >= buildings[i + 1][0]){
                int nextIdx = buildings[i + 1][2];
                while(nextIdx != -1 && buildings[nextIdx][0] <= buildings[i][0]){
                    nextIdx = buildings[nextIdx][2];
                }
                if(nextIdx != -1){
                    buildings[i][2] = nextIdx;
                    buildings[i][4] = buildings[nextIdx][4] + 1;
                }
            }else{
                buildings[i][2] = i + 1;
                buildings[i][4] = buildings[i + 1][4] + 1;
            }
        }

        for(int i = 0; i < n; i++){
            if(buildings[i][1] == -1 && buildings[i][2] == -1) {
                bw.append("0\n");
                continue;
            }
            bw.append(String.valueOf(buildings[i][3] + buildings[i][4])).append(" ");
            if(buildings[i][1] == -1){
                bw.append(String.valueOf(buildings[i][2] + 1)).append("\n");
                continue;
            }
            if(buildings[i][2] == -1){
                bw.append(String.valueOf(buildings[i][1] + 1)).append("\n");
                continue;
            }
            int closerIdx;
            if(i - buildings[i][1] <= buildings[i][2] - i) closerIdx = buildings[i][1] + 1;
            else closerIdx = buildings[i][2] + 1;
            bw.append(String.valueOf(closerIdx)).append("\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }




}
