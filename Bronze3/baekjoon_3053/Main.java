package Bronze3.baekjoon_3053;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double R = Integer.parseInt(br.readLine());

        bw.write(R*R*Math.PI + "\n");
        bw.write(R*R*2 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
