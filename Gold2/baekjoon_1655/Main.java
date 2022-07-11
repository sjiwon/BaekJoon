package Gold2.baekjoon_1655;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if (max.size() == min.size()) max.offer(num);
            else min.offer(num);

            if(!min.isEmpty() && !max.isEmpty() && (max.peek() > min.peek())){
                int tmp = min.poll();
                min.offer(max.poll());
                max.offer(tmp);
            }

            bw.write(max.peek()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
