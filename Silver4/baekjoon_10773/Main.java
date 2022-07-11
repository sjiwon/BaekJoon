package Silver4.baekjoon_10773;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> s = new Stack<>();
        int result = 0;

        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            int n = Integer.parseInt(br.readLine());
            if (n!=0)
                s.push(n);
            else
                s.pop();
        }
        while(!s.isEmpty())
            result += s.pop();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
