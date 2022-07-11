package Silver5.baekjoon_1094;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.bitCount(Integer.parseInt(br.readLine())) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
