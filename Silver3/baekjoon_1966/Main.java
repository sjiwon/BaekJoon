package Silver3.baekjoon_1966;

import java.io.*;
import java.util.*;

public class Main {
    static class info{
        int index, impt;
        public info(int index, int impt){
            this.index = index;
            this.impt = impt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Queue<info> queue = new LinkedList<>();
        PriorityQueue<info> pq = new PriorityQueue<>(new Comparator<info>() {
            @Override
            public int compare(info o1, info o2) {
                return (o1.impt - o2.impt)*-1;
            }
        });

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int value = Integer.parseInt(st.nextToken());
                queue.offer(new info(j, value));
                pq.offer(new info(j, value));
            }

            int count = 0;
            while(true){
                if(queue.peek().impt == pq.peek().impt){
                    if(queue.peek().index == M) break;
                    else{
                        count++;
                        queue.poll();
                        pq.poll();
                    }
                }
                else
                    queue.offer(queue.poll());
            }
            queue.clear(); pq.clear();
            bw.write((count+1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
