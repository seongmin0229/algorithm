import java.io.*;

public class Main {

    static int n;
    static int[] nums;
    static int[] operations;
    static final int PLUS = 0;
    static final int MINUS = 1;
    static final int MUL = 2;
    static final int DIV = 3;
    static int min;
    static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        operations = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        String[] numsStr = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        String[] operationsStr = br.readLine().split(" ");

        for(int i = 0; i < 4; i++){
            operations[i] = Integer.parseInt(operationsStr[i]);
        }

        backtracking(1, nums[0]);
        bw.append(String.valueOf(max));
        bw.append("\n");
        bw.append(String.valueOf(min));

        bw.flush();
        bw.close();
        br.close();

    }

    public static void backtracking(int index, int num){
        if(index == n) {
            if(num > max) max = num;
            if(num < min) min = num;
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operations[i] > 0){
                switch (i){
                    case PLUS:
                        operations[i] -= 1;
                        backtracking(index + 1, num + nums[index]);
                        operations[i] += 1;
                        break;
                    case MINUS:
                        operations[i] -= 1;
                        backtracking(index + 1, num - nums[index]);
                        operations[i] += 1;
                        break;
                    case MUL:
                        operations[i] -= 1;
                        backtracking(index + 1, num * nums[index]);
                        operations[i] += 1;
                        break;
                    case DIV:
                        operations[i] -= 1;
                        backtracking(index + 1, num / nums[index]);
                        operations[i] += 1;
                        break;
                }
            }
        }
    }
}
