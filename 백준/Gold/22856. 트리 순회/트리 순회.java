import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int count;
    static Map<Integer, int[]> tree;
    static int root;
    static int endNode;
    static boolean endFlag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 내 아이디어
         * 중위순회 구현을 하는데, 루트 노드랑 종료 노드를 먼저 알고 시작해야함.
         * count -> left -> count -> count -> right -> count
         * 이런식으로 구현하되, 종단 노드에서 break하면 될듯
         */

        int n = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> children = new HashSet<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree.put(node, new int[]{left, right});

            allNodes.add(node);
            if(left != -1){
                children.add(left);
            }
            if(right != -1){
                children.add(right);
            }
        }

        // root 노드 구하기

        allNodes.removeAll(children);
        root = allNodes.iterator().next();

        // 종단점 구하기

        int cur = root;
        int count = 0;
        while(true){
            int[] child = tree.get(cur);
            if(child[1] != -1) {
                cur = child[1];
                count++;
            }
            else break;
        }

//        endNode = cur;
//        count = 0;
//        endFlag = false;
//        traversal(root);

        System.out.println(2 * (n - 1) - count);
    }


//    public static void traversal(int node){
//        int[] child = tree.get(node);
//        int left = child[0];
//        int right = child[1];
//
//        if(node == endNode) {
//            endFlag = true;
//            return;
//        }
//
//        if(left != -1){
//            count++;
//            traversal(left);
//            if(!endFlag) count++;
//        }
//        if(right != -1){
//            count++;
//            traversal(right);
//            if(!endFlag) count++;
//        }
//    }
}
