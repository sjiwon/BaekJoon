package Silver4.baekjoon_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int coin = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            int i = K/poll;

            if(i != 0){
                K -= i*poll;
                coin += i;
            }

            if(K == 0){
                break;
            }
        }

        System.out.println(coin);
    }
}

