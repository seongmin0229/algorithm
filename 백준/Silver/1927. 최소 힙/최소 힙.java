import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int lastIdx = -1;
        while(n-- > 0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(lastIdx == -1){
                    bw.append('0').append("\n");
                }else{
                    bw.append(Integer.toString(arr[0])).append("\n");
                    arr[0] = arr[lastIdx--];
                    heapify(arr, 0, lastIdx);
                }
            }else{
                arr[++lastIdx] = x;
                heapifyUp(arr, lastIdx);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void heapify(int[] arr, int idx, int lastIdx){
        int leftChildIdx = idx * 2 + 1;
        int rightChildIdx = idx * 2 + 2;
        int smallestIdx = idx;

        if(leftChildIdx <= lastIdx && arr[leftChildIdx] < arr[smallestIdx]){
            smallestIdx = leftChildIdx;
        }

        if(rightChildIdx <= lastIdx && arr[rightChildIdx] < arr[smallestIdx]){
            smallestIdx = rightChildIdx;
        }

        if(idx != smallestIdx){
            swap(arr, idx, smallestIdx);
            heapify(arr, smallestIdx, lastIdx);
        }
    }

    public static void heapifyUp(int[] arr, int idx){
        while(idx > 0){
            int parentIdx = (idx - 1) / 2;
            if(arr[idx] < arr[parentIdx]){
                swap(arr, idx, parentIdx);
                idx = parentIdx;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}