import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int d = Integer.parseInt(arr[1]);

        Map<Integer, List<ShortCut>> shortCuts = new LinkedHashMap<>();
        int[] way = new int[10001];

        int c = 0;
        while(c < n){
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int dis = Integer.parseInt(split[2]);

            if(end - start > dis) {
                if(shortCuts.containsKey(end)){
                    shortCuts.get(end).add(new ShortCut(start, dis));
                }else{
                    List<ShortCut> shortCutList = new ArrayList<>();
                    shortCutList.add(new ShortCut(start, dis));
                    shortCuts.put(end, shortCutList);
                }
            }

            c++;
        }


        c = 1;
        while(c <= d){
            way[c] = way[c - 1] + 1;
            if(shortCuts.containsKey(c)){
                for(ShortCut sc : shortCuts.get(c)){
                    int start = sc.start;
                    int dis = sc.distance;

                    way[c] = Math.min(way[start] + dis, way[c]);
                }
            }

            c++;
        }

        System.out.println(way[d]);




        bw.flush();
        bw.close();
        br.close();
    }


    static class ShortCut{
        public int start;
        public int distance;

        public ShortCut(int start, int distance) {
            this.start = start;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "ShortCut{" +
                    "start=" + start +
                    ", distance=" + distance +
                    '}';
        }
    }
}