package Silver5.baekjoon_9655;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean flag = false;
        // 상근이가 돌 가져가면 false
        // 창영이가 돌 가져가면 true

        while (N != 0) {
            if (N > 3) {
                N -= 3;
                flag = !flag;
            }
            N -= 1;
            flag = !flag;
        }

        if(!flag)
            bw.write("CY");
        else
            bw.write("SK");
        bw.flush();
        bw.close();
        br.close();
    }
}
