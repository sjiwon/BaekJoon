package Gold4.baekjoon_17298;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] result; // 결과
    static int[] array; // input 저장 배열

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        result = new int[N];
        Arrays.fill(result, -1); // init

        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        solveProblem();
        for (int value : result) {
            bw.write(value + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void solveProblem() {
        Stack<Integer> stack = new Stack<>(); // push "index"

        for (int index = 0; index < N; index++) {
            while (!stack.isEmpty() && (array[stack.peek()] < array[index])) {
                result[stack.pop()] = array[index];
            }

            stack.push(index);
        }
    }
}