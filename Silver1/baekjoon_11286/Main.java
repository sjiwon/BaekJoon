package Silver1.baekjoon_11286;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2))
                    return 1;
                else if (Math.abs(o1)<Math.abs(o2))
                    return -1;
                else{
                    if(o1<o2)
                        return -1;
                    else if(o1>o2)
                        return 1;
                    else
                        return 0;
                }
            }
        });

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.size() == 0)
                    bw.write(0+"\n");
                else
                    bw.write(pq.poll()+"\n");
            }
            else
                pq.offer(x);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
