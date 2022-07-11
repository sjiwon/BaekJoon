package Silver4.baekjoon_10845;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String [] c = br.readLine().split(" ");
            switch(c[0]){
                case "push":
                    q.offer(Integer.parseInt(c[1]));
                    break;
                case "pop":
                    if(q.isEmpty())
                        bw.write(-1 + "\n");
                    else
                        bw.write(q.pollFirst() + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    if(q.isEmpty())
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                    break;
                case "front":
                    if(q.isEmpty())
                        bw.write(-1 + "\n");
                    else
                        bw.write(q.peekFirst() + "\n");
                    break;
                case "back":
                    if(q.isEmpty())
                        bw.write(-1 + "\n");
                    else
                        bw.write(q.peekLast() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
