package Bronze5.baekjoon_2475;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;

        while(st.hasMoreTokens()){
            sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }

        bw.write((sum%10) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
