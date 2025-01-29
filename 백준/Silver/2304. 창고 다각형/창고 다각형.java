import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10000];

        int n = Integer.parseInt(br.readLine());

        int end = -1;
        int start = 1001;
        int max = -1;
        while(n-- > 0){
            String[] lh = br.readLine().split(" ");

            int l = Integer.parseInt(lh[0]);
            int h = Integer.parseInt(lh[1]);
            if(end < l) end = l;
            if(start > l) start = l;
            if(max < h) max = h;
            arr[l] = h;
        }

        int extent = 0;
        int maxS = arr[start];
        int maxE = arr[end];
        boolean sFlag = true;
        boolean eFlag = true;
        while(sFlag || eFlag){
            if(maxS < arr[start]) maxS = arr[start];
            if(maxE < arr[end]) maxE = arr[end];
            if(sFlag) extent += maxS;
            if(eFlag) extent += maxE;
            if(maxS == max) sFlag = false;
            if(maxE == max) eFlag = false;
            if(sFlag) start++;
            if(eFlag) end--;
        }

        if(start != end){
            extent += (end - start - 1) * max;
        }
        if(start == end){
            extent -= max;
        }

        System.out.println(extent);

    }
}