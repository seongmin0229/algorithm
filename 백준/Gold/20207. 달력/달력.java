import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 아이디어
         * 영역이 잘리는 부분은 딱 일정이 없는 부분을 기준으로
         * 겹치는 일정은 어떻게 관리할거냐 ->
         * 각 일마다의 일정의 개수를 담는 배열을 만들고
         * 입력값이 start, end로 주어지면 그걸로 for문 돌려서 일정의 개수를 1개씩 늘리는 방식으로
         * 다 채웠으면, 그 배열을 모두 탐색해 영역의 넓이를 계산
         */

        int n = Integer.parseInt(br.readLine());

        int[] plans = new int[366];

        int answer = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for(int j = start; j <= end; j++){
                plans[j] += 1;
            }
        }

        int h = 0;
        int v = 0;

        for(int i = 1; i < 366; i++){
            if(plans[i] == 0){
                answer += h * v;
                h = 0;
                v = 0;
                continue;
            }

            h++;
            v = Math.max(v, plans[i]);

        }
        answer += h * v;

        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
