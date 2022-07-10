package Bronze2.baekjoon_1075;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = (N/100)*100; // 마지막 두자리 버리기

        while(N%F != 0){
            N++;
        }

        N%=100;

        if(N < 10)
            bw.write("0" + N + "\n");
        else
            bw.write(N + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
