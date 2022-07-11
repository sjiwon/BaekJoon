package Silver4.baekjoon_18258;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String command = br.readLine();
            String[] arr = command.split(" ");
            switch(arr[0]){
                case "push":
                    dq.offer(Integer.parseInt(arr[1]));
                    break;
                case "pop":
                    if(dq.isEmpty())
                        bw.write("-1" + "\n");
                    else
                        bw.write(dq.pollFirst() + "\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    if(dq.isEmpty())
                        bw.write("1" + "\n");
                    else
                        bw.write("0" + "\n");
                    break;
                case "front":
                    if(dq.isEmpty())
                        bw.write("-1" + "\n");
                    else
                        bw.write(dq.peekFirst() + "\n");
                    break;
                case "back":
                    if(dq.isEmpty())
                        bw.write("-1" + "\n");
                    else
                        bw.write(dq.peekLast() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
