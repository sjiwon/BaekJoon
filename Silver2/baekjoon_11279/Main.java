package Silver2.baekjoon_11279;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x>0){
                pq.offer(x);
            }
            else if(x==0){
                if(pq.size() == 0)
                    bw.write(0+"\n");
                else
                    bw.write(pq.poll()+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
