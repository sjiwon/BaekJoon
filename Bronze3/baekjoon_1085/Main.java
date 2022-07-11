package Bronze3.baekjoon_1085;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int up = h-y;
        int down = y;
        int left = x;
        int right = w-x;

        bw.write(Math.min(Math.min(up, down), Math.min(left, right)) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
