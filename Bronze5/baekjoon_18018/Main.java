package Bronze5.baekjoon_18018;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.parseInt(br.readLine()) - 543 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
