package Bronze5.baekjoon_10699;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));

        bw.write(now + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
