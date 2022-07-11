package Silver5.baekjoon_1789;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        long sum = 0;
        int count = 0;
        int i = 0;
        while (sum <= N) {
            sum += ++i;
            count++;
        }

        bw.write(count-1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
