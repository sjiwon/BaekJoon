package Silver4.baekjoon_1021;

import java.io.*;
import java.util.*;
public class Main {
    static LinkedList<Integer> dq = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++)
            dq.offer(i);

        StringTokenizer num = new StringTokenizer(br.readLine());
        int [] arr = new int[M];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(num.nextToken());
        }

        int count = 0;
        for(int i=0; i<M; i++){
            while(dq.peekFirst() != arr[i]){
                if(dq.indexOf(arr[i]) <= dq.size() /2){
                    dq.offerLast(dq.pollFirst());
                }
                else{
                    dq.offerFirst(dq.pollLast());
                }
                count++;
            }
            dq.pollFirst();
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
